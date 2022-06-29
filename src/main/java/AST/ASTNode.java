package AST;

import org.w3c.dom.Node;
import visitor.ASTVisitor;


public interface ASTNode {
    Node accept(ASTVisitor visitor);
}

