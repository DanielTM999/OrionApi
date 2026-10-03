package dtm.ide.api.instrumentation;

public class InstrumentationAccessException extends IllegalStateException {
    public InstrumentationAccessException(String message) {
        super(message);
    }

    public InstrumentationAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
