package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

public class PrintNode extends StatementNode implements ASTNode {
    private final ExpressionNode expressionNode;

    public PrintNode(ExpressionNode expression) {
        this.expressionNode = expression;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitPrintNode(this);
    }
}
