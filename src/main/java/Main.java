import org.apache.commons.cli.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Options options = new Options();

        Option tokens = new Option("tokens", "dump-tokens", true,
                "display the result of the lexical analyzer");
        tokens.setOptionalArg(true);
        options.addOption(tokens);

        Option ast = new Option("ast", "dump-ast", true, "display AST");
        ast.setOptionalArg(true);
        options.addOption(ast);

        Option asm = new Option("asm", "dump-asm", true, "display assembler");
        asm.setOptionalArg(true);
        options.addOption(asm);

        CommandLineParser parserLine = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parserLine.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Kotlin Compiler", options);

            System.exit(1);
        }

        String inputFilePath;
        boolean isToken = false;
        boolean isAst = false;
        boolean isAsm = false;

        if (cmd.hasOption("dump-tokens")) {
            inputFilePath = cmd.getOptionValue("dump-tokens");
            isToken = true;
        } else if (cmd.hasOption("dump-ast")) {
            inputFilePath = cmd.getOptionValue("dump-ast");
            isAst = true;
        } else if (cmd.hasOption("dump-asm")) {
            inputFilePath = cmd.getOptionValue("dump-asm");
            isAsm = true;
        } else inputFilePath = args[0];

        FileDataProvider provider = new FileDataProvider(inputFilePath);
        TestDataSupplier supplier = new TestDataSupplier();
        Logic logic = new Logic(provider, supplier, isToken, isAst, isAsm);
        try {
            logic.callMe();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
