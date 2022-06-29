package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

public class ReassignmentNode extends StatementNode {
    private final String id;
    private final String newValue;
    private final ExpressionNode expressionNode;

    public ReassignmentNode(String id, ExpressionNode expression, String value) {
        this.id = id;
        this.expressionNode = expression;
        this.newValue = value;
    }

    public String getId() {
        return id;
    }

    public String getNewValue() {
        return newValue;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitReassignmentNode(this);
    }
}
