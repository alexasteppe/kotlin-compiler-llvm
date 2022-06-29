package visitor;

import AST.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class ToXMLVisitor implements ASTVisitor {
    private Document outputFile;

    @Override
    public Document visitStartNode(StartNode startNodeAST) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        try {
            documentBuilder = builderFactory.newDocumentBuilder();
            outputFile = documentBuilder.newDocument();
            Element root = outputFile.createElement("start");

            for (int i = 0; i < startNodeAST.getFunctionDefinition().size() - 1; i++) {
                root.appendChild(startNodeAST.getFunctionDefinition().get(i).accept(this));
            }
            outputFile.appendChild(root);
            return outputFile;
        } catch (ParserConfigurationException e) {
            System.out.println("Error at visitStartNode");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Node visitStatementNode(StatementNode statementNodeAST) {
        return statementNodeAST.accept(this);
    }

    @Override
    public Node visitFunctionDefinitionNode(FunctionDefinitionNode functionDefinitionNodeAST) {
        Element funcDefinition = outputFile.createElement("function");
        funcDefinition.setAttribute("name", functionDefinitionNodeAST.getFunctionName());
        if (functionDefinitionNodeAST.getFunctionArgumentNode() != null) {
            funcDefinition.appendChild(functionDefinitionNodeAST.getTypeNode().accept(this));
            funcDefinition.appendChild(functionDefinitionNodeAST.getFunctionArgumentNode().accept(this));
        }
        funcDefinition.appendChild(functionDefinitionNodeAST.getBlockNode().accept(this));
        return funcDefinition;
    }

    @Override
    public Node visitBlockNode(BlockNode blockNodeAST) {
        Element funcBody = outputFile.createElement("block");
        for (int i = 0; i < blockNodeAST.getStatementNode().size(); i++) {
            funcBody.appendChild(blockNodeAST.getStatementNode().get(i).accept(this));
        }
        return funcBody;
    }

    @Override
    public Node visitVarDeclarationNode(VarDeclarationNode varDeclarationNodeAST) {
        Element createVar = outputFile.createElement("declaration");
        Element id = outputFile.createElement("id");
        id.setTextContent(varDeclarationNodeAST.getVarName());
        Element type = outputFile.createElement("type");
        type.setTextContent(varDeclarationNodeAST.getTypeNode());
        Element value = outputFile.createElement("value");
        value.setTextContent(varDeclarationNodeAST.getVarValue());
        createVar.appendChild(id);
        createVar.appendChild(type);
        createVar.appendChild(value);
        return createVar;
    }

    @Override
    public Node visitReassignmentNode(ReassignmentNode reassignmentNodeAST) {
        Element reassignment = outputFile.createElement("reassignment");
        Element id = outputFile.createElement("id");
        Element newValue = outputFile.createElement("new_value");
        id.setTextContent(reassignmentNodeAST.getId());
        newValue.setTextContent(reassignmentNodeAST.getNewValue());
        reassignment.appendChild(id);
        reassignment.appendChild(newValue);
        return reassignment;
    }

    @Override
    public Node visitIfStatementNode(IfStatementNode ifStatementNodeAST) {
        Element block = outputFile.createElement("block");
        Element ifBlock = outputFile.createElement("if");
        ifBlock.appendChild(ifStatementNodeAST.getComparisonNode().accept(this));
        ifBlock.appendChild(ifStatementNodeAST.getBlockNode().accept(this));
        block.appendChild(ifBlock);
        if (ifStatementNodeAST.getElseStatementNode() != null) {
            Element elseBlock = outputFile.createElement("else");
            elseBlock.appendChild(ifStatementNodeAST.getElseStatementNode().accept(this));
            block.appendChild(elseBlock);
        }
        return block;
    }

    @Override
    public Node visitWhileNode(WhileNode whileNodeAST) {
        Element whileBlock = outputFile.createElement("while");
        whileBlock.appendChild(whileNodeAST.getConditionAST().accept(this));
        whileBlock.appendChild(whileNodeAST.getBodyAST().accept(this));
        return whileBlock;
    }

    @Override
    public Node visitReturnStatementNode(ReturnStatementNode returnStatementNodeAST) {
        Element returnStatement = outputFile.createElement("return");
        returnStatement.setAttribute("value", returnStatementNodeAST.getExpressionNode().getStatementNodes()
                .toString());
        return returnStatement;
    }

    @Override
    public Node visitFunctionArgumentNode(FunctionArgumentNode functionArgumentNodeAST) {
        Element args = outputFile.createElement("args");
        if (functionArgumentNodeAST.getArgs() == null) {
            Element noArgsFun = outputFile.createElement("no_args");
            args.appendChild(noArgsFun);
        } else {
            for (int i = 0; i < functionArgumentNodeAST.getArgs().size(); i++) {
                Element arg = outputFile.createElement("arg");
                if (functionArgumentNodeAST.getArgs().get(i).equals(":")) {
                    continue;
                }
                arg.setTextContent(functionArgumentNodeAST.getArgs().get(i));
                args.appendChild(arg);
            }
        }
        return args;
    }

    @Override
    public Node visitFunctionCallNode(FunctionCallNode functionCallNodeAST) {
        Element callFunc = outputFile.createElement("call_function");
        callFunc.setAttribute("name", functionCallNodeAST.getFunctionName());
        callFunc.appendChild(functionCallNodeAST.getFunctionArgumentNode().accept(this));
        return callFunc;
    }

    @Override
    public Node visitComparisonNode(ComparisonNode comparisonNodeAST) {
        Element condition = outputFile.createElement("condition");
        condition.setTextContent(comparisonNodeAST.getLeftOperand() + " "
                + comparisonNodeAST.getCondition() + " " + comparisonNodeAST.getRightOperand());
        return condition;
    }

    @Override
    public Node visitPrintNode(PrintNode outputNodeAST) {
        Element lineOutput = outputFile.createElement("print");
        lineOutput.setTextContent(outputNodeAST.getExpressionNode().getStatementNodes().toString());
        return lineOutput;
    }

    @Override
    public Node visitTypeNode(TypeNode typeNodeAST) {
        Element type = outputFile.createElement("return_value");
        type.setTextContent(typeNodeAST.getElementType());
        return type;
    }

    @Override
    public Node visitExpressionNode(ExpressionNode expressionNodeAST) {
        Element expression = outputFile.createElement("expression");
        Element target = outputFile.createElement("target");
        target.setTextContent(expressionNodeAST.getIdentifier());
        Element value = outputFile.createElement("value");
        StringBuilder content = new StringBuilder();

        for (String str : expressionNodeAST.getStatementNodes()) {
            content.append(str);
        }

        value.setTextContent(content.toString());
        expression.appendChild(target);
        expression.appendChild(value);
        return expression;
    }
}
