package ProjectException;

public class WrongAmountException extends TerminalException {
    public WrongAmountException() {
    }

    public WrongAmountException(String message) {
        super(message);
    }

    public WrongAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongAmountException(Throwable cause) {
        super(cause);
    }

    public WrongAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
