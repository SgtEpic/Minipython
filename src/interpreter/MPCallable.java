package interpreter;

import java.util.List;

public interface MPCallable {
    int arity();
    Value call(Interpreter interpreter, List<Value> arguments);
}
