package ProjectException;

public class InvalidAccessTerminalException extends TerminalException {
    public InvalidAccessTerminalException() {
    }

    public InvalidAccessTerminalException(String message) {
        super(message);
    }

    public InvalidAccessTerminalException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAccessTerminalException(Throwable cause) {
        super(cause);
    }

    public InvalidAccessTerminalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
