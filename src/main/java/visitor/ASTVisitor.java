package visitor;

import AST.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface ASTVisitor {
    Document visitStartNode(StartNode startNodeAST);
    Node visitStatementNode(StatementNode statementNodeAST);
    Node visitFunctionDefinitionNode(FunctionDefinitionNode functionDefinitionNodeAST);
    Node visitVarDeclarationNode(VarDeclarationNode varDeclarationNodeAST);
    Node visitBlockNode(BlockNode blockNodeAST);
    Node visitReassignmentNode(ReassignmentNode reassignmentNodeAST);
    Node visitIfStatementNode(IfStatementNode ifStatementNodeAST);
    Node visitWhileNode(WhileNode whileNodeAST);
    Node visitReturnStatementNode(ReturnStatementNode returnStatementNodeAST);
    Node visitFunctionArgumentNode(FunctionArgumentNode functionArgumentNodeAST);
    Node visitFunctionCallNode(FunctionCallNode functionCallNodeAST);
    Node visitComparisonNode(ComparisonNode comparisonNodeAST);
    Node visitPrintNode(PrintNode outputNodeAST);
    Node visitTypeNode(TypeNode typeNodeAST);
    Node visitExpressionNode(ExpressionNode expressionNodeAST);
}