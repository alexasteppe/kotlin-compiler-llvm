package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

public class ComparisonNode extends StatementNode {

    private String leftOperand;
    private String rightOperand;
    private String condition;

    public ComparisonNode(){}

    public ComparisonNode(String left, String right, String condition) {
        this.leftOperand = left;
        this.rightOperand = right;
        this.condition = condition;
    }

    public String getLeftOperand() {
        return leftOperand;
    }

    public String getRightOperand() {
        return rightOperand;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitComparisonNode(this);
    }
}
