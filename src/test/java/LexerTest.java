import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class LexerTest {

    @Test
    public void lexerTest() {
        MockedDataProvider provider = new MockedDataProvider(
                "fun main() {\n" +
                        "    var a: Int = 10\n" +
                        "\n" +
                        "    if (a * 2 == 10) {\n" +
                        "        var b: Int = 2 * 3\n" +
                        "    } else {\n" +
                        "        var b: Int = 11\n" +
                        "        print(b)\n" +
                        "    }\n" +
                        "}\n");
        TestDataSupplier supplier = new TestDataSupplier();
        Logic logic = new Logic(provider, supplier, true, false, false);
        try {
            logic.callMe();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String test = supplier.getTest();
        String expected = "Loc=<1:0>   FUN'fun'\n" +
                "Loc=<1:4>   Identifier'main'\n" +
                "Loc=<1:8>   LPAREN'('\n" +
                "Loc=<1:9>   RPAREN')'\n" +
                "Loc=<1:11>   LCURL'{'\n" +
                "Loc=<2:4>   VAR'var'\n" +
                "Loc=<2:8>   Identifier'a'\n" +
                "Loc=<2:9>   COLON':'\n" +
                "Loc=<2:11>   INT'Int'\n" +
                "Loc=<2:15>   ASSIGNMENT'='\n" +
                "Loc=<2:17>   IntegerLiteral'10'\n" +
                "Loc=<4:4>   IF'if'\n" +
                "Loc=<4:7>   LPAREN'('\n" +
                "Loc=<4:8>   Identifier'a'\n" +
                "Loc=<4:10>   MULT'*'\n" +
                "Loc=<4:12>   IntegerLiteral'2'\n" +
                "Loc=<4:14>   EQEQ'=='\n" +
                "Loc=<4:17>   IntegerLiteral'10'\n" +
                "Loc=<4:19>   RPAREN')'\n" +
                "Loc=<4:21>   LCURL'{'\n" +
                "Loc=<5:8>   VAR'var'\n" +
                "Loc=<5:12>   Identifier'b'\n" +
                "Loc=<5:13>   COLON':'\n" +
                "Loc=<5:15>   INT'Int'\n" +
                "Loc=<5:19>   ASSIGNMENT'='\n" +
                "Loc=<5:21>   IntegerLiteral'2'\n" +
                "Loc=<5:23>   MULT'*'\n" +
                "Loc=<5:25>   IntegerLiteral'3'\n" +
                "Loc=<6:4>   RCURL'}'\n" +
                "Loc=<6:6>   ELSE'else'\n" +
                "Loc=<6:11>   LCURL'{'\n" +
                "Loc=<7:8>   VAR'var'\n" +
                "Loc=<7:12>   Identifier'b'\n" +
                "Loc=<7:13>   COLON':'\n" +
                "Loc=<7:15>   INT'Int'\n" +
                "Loc=<7:19>   ASSIGNMENT'='\n" +
                "Loc=<7:21>   IntegerLiteral'11'\n" +
                "Loc=<8:8>   PRINT'print'\n" +
                "Loc=<8:13>   LPAREN'('\n" +
                "Loc=<8:14>   Identifier'b'\n" +
                "Loc=<8:15>   RPAREN')'\n" +
                "Loc=<9:4>   RCURL'}'\n" +
                "Loc=<10:0>   RCURL'}'\n" +
                "Loc=<11:0>   EOF'<EOF>'\n";

        Assert.assertEquals(test, expected);
    }

}//mvn clean compile assembly:single


