package interpreter;

import java.util.List;

public class MPFunction implements MPCallable {
    private final Stmt.Function funcdef;
    private final Environment closure;
    private final boolean isInitializer;

    MPFunction(Stmt.Function funcdef, Environment closure, boolean isInitializer) {
        this.funcdef = funcdef;
        this.closure = closure;
        this.isInitializer = isInitializer;
    }

    MPFunction bind(MPInstance instance) {
        Environment environment = new Environment(closure);
        environment.define("self", instance);
        return new MPFunction(funcdef, environment, isInitializer);
    }

    @Override
    public int arity() {
        return funcdef.params.size();
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        Environment environment = new Environment(closure);
        // define params
        for (int i = 0; i < funcdef.params.size(); i++) {
            environment.define(funcdef.params.get(i).lexeme, arguments.get(i));
        }

        try {
            interpreter.executeBlock(funcdef.block.statements, environment);
        } catch (ReturnError returnErrorValue) {
            if (isInitializer) return closure.getAt(0, "self");
            return returnErrorValue.value;
        }
        if (isInitializer) return closure.getAt(0, "self");
        return null;
    }

    @Override
    public String toString() {
        return "<fn " + funcdef.symbol.lexeme + ">";
    }
}
