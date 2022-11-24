package interpreter;

public class ReturnError extends RuntimeError{
    final Object value;

    ReturnError(Object value) {
        super(null, null);
        this.value = value;
    }
}
