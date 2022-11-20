package interpreter;

public interface MPCallable {
    int arity();
    Object call(Interpreter interpreter, Object[] arguments);
}
