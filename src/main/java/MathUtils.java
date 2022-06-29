import java.util.*;

class MathUtils {
    static CodeGeneration.Value eval(Queue<String> infix, HashSet<String> globalNames, HashMap<String,
            CodeGeneration.Value> variables) {
        Queue<String> rpn = infixToRpn(intToReal(infix));
        Stack<String> stack = new Stack<>();

        for (String item : rpn) {
            switch (item) {
                case "+":
                    LLVM.add_i32(stack.pop(), stack.pop());
                    stack.push("%" + (LLVM.reg - 1));
                    break;
                case "-":
                    String s1 = stack.pop();
                    String s2 = stack.pop();
                    LLVM.sub_i32(s2, s1);
                    stack.push("%" + (LLVM.reg - 1));
                    break;
                case "*":
                    LLVM.mul_i32(stack.pop(), stack.pop());
                    stack.push("%" + (LLVM .reg - 1));
                    break;
                case "/":
                    String d1 = stack.pop();
                    String d2 = stack.pop();
                    LLVM.div_i32(d2, d1);
                    stack.push("%" + (LLVM.reg - 1));
                    break;
                default:
                    if (isNumeric(item)) {
                        stack.push(item);
                    } else {
                        handleVariable(item, stack, variables, globalNames);
                    }
                    break;
            }
        }
        return new CodeGeneration.Value("%" + (LLVM.reg - 1), CodeGeneration.VarType.INT);
    }
    private static void handleVariable(String item, Stack<String> stack,
                                       HashMap<String, CodeGeneration.Value> variables, HashSet<String> globalNames) {
        if (variables.containsKey(item)) {
            CodeGeneration.Value value = variables.get(item);
            if (value.type == CodeGeneration.VarType.INT) {
                LLVM.load_i32(item, globalNames);
            } else {
                throw new RuntimeException("Unknown variable: " + item);
            }
            stack.push("%" + (LLVM.reg - 1));
        } else {
            throw new RuntimeException("Unknown variable: " + item);
        }
    }

    private static Queue<String> intToReal(Queue<String> ints) {
        Queue<String> reals = new LinkedList<>();
        for (String item : ints) {
            if (isInteger(item)) {
                int d =  Integer.parseInt(item);
                reals.add(String.valueOf(d));
            } else {
                reals.add(item);
            }
        }
        return reals;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static Queue<String> infixToRpn(Queue<String> infix) {
        Queue<String> rpn = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        for (String item : infix) {
            switch (item) {
                case "+":
                case "-":
                    while (!stack.empty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        rpn.add(stack.pop());
                    }
                    stack.push(item);
                    break;
                case "*":
                case "/":
                case "(":
                    stack.push(item);
                    break;
                case ")":
                    while (!stack.empty() && !stack.peek().equals("(")) {
                        rpn.add(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    rpn.add(item);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            rpn.add(stack.pop());
        }
        return rpn;
    }

    static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
