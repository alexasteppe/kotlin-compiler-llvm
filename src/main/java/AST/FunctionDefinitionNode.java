package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

public class FunctionDefinitionNode extends StatementNode {

    private TypeNode typeNode;
    private String functionName;
    private FunctionArgumentNode functionArgumentNode;
    private BlockNode blockNode;

    public FunctionDefinitionNode(){}

    public FunctionDefinitionNode(String functionName, BlockNode block) {
        this.blockNode = block;
        this.functionName = functionName;
    }

    public FunctionDefinitionNode(String functionName, FunctionArgumentNode arg, TypeNode type, BlockNode block) {
        this.functionArgumentNode = arg;
        this.typeNode = type;
        this.blockNode = block;
        this.functionName = functionName;
    }

    public FunctionArgumentNode getFunctionArgumentNode() {
        return functionArgumentNode;
    }

    public TypeNode getTypeNode() {
        return typeNode;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    public String getFunctionName() {
        return functionName;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
            return visitor.visitFunctionDefinitionNode(this);
    }
}
