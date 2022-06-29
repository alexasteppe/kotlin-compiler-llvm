package symtab;

import java.util.*;

public class SymbolTable implements Scope { // single-scope symtab
    Map<String, Symbol> symbols = new HashMap<>();

    public SymbolTable() {
        initTypeSystem();
    }

    protected void initTypeSystem() {
        define(new BuiltInTypeSymbol("Int"));
    }

    // Satisfy Scope interface
    public String getScopeName() {
        return "global";
    }

    public Scope getEnclosingScope() {
        return null;
    }

    public void define(Symbol sym) {
        symbols.put(sym.getName(), sym);
    }

    public Symbol resolve(String name) {
        return symbols.get(name);
    }

    public String toString() {
        return getScopeName() + ":" + symbols;
    }
}
