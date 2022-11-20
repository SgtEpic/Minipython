package interpreter;

/**
 * An exception that gets thrown if there is a return in a statement
 * Contains the return value
 */
public class ReturnException extends RuntimeException {
    Value value;
    public ReturnException(Value value) {
        this.value = value;
    }
}
