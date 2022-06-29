package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

public class IfStatementNode extends StatementNode {
    final private ComparisonNode comparisonNode;
    final private BlockNode blockNode;
    final private BlockNode elseStatementNode;

    public IfStatementNode(ComparisonNode comparison, BlockNode block, BlockNode
            elseStatement) {
        this.comparisonNode = comparison;
        this.blockNode = block;
        this.elseStatementNode = elseStatement;
    }

    public ComparisonNode getComparisonNode() {
        return comparisonNode;
    }
    public BlockNode getBlockNode() {
        return blockNode;
    }

    public BlockNode getElseStatementNode() {
        return elseStatementNode;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitIfStatementNode(this);
    }
}
