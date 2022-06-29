import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Stack;

public class LLVM {
    static int reg = 1;

    private static String header_text = "";
    private static String main_text = "";
    private static String buffer = "";
    private static int str_i = 0;
    private static int main_reg = 1;
    private static int br = 0;

    private static int arraySize = 0;
    static Stack<Integer> br_stack = new Stack<>();


    static String generate(FileWriter file) {
        main_text += buffer;
        formatMainText();
        String text = "";
        text += "declare i32 @printf(i8*, ...)\n";
        text += "declare i32 @scanf(i8*, ...)\n";
        text += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n";
        text += "@strps = constant [4 x i8] c\"%s\\0A\\00\"\n";
        text += "@strsi = constant [3 x i8] c\"%d\\00\"\n";
        text += "@strsd = constant [4 x i8] c\"%lf\\00\"\n";
        text += "\n";
        text += header_text;
        try {
            file.write(text);
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    // functions
    static void function_start(String id, FileWriter file) {
        main_text += buffer;
        main_reg = reg;
        buffer = "define void @" + id + "() nounwind {\n";
        reg = 1;
    }

    static void function_end(FileWriter file) {
        buffer += "ret void\n";
        formatBuffer();
        buffer += "}\n\n";
        header_text += buffer;
//        try {
//            file.write(buffer);
//            file.flush();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        buffer = "";
        reg = main_reg;
    }

    static void call(String id) {
        buffer += "call void @" + id + "()\n";
    }

    // printf
    static void print(String text) {
        int str_len = text.length();
        String str_type = "[" + (str_len) + " x i8]";
        header_text += "@str" + str_i + " = constant" + str_type + " c\"" + text.replace("\"", "") + "\\0A\\00\"\n";
        buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( " + str_type + ", " + str_type + "* @str" + str_i + ", i32 0, i32 0))\n";
        str_i++;
        reg++;
    }

    static void printf_i32(String id, HashSet<String> globalNames) {
        if (globalNames.contains(id)) {
            buffer += "%" + reg + " = load i32, i32* @" + id + "\n";
        } else {
            buffer += "%" + reg + " = load i32, i32* %" + id + "\n";
        }
        reg++;
        buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %" + (reg - 1) + ")\n";
        reg++;
    }


