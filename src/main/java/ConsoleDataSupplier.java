public class ConsoleDataSupplier implements DataSupplier{
    @Override
    public void accept(String output) {
        System.out.println(output);
    }
}
