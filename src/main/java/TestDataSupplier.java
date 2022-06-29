public class TestDataSupplier implements DataSupplier {
    String test = "";

    @Override
    public void accept(String output) {
        test += output + "\n";
    }

    public String getTest() {
        return test;
    }
}
