import AST.*;
import org.antlr.v4.runtime.tree.*;

import java.util.*;

public class GeneralVisitor implements KotlinLexerParserVisitor<ASTNode> {

    @Override
    public StartNode visitStart(KotlinLexerParser.StartContext ctx) {
        List<FunctionDefinitionNode> functionDefinitionNodes = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            functionDefinitionNodes.add((FunctionDefinitionNode) ctx.getChild(i).accept(this));
        }
        return new StartNode(functionDefinitionNodes);
    }

    @Override
    public BlockNode visitBlock(KotlinLexerParser.BlockContext ctx) {
        List<StatementNode> statements = new ArrayList<>(ctx.getChildCount());
        for (int i = 0; i < ctx.getChildCount(); i++) {
            statements.add((StatementNode) ctx.getChild(i).accept(this));
        }
        return new BlockNode(statements);
    }

    @Override
    public StatementNode visitStatement(KotlinLexerParser.StatementContext ctx) {
        return (StatementNode) ctx.getChild(0).accept(this);
    }

    @Override
    public ReassignmentNode visitRe_assignment(KotlinLexerParser.Re_assignmentContext ctx) {
        return new ReassignmentNode(ctx.Identifier().getText(), (ExpressionNode) ctx.getChild(KotlinLexerParser.ExprContext.class, 0).accept(this),
                ctx.expr().getText());
    }

    @Override
    public PrintNode visitPrint(KotlinLexerParser.PrintContext ctx) {
        return new PrintNode((ExpressionNode) ctx.getChild(KotlinLexerParser.ExprContext.class, 0).accept(this));
    }

    @Override
    public ExpressionNode visitExpr(KotlinLexerParser.ExprContext ctx) {
        List<String> expression = new ArrayList<>();
        //i = 2, count - 1
        for (int i = 0; i < ctx.getChildCount(); i++) {
            expression.add(ctx.getChild(i).getText());
        }
        return new ExpressionNode(ctx.expr().toString(), expression);
    }

    @Override
    public IfStatementNode visitIfStatement(KotlinLexerParser.IfStatementContext ctx) {
        BlockNode elseStatement = null;
        if (ctx.getChild(KotlinLexerParser.BlockContext.class, 1) != null) {
            elseStatement = (BlockNode) ctx.getChild(KotlinLexerParser.BlockContext.class, 1).accept(this);
        }
        return new IfStatementNode(
                (ComparisonNode) ctx.getChild(KotlinLexerParser.ComparisonContext.class, 0).accept(this),
                (BlockNode) ctx.getChild(KotlinLexerParser.BlockContext.class, 0).accept(this),
                elseStatement);
    }

    @Override
    public ASTNode visitWhile(KotlinLexerParser.WhileContext ctx) {
        return new WhileNode(
                (BlockNode) ctx.getChild(KotlinLexerParser.BlockContext.class, 0).accept(this),
                (ComparisonNode) ctx.getChild(KotlinLexerParser.ComparisonContext.class, 0).accept(this)
        );
    }

    @Override
    public ComparisonNode visitComparison(KotlinLexerParser.ComparisonContext ctx) {
        String leftOperand = ctx.getChild(0).getText();
        String condition = ctx.getChild(1).getText();
        String rightOperand = ctx.getChild(2).getText();
        return new ComparisonNode(
                leftOperand,
                rightOperand,
                condition
        );
    }

    @Override
    public VarDeclarationNode visitVariableDeclaration(KotlinLexerParser.VariableDeclarationContext ctx) {
        return new VarDeclarationNode(ctx.Identifier().getText(),
                ctx.getChild(3).getText(),
                ctx.getChild(5).getText());
    }

    @Override
    public ASTNode visitArrayDeclaration(KotlinLexerParser.ArrayDeclarationContext ctx) {
        return null;
    }

    @Override
    public TypeNode visitType(KotlinLexerParser.TypeContext ctx) {
        return new TypeNode(ctx.getChild(0).getText());
    }

    @Override
    public FunctionArgumentNode visitFunctionArgument(KotlinLexerParser.FunctionArgumentContext ctx) {
        List<String> args = new ArrayList<>(ctx.getChildCount()); //to check

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i).toString().equals(",")) {
                continue;
            }
            args.add(ctx.getChild(i).getText());
        }
        if (ctx.getChild(KotlinLexerParser.TypeContext.class, 0) == null && args.isEmpty()) {
            return new FunctionArgumentNode();
        } else if (!args.isEmpty()) {
            return new FunctionArgumentNode(args);
        } else {
            return new FunctionArgumentNode((TypeNode) ctx.getChild(KotlinLexerParser.TypeContext.class, 0).accept(this),
                    args);
        }
    }

    @Override
    public FunctionDefinitionNode visitFunctionDefinition(KotlinLexerParser.FunctionDefinitionContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ctx.getChild(i).accept(this);
        }
        if (ctx.getChild(KotlinLexerParser.TypeContext.class, 0) == null
                || ctx.getChild(KotlinLexerParser.FunctionArgumentContext.class, 0) == null) {
            return new FunctionDefinitionNode(ctx.Identifier().getText(),
                    (BlockNode) ctx.getChild(KotlinLexerParser.BlockContext.class, 0).accept(this));
        } else {
            return new FunctionDefinitionNode(
                    ctx.Identifier().getText(),
                    (FunctionArgumentNode) ctx.getChild(KotlinLexerParser.FunctionArgumentContext.class, 0).accept(this),
                    (TypeNode) ctx.getChild(KotlinLexerParser.TypeContext.class, 0).accept(this),
                    (BlockNode) ctx.getChild(KotlinLexerParser.BlockContext.class, 0).accept(this));
        }
    }

    @Override
    public ASTNode visitFunctionCall(KotlinLexerParser.FunctionCallContext ctx) {
        return new FunctionCallNode(
                ctx.Identifier().toString(),
                (FunctionArgumentNode) ctx.getChild(KotlinLexerParser.FunctionArgumentContext.class, 0).accept(this)
        );
    }

    @Override
    public ASTNode visitReturnStatement(KotlinLexerParser.ReturnStatementContext ctx) {
        return new ReturnStatementNode((ExpressionNode) ctx.getChild(KotlinLexerParser.ExprContext.class, 0).accept(this));
    }

    @Override
    public StartNode visit(ParseTree parseTree) {
        if (parseTree instanceof KotlinLexerParser.StartContext) {
            return visitStart((KotlinLexerParser.StartContext) parseTree);
        } else {
            System.out.println("Invalid program!");
            return null;
        }
    }

    @Override
    public ASTNode visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public ASTNode visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public ASTNode visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}


//    @Override
//    public ComparisonNode visitGreaterOrEqual(KotlinLexerParser.GreaterOrEqualContext ctx) {
//        String leftOperand = ctx.getChild(0).getText();
//        String condition = ctx.getChild(1).getText();
//        String rightOperand = ctx.getChild(2).getText();
//        return new ComparisonNode(
//                leftOperand,
//                rightOperand,
//                condition
//        );
//    }
//
