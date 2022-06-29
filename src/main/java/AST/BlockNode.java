package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

import java.util.List;

public class BlockNode implements ASTNode {
    private final List<StatementNode> statementNode;

    public BlockNode(List<StatementNode> statement) {
        this.statementNode = statement;
    }

    public List<StatementNode> getStatementNode() {
        return statementNode;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitBlockNode(this);
    }
}
