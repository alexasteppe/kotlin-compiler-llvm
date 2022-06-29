package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

import java.util.List;

public class FunctionArgumentNode implements ASTNode {

    List<String> args;
    TypeNode typeNode;

    public FunctionArgumentNode(){}

    public FunctionArgumentNode(List<String> arguments) {
        this.args = arguments;
    }

    public FunctionArgumentNode(TypeNode type, List<String> arguments) {
        this.args = arguments;
        this.typeNode = type;
    }

    public List<String> getArgs() {
        return args;
    }

    public TypeNode getTypeNode() {
        return typeNode;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitFunctionArgumentNode(this);
    }
}
