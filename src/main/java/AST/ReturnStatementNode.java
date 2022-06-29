package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

public class ReturnStatementNode extends StatementNode {
    private final ExpressionNode expressionNode;

    public ReturnStatementNode(ExpressionNode expression) {
        this.expressionNode = expression;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitReturnStatementNode(this);
    }
}
