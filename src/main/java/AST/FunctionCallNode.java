package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

public class FunctionCallNode extends StatementNode {

    private final String functionName;
    private final FunctionArgumentNode functionArgumentNode;

    public FunctionCallNode(String funName, FunctionArgumentNode
            functionArgument) {
        this.functionName = funName;
        this.functionArgumentNode = functionArgument;
    }

    public String getFunctionName() {
        return functionName;
    }

    public FunctionArgumentNode getFunctionArgumentNode() {
        return functionArgumentNode;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitFunctionCallNode(this);
    }
}
