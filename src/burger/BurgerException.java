package burger;

public class BurgerException extends Exception {

    public BurgerException() {
        super();
    }

    public BurgerException(String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
        super(message, cause, enableSuppresion, writableStackTrace);
    }

    public BurgerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BurgerException(String message) {
        super(message);
    }

    public BurgerException(Throwable cause) {
        super(cause);
    }
}
