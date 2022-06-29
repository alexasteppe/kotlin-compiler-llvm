package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

import java.util.List;

public class StartNode implements ASTNode {
    private final List<FunctionDefinitionNode> functionDefinition;

    public StartNode(List<FunctionDefinitionNode> function) {
        this.functionDefinition = function;
    }

    public List<FunctionDefinitionNode> getFunctionDefinition() {
        return functionDefinition;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitStartNode(this);
    }
}
