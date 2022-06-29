import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;

class FileDataProvider implements DataProvider {
    String fileName;

    FileDataProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public CharStream getText() {
        try {
            return CharStreams.fromFileName(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
