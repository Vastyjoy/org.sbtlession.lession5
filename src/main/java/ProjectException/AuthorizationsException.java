package ProjectException;

public class AuthorizationsException extends PinValidatorException{
    public AuthorizationsException() {

    }

    public AuthorizationsException(String message) {
        super(message);
    }

    public AuthorizationsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationsException(Throwable cause) {
        super(cause);
    }

    public AuthorizationsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
