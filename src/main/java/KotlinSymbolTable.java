import symtab.*;

public class KotlinSymbolTable extends KotlinLexerParserBaseListener {
    protected BasicScope globals;
    protected Scope currentScope = null;

    @Override
    public void enterStart(KotlinLexerParser.StartContext ctx) {
        globals = new BasicScope(null);
        currentScope = globals;
        ctx.scope = currentScope;
    }

    @Override
    public void exitStart(KotlinLexerParser.StartContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterFunctionDefinition(KotlinLexerParser.FunctionDefinitionContext ctx) {
        String funcName = ctx.Identifier().getText();
        FunctionSymbol s = new FunctionSymbol(funcName, currentScope);
        currentScope.define(s);
        currentScope = s;
        ctx.scope = currentScope;
    }

    @Override
    public void exitFunctionDefinition(KotlinLexerParser.FunctionDefinitionContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterBlock(KotlinLexerParser.BlockContext ctx) {
        currentScope = new BasicScope(currentScope);
        ctx.scope = currentScope;
    }

    @Override
    public void exitBlock(KotlinLexerParser.BlockContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    // Handle defs

    @Override
    public void enterVariableDeclaration(KotlinLexerParser.VariableDeclarationContext ctx) {
        String varName = ctx.Identifier().getText();
        VariableSymbol sym = new VariableSymbol(varName);
        currentScope.define(sym);
    }

    @Override
    public void enterFunctionArgument(KotlinLexerParser.FunctionArgumentContext ctx) {
        String argName = ctx.Identifier().toString();
        VariableSymbol sym = new VariableSymbol(argName);
        currentScope.define(sym);
    }

    @Override
    public void enterExpr(KotlinLexerParser.ExprContext ctx) {
        if (ctx.Identifier() != null) {
            String varName = ctx.Identifier().getText();
            Symbol sym = currentScope.resolve(varName);
            if (sym == null) {
                System.err.println("No such var: " + varName);
            }
        }
    }
}