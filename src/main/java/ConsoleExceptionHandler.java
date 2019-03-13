public class ConsoleExceptionHandler implements ExceptionHandler {
    @Override
    public void showExceptionMessage(Exception x) {
        System.out.println(x.getMessage());
    }
}
