package interpreter;

import ast.FunctionDefinition;

import java.util.List;

public class MPFunction implements MPCallable{

    private final FunctionDefinition definition;

    private final Environment closure;

    private final boolean isInitializer;

    public MPFunction(FunctionDefinition definition, Environment closure, boolean isInitializer) {
        this.isInitializer = isInitializer;
        this.closure = closure;
        this.definition = definition;
    }

   /* public MPFunction bind(MPInstance instance) {
       *//* Environment environment = new Environment(closure);
        environment.define("self", new Value(Type.INSTANCE, environment, instance));
        return new MPFunction(definition, environment, isInitializer);*//*
    }*/

    @Override
    public int arity() {
        return 0;
    }

    @Override
    public Value call(Interpreter interpreter, List<Value> arguments) {
        return null;
    }
}
