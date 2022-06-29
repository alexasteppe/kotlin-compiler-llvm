package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;

public class TypeNode implements ASTNode {
    private final String elementType;
    public TypeNode(String element) {
            this.elementType = element;
    }

    public String getElementType() {
        return elementType;
    }

    @Override
    public Node accept(ASTVisitor visitor) {
        return visitor.visitTypeNode(this);
    }
}
