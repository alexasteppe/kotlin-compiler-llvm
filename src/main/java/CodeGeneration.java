import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CodeGeneration extends KotlinLexerParserBaseListener {
    public CodeGeneration() throws IOException {
    }

    enum VarType {STRING, INT}

    static class Value {
        String content;
        VarType type;

        Value(String content, VarType type) {
            this.content = content;
            this.type = type;
        }
    }

    private final HashMap<String, Value> variables = new HashMap<>();
    private final HashSet<String> globalNames = new HashSet<>();
    private HashSet<String> localNames = new HashSet<>();
    private Queue<String> infixExpr = new LinkedList<>();
    private boolean global = true;
    private String function = "";

    String examplefile = "/Users/alexasteppe/IdeaProjects/KotlinCompiler/examples/example.kt";
    String nameWithoutExt = examplefile.split("\\.")[0];
    FileWriter writer = new FileWriter(nameWithoutExt + ".ll", false);

    @Override
    public void enterFunctionDefinition(KotlinLexerParser.FunctionDefinitionContext ctx) {
        global = false;
        function = ctx.Identifier().getText();
        LLVM.function_start(function, writer);
    }

    @Override
    public void exitFunctionDefinition(KotlinLexerParser.FunctionDefinitionContext ctx) {
        global = true;
        LLVM.function_end(writer);
        removeLocalVariables();
        localNames = new HashSet<>();
    }

    @Override
    public void enterFunctionCall(KotlinLexerParser.FunctionCallContext ctx) {
        String ID = ctx.Identifier().getText();
        LLVM.call(ID);
    }

    @Override
    public void exitVariableDeclaration(KotlinLexerParser.VariableDeclarationContext ctx) {
        String ID = ctx.Identifier().getText();
        // System.out.println(infixExpr);
        // System.out.println(ctx.expr().READ());
        if (ctx.expr().oper == null && ctx.expr().READ() == null) {
            Value value = getValue(ctx.expr());
            if (Objects.equals(ctx.type().getText(), "Int") || Objects.equals(ctx.type().getText(), "String")) {
                declareVariable(ID, value);
                if (ctx.expr().StringLiteral() != null) {
                    assignVariable(ID, value, ctx.getStart().getLine());
                }
            } else error(ctx.getStart().getLine(), "Invalid input");
        } else if (ctx.expr().READ() != null) {
            if (!variables.containsKey(ID)) {
                if (global) {
                    globalNames.add(ID);
                }
                //LLVM.decl_i32(ID);
                LLVM.scanf_i32(ID, globalNames);
                variables.put(ID, new Value(ID, VarType.INT));
            } else {
                LLVM.scanf_i32(ID, globalNames);
            }
        } else {
            System.out.println(infixExpr);
            Value value = MathUtils.eval(infixExpr, globalNames, variables);
            declareVariable(ID, value);
            infixExpr = new LinkedList<>();
        }
    }

    @Override
    public void enterArrayDeclaration(KotlinLexerParser.ArrayDeclarationContext ctx) {
        String ID = ctx.Identifier().getText();
        //String value = getValue(ctx.functionArgument().expr().toString());
        String args = ctx.functionArgument().getText();
        String[] tokens = args.split(",");
        int size = 0;
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                size++;
            } else {
                error(ctx.getStart().getLine(), "Array can be INT only");
            }
        }
        System.out.println(size);
        LLVM.arr(ID, size, tokens);
        //System.out.println(size);

        //System.out.println(ctx.functionArgument().getText());
        //System.out.println(ID);
    }

    @Override
    public void exitRe_assignment(KotlinLexerParser.Re_assignmentContext ctx) {
        String ID = ctx.Identifier().getText();
        if (ctx.expr().oper == null && ctx.LSQUARE() == null) {
            Value value = getValue(ctx.expr());
            assignVariable(ID, value, ctx.getStart().getLine());
        } else if (ctx.LSQUARE() != null) {
            //System.out.println(ctx.expr().getText());
            String index = ctx.IntegerLiteral().getText();
            String newVal = ctx.expr().getText();
            LLVM.assignArray(ID, index, newVal);
        } else {
            Value value = MathUtils.eval(infixExpr, globalNames, variables);
            assignVariable(ID, value, ctx.getStart().getLine());
        }
    }

    @Override
    public void exitExpr(KotlinLexerParser.ExprContext ctx) {
        if (ctx.ADD() != null || ctx.SUB() != null
                || ctx.MULT() != null || ctx.DIV() != null) {
//            System.out.println("1 : \n");
//            System.out.println(ctx.getChild(1) + "\n\n");
            infixExpr.add(ctx.getChild(1).getText());
        } else if (ctx.READ() == null && ctx.while_() == null && ctx.StringLiteral() == null) {
//            System.out.println("2: \n");
//            System.out.println(ctx.getText());
            infixExpr.add(ctx.getText());
        }
    }

    @Override
    public void enterIfStatement(KotlinLexerParser.IfStatementContext ctx) {
        String leftOperand = ctx.comparison().expr(0).getText();
        String rightOperand = ctx.comparison().expr(1).getText();
        if (variables.containsKey(leftOperand)) {
            if (variables.get(leftOperand).type == VarType.INT) {
                LLVM.icmp(leftOperand, rightOperand, globalNames, ctx.comparison());
            } else {
                error(ctx.getStart().getLine(), "value must be an integer");
            }
        } else {
            error(ctx.getStart().getLine(), "Unknown variable: " + leftOperand);
        }
        LLVM.if_start(ctx.comparison());
    }

    @Override
    public void exitIfStatement(KotlinLexerParser.IfStatementContext ctx) {
        LLVM.if_end();
    }

    @Override
    public void enterWhile(KotlinLexerParser.WhileContext ctx) {
        String leftOperand = ctx.comparison().expr(0).getText();
        String rightOperand = ctx.comparison().expr(1).getText();
        if (variables.containsKey(leftOperand)) {
            if (variables.get(leftOperand).type == VarType.INT) {
                LLVM.icmpWhile(leftOperand, rightOperand, globalNames, ctx.comparison());
            } else {
                error(ctx.getStart().getLine(), "value must be an integer");
            }
        } else {
            error(ctx.getStart().getLine(), "WHILE Unknown variable: " + leftOperand);
        }
        LLVM.while_start(leftOperand, globalNames);
    }

    public void exitWhile(KotlinLexerParser.WhileContext ctx) {
        LLVM.while_end();
    }

    @Override
    public void exitStart(KotlinLexerParser.StartContext ctx) {
        System.out.println(LLVM.generate(writer));
    }

    @Override
    public void exitPrint(KotlinLexerParser.PrintContext ctx) {
        String ID = ctx.expr().get(0).getText();
        //System.out.println(Arrays.toString(ctx.expr().toArray()));
        if (variables.containsKey(ID)) {
            printVariable(ID);
        } else {
            printConstant(ctx.expr().get(0), ID);
        }
    }


    private Value getValue(KotlinLexerParser.ExprContext ctx) {
        if (ctx.IntegerLiteral() != null) {
            return new Value(ctx.IntegerLiteral().getText(), VarType.INT);
        } else if (ctx.StringLiteral() != null) {
            return new Value(getTextWithoutQuotes(ctx), VarType.STRING);
        } else {
            Value declaredValue = variables.get(ctx.Identifier().getText());
            if (declaredValue == null) {
                error(ctx.getStart().getLine(), "Invalid value.");
                return null;
            } else {
                return new Value(ctx.Identifier().getText(), declaredValue.type);
            }
        }
    }

    private void declareVariable(String ID, Value value) {
        if (!variables.containsKey(ID)) {
            if (value.type != VarType.STRING) {
                variables.put(ID, value);
            }
            if (value.type == VarType.INT) {
                LLVM.declare_i32(ID, global, value);
            }
        }
    }

    private void assignVariable(String ID, Value value, int line) {
        if (global) {
            globalNames.add(ID);
        } else if (!globalNames.contains(ID)) {
            localNames.add(ID);
        }

        if (Objects.equals(value.type, VarType.INT)) {
            LLVM.assign_i32(ID, getValue(value), globalNames);
        } else if (Objects.equals(value.type, VarType.STRING)) {
            assignString(ID, value);
        } else {
            error(line, "Assign error: " + ID);
        }
    }

    private String getValue(Value value) {
        return "" + (value.content);
    }

    private void assignString(String ID, Value value) {
        if (!variables.containsKey(ID)) {
            LLVM.assign_string(ID, value.content, global, function);
            variables.put(ID, value);
        }
    }

    private void printConstant(KotlinLexerParser.ExprContext ctx, String ID) {
        if (ctx.getChild(1) == ctx.StringLiteral() || ctx.StringLiteral() != null) {
            LLVM.print(getTextWithoutQuotes(ctx));
        } else if (ctx.LSQUARE() != null) {
            String index = ctx.IntegerLiteral().getText();
            LLVM.printArrayElement(ctx.Identifier().getText(), index);
        } else LLVM.printf_i32(ctx.getText(), globalNames);
    }

    private void printVariable(String ID) {
        if (variables.get(ID).type == VarType.INT) {
            LLVM.printf_i32(ID, globalNames);
        } else if (variables.get(ID).type == VarType.STRING) {
            LLVM.printf_string(ID, variables.get(ID).content.length(), globalNames, function);
        }
    }

    private String getTextWithoutQuotes(KotlinLexerParser.ExprContext ctx) {
        return ctx.getChild(0).toString();
    }


    private void removeLocalVariables() {
        for (String id : localNames) {
            variables.remove(id);
        }
    }

    private void error(int line, String msg) {
        System.err.println("Error, line " + line + ", " + msg);
        System.exit(1);
    }

}
