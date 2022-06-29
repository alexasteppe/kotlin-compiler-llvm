import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

class MockedDataProvider implements DataProvider {
    String sampleText;

    MockedDataProvider(String sampleText) {
        this.sampleText = sampleText;
    }

    @Override
    public CharStream getText() {
        return CharStreams.fromString(sampleText);
    }
}
