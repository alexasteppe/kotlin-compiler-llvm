import AST.StartNode;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.Document;
import visitor.ToXMLVisitor;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logic extends KotlinLexerParserBaseListener {
    DataProvider provider;
    TestDataSupplier supplier;
    Boolean token;
    Boolean ast;
    Boolean asm;

    Logic(DataProvider provider, TestDataSupplier supplier, Boolean token, Boolean ast, Boolean asm) {
        this.provider = provider;
        this.supplier = supplier;
        this.token = token;
        this.ast = ast;
        this.asm = asm;
    }

    void callMe() throws IOException {

        KotlinLexer lexer = new KotlinLexer(provider.getText());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KotlinLexerParser parser = new KotlinLexerParser(tokens);
        ParseTree tree = parser.start();

        if (token) {
            for (int i = 1; i <= tokens.getNumberOfOnChannelTokens(); i++) {
                String result = "Loc=<" + tokens.LT(i).getLine() + ":" + tokens.LT(i).getCharPositionInLine() + ">   " +
                        lexer.getVocabulary().getSymbolicName(tokens.LT(i).getType()) + "'" + tokens.LT(i).getText() + "'";
                supplier.accept(result);
            }
        } else if (ast) {
            lexer.addErrorListener(new KotlinError());

            // KotlinLexerParser parser = new KotlinLexerParser(tokens);
            parser.addErrorListener(new KotlinError());
//            ParseTree tree = parser.start();

            ParseTreeWalker walker = new ParseTreeWalker();
            KotlinSymbolTable kotlinSymbolTable = new KotlinSymbolTable();
            walker.walk(kotlinSymbolTable, tree);

            GeneralVisitor visitor = new GeneralVisitor();
            StartNode ast = visitor.visit(tree);

            ToXMLVisitor xmlVisitor = new ToXMLVisitor();
            Document document = xmlVisitor.visitStartNode(ast);
            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "2");
                DOMSource source = new DOMSource(document);

                StreamResult console = new StreamResult(System.out);
                // StreamResult file = new StreamResult(new File("/Users/alexasteppe/IdeaProjects/KotlinCompiler/src/main/java"));

                transformer.transform(source, console);
                //  transformer.transform(source, file);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ParseTreeWalker walker = new ParseTreeWalker();

        if (asm) {
            lexer.addErrorListener(new KotlinError());
            parser.addErrorListener(new KotlinError());
            walker.walk(new CodeGeneration(), tree);
        }
    }
}

//--dump-asm /Users/alexasteppe/IdeaProjects/KotlinCompiler/examples/example.kt