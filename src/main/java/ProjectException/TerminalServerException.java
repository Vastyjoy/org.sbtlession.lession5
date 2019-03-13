package ProjectException;

public class TerminalServerException  extends Exception{
    public TerminalServerException() {
    }

    public TerminalServerException(String message) {
        super(message);
    }

    public TerminalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TerminalServerException(Throwable cause) {
        super(cause);
    }

    public TerminalServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
