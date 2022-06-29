package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

public class VarDeclarationNode extends StatementNode {

    private final String typeNode;
    private final String varName;
    private final String varValue;

    public VarDeclarationNode(String name, String type, String value) {
        this.typeNode = type;
        this.varName = name;
        this.varValue = value;
    }

    public String getTypeNode() {
        return typeNode;
    }

    public String getVarName() {
        return varName;
    }

    public String getVarValue() {
        return varValue;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitVarDeclarationNode(this);
    }
}
