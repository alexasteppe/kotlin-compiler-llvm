package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

public class WhileNode extends StatementNode {
    private final BlockNode bodyAST;
    private final ComparisonNode conditionAST;

    public WhileNode(BlockNode bodyAST, ComparisonNode conditionAST) {
        this.bodyAST = bodyAST;
        this.conditionAST = conditionAST;
    }

    public BlockNode getBodyAST() {
        return bodyAST;
    }

    public ComparisonNode getConditionAST() {
        return conditionAST;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitWhileNode(this);
    }
}
