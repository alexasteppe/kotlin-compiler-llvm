package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

import java.util.List;

public class ExpressionNode extends StatementNode {
    private final String identifier;
    private final List<String> statementNodes;

    public ExpressionNode(String id, List<String> statement) {
        this.identifier = id;
        this.statementNodes = statement;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<String> getStatementNodes() {
        return statementNodes;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitExpressionNode(this);
    }
}