    static void printf_string(String id, int length, HashSet<String> globalNames, String function) {
        if (globalNames.contains(id)) {
            buffer += "%" + reg + " = getelementptr inbounds [" + (length) + " x i8], [" + (length) + " x i8]* @" + id + ", i32 0, i32 0\n";
        } else {
            buffer += "%" + reg + " = getelementptr inbounds [" + (length) + " x i8], [" + (length) + " x i8]* @" + function + "." + id + ", i32 0, i32 0\n";
        }
        reg++;
        buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i32 0, i32 0), i8* %" + (reg - 1) + ")\n";
        reg++;
    }

    static void scanf_i32(String id, HashSet<String> globalNames) {
        assign_i32(id, "0");
        if (globalNames.contains(id)) {
            buffer += "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strsi, i32 0, i32 0), i32* %" + id + ")\n";
        } else {
            buffer += "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strsi, i32 0, i32 0), i32* %" + id + ")\n";
        }
        reg++;
    }

    // declare
    static void declare_i32(String id, boolean global, CodeGeneration.Value value) {
        if (global) {
            header_text += "@" + id + " = global i32 0\n";
        } else {
            buffer += "%" + id + " = alloca i32\n";
            buffer += "store i32 " + value.content + ", i32* %" + id + "\n";
        }
    }

    static void declare_i32(String id) {
        header_text += "@" + id + " = global i32 0\n";
    }

    static void decl_i32(String id) {
        buffer += "%" + id + " = alloca i32\n";
    }

    // assign
    static void assign_i32(String id, String value, HashSet<String> globalNames) {
        if (globalNames != null && globalNames.contains(id)) {
            buffer += "store i32 " + value + ", i32* @" + id + "\n";
        } else {
            buffer += "store i32 " + value + ", i32* %" + id + "\n";
        }
    }

    static void assign_i32(String id, String value) {
        buffer += "%" + id + " = alloca i32\n";
        buffer += "store i32 " + value + ", i32* %" + id + "\n";

    }

    static void assign_string(String id, String text, boolean global, String function) {
        int len = text.length();
        String str_type = "[" + len + " x i8]";
        if (global) {
            header_text += "@" + id + " = constant" + str_type + " c\"" + text + "\\00\"\n";
        } else {
            header_text += "@" + function + "." + id + " = constant" + str_type + " c\"" + text.replace("\"", "") + "\\0A\\00\"\n";
        }
    }

    static void add_i32(String val1, String val2) {
        buffer += "%" + reg + " = add i32 " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void mul_i32(String val1, String val2) {
        buffer += "%" + reg + " = mul i32 " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void sub_i32(String val1, String val2) {
        buffer += "%" + reg + " = sub i32 " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void div_i32(String val1, String val2) {
        buffer += "%" + reg + " = sdiv i32 " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void load_i32(String id, HashSet<String> globalNames) {
        if (globalNames != null && globalNames.contains(id)) {
            buffer += "%" + reg + " = load i32, i32* @" + id + "\n";
        } else {
            buffer += "%" + reg + " = load i32, i32* %" + id + "\n";
        }
        reg++;
    }

    static void icmp(String id, String value, HashSet<String> globalNames, KotlinLexerParser.ComparisonContext ctx) {
        load_i32(id, globalNames);
        icmpResult(value, globalNames, ctx);
    }

    static void icmpWhile(String id, String value, HashSet<String> globalNames, KotlinLexerParser.ComparisonContext ctx) {
        load_i32(id, globalNames);
        buffer += "br label %cond \n";
        buffer += "cond: \n";
        icmpResult(value, globalNames, ctx);
    }

    private static void icmpResult(String value, HashSet<String> globalNames, KotlinLexerParser.ComparisonContext ctx) {
        if (value.matches("\\d+")) {
            if (ctx.getChild(1) == ctx.EQEQ()) {
                buffer += "%" + reg + " = icmp eq i32 %" + (reg - 1) + ", " + value + "\n";
            } else if (ctx.getChild(1) == ctx.RANGLE()) {
                buffer += "%" + reg + " = icmp sgt i32 %" + (reg - 1) + ", " + value + "\n";
            } else if (ctx.getChild(1) == ctx.GE()) {
                buffer += "%" + reg + " = icmp sge i32 %" + (reg - 1) + ", " + value + "\n";
            } else if (ctx.getChild(1) == ctx.LANGLE()) {
                buffer += "%" + reg + " = icmp slt i32 %" + (reg - 1) + ", " + value + "\n";
            } else if (ctx.getChild(1) == ctx.LE()) {
                buffer += "%" + reg + " = icmp sle i32 %" + (reg - 1) + ", " + value + "\n";
            } else if (ctx.getChild(1) == ctx.EXCL_EQ()) {
                buffer += "%" + reg + " = icmp ne i32 %" + (reg - 1) + ", " + value + "\n";
            } else {
                System.err.println("Error, line " + ctx.getStart().getLine() + ", " + "unknown comparison token");
                System.exit(1);
            }
            reg++;
        } else {
            load_i32(value, globalNames);
            if (ctx.getChild(1) == ctx.EQEQ()) {
                buffer += "%" + reg + " = icmp eq i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
            } else if (ctx.getChild(1) == ctx.RANGLE()) {
                buffer += "%" + reg + " = icmp sgt i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
            } else if (ctx.getChild(1) == ctx.GE()) {
                buffer += "%" + reg + " = icmp sge i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
            } else if (ctx.getChild(1) == ctx.LANGLE()) {
                buffer += "%" + reg + " = icmp slt i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
            } else if (ctx.getChild(1) == ctx.LE()) {
                buffer += "%" + reg + " = icmp sle i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
            } else if (ctx.getChild(1) == ctx.EXCL_EQ()) {
                buffer += "%" + reg + " = icmp ne i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
            } else {
                System.err.println("Error, line " + ctx.getStart().getLine() + ", " + "unknown comparison token");
                System.exit(1);
            }
            reg++;
        }
    }

    static void if_start(KotlinLexerParser.ComparisonContext ctx) {
        br++;
        buffer += "br i1 %" + (reg - 1) + ", label %true" + br + ", label %false" + br + "\n";
        buffer += "true" + br + ":\n";
        br_stack.push(br);
    }

    static void if_end() {
        int b = br_stack.pop();
        buffer += "br label %false" + b + "\n";
        buffer += "false" + b + ":\n";
        br_stack.push(br);
    }

    static void while_start(String ID, HashSet<String> globalNames) {
        buffer += "br i1 %" + (reg - 1) + ", label %start, label %end \n";
        buffer += "start: \n";
        load_i32(ID, globalNames);
    }

    static void while_end() {
        buffer += "br label %cond \n";
        buffer += "end: \n";
    }

    static void arr(String id, int size, String[] value) {
        header_text += "@.str = private unnamed_addr constant [3 x i8] c\"%d\\00\"\n";
        arraySize = size;
        buffer += "%" + id + "= alloca [" + arraySize + "x i32] \n";
        //reg++;
        //buffer += "%" + reg + " = bitcast [" + arraySize + "x i32]* %" + id + " to i8* \n";
        //reg++;
//        %2 = getelementptr inbounds [4 x i32], [4 x i32]* %1, i64 0, i64 1, !dbg !17
//        store i32 10, i32* %2, align 4, !dbg !18
//                %3 = getelementptr inbounds [4 x i32], [4 x i32]* %1, i64 0, i64 2, !dbg !19
//        store i32 11, i32* %3, align 8, !dbg !20
//                %4 = getelementptr inbounds [4 x i32], [4 x i32]* %1, i64 0, i64 3, !dbg !21
//        store i32 12, i32* %4, align 4, !dbg !22
        for (int i = 0; i < value.length; i++) {
            buffer  +=  "%" + reg + " = getelementptr inbounds [" + arraySize + " x i32], [" + arraySize
            + " x i32]* %" + id + ", i64 0, i64 " + i + "\n";
            buffer += "store i32 " + value[i] + ", i32* %" + reg + "\n";
            reg++;
        }


    }
    static void array_init(String id, int size) {
        header_text += "@.str = private unnamed_addr constant [3 x i8] c\"%d\\00\"\n";
        arraySize = size;
        buffer += "%" + reg + "= alloca i32 \n"; //reg = 1
        buffer += "%" + id + "= alloca [" + arraySize + "x i32] \n"; //reg = 2
        int storeReg = reg;
        reg++;
        buffer += "%" + reg + "= alloca i32 \n"; //reg = 3
        int constReg = reg; //3
        //%3 = bitcast [4 x i32]* %1 to i8*
        //buffer += "%" + (reg + 1) + " = bitcast [" + arraySize + " x i32]* %" + id + "to i8*";
        //reg++;
        // store i32 0, i32* %3
        buffer += "store i32 11, i32* %" + reg + "\n";
        buffer += "br label %array_init \n";
        buffer += "array_init: \n";
        buffer += "%" + (reg + 1) + "= load i32, i32* %" + reg + "\n"; //reg + 1 = 4
        reg++; //reg = 4
        buffer += "%" + (reg + 1) + "= icmp sle i32 %" + reg + ", " + arraySize + "\n";
        reg++; // 5
        buffer += "br i1 %" + reg + ", label %init_start, label %init_end \n";
        buffer += "init_start: \n";
        reg++; //6
        buffer += "%" + reg + "= load i32, i32* %" + constReg + "\n";
        reg++; //7
        buffer += "%" + reg + "= load i32, i32* %" + constReg + "\n";
        reg++; //8
        buffer += "%" + reg + "= sext i32 %" + (reg - 1) + "to i64 \n";
        reg++; //9
        //%11 = getelementptr inbounds [100 x i32], [100 x i32]* %2, i64 0, i64 %10
        buffer += "%" + reg + "= getelementptr inbounds [" + arraySize + " x i32], [" + arraySize + " x i32]* %" + id
                + ", i64 0, i64 %" + (reg - 1) + "\n";
        buffer += "store i32 %" + (reg - 3) + ", i32* %" + reg + "\n";
        reg++; //10
        buffer += "%" + reg + "= load i32, i32* %" + constReg + "\n";
        reg++; //11
        buffer += "%" + reg + "= add nsw i32 %" + (reg - 1) + ", 1 \n";
        buffer += "store i32 %" + reg + ", i32* %" + constReg + "\n";
        buffer += "br label %array_init \n";
        buffer += "init_end: \n";
        reg++;
    }

    static void assignArray(String id, String index, String newValue) {
        if (Integer.parseInt(index) > arraySize || Integer.parseInt(index) < 0) {
            System.err.println("Array index out of bonds");
            System.exit(1);
        }
        buffer += "%" + reg + "= getelementptr inbounds [" + arraySize + " x i32], [" + arraySize + " x i32]* %" + id + ", i64 0, i64 " + index + "\n";
        buffer += "store i32 " + newValue + ", i32* %" + reg + "\n";
        reg++;
    }

    static void printArrayElement(String id, String index) {
        if (Integer.parseInt(index) > arraySize || Integer.parseInt(index) < 0) {
            System.err.println("Array index out of bonds");
            System.exit(1);
        }
        buffer += "%" + reg + " = getelementptr inbounds [" + arraySize + " x i32], [" + arraySize + " x i32]* %" +
                id + ", i64 0, i64 " + index + "\n";
        reg++;
        buffer += "load i32, i32* %" + (reg - 1) + "\n";
        reg++;
        buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0," +
                " i64 0), i32 %" + (reg - 1) + ")\n";
        reg++;
    }

    private static void formatBuffer() {
        String[] lines = buffer.split("\n");
        StringBuilder sb = new StringBuilder();
        sb.append(lines[0]).append("\n");
        for (int i = 1; i < lines.length; i++) {
            sb.append("  ").append(lines[i]).append("\n");
        }
        buffer = sb.toString();
    }

    private static void formatMainText() {
        String[] lines = main_text.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append("  ").append(line).append("\n");
        }
        main_text = sb.toString();
    }
}
