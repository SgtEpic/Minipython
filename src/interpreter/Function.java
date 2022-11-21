package interpreter;

import ast.Node;

import java.util.HashMap;
import java.util.List;

/**
 * A function is a value that also stores the positions + names of the parameters, so that the arguments can be
 * properly matched
 */
public class Function extends Value implements MPCallable {
    // stores the parameter names and positions
    private final HashMap<Integer, String> params = new HashMap<>();

    public Function(Type type, Environment environment, Node entryPoint) {
        super(type, environment, entryPoint);
    }

    public String getParam(int position) {
        return params.get(position);
    }

    public void setParam(int position, String name) {
        this.params.put(position, name);
    }

    public int getParamAmount(){
        return params.size();
    }

    Function bind(Instance instance) {
        Environment environment = new Environment(getEnvironment());
        environment.define("self", instance);
        return new Function(Type.INSTANCE, environment, (Node)getValue());
    }

    @Override
    public int arity() {
        return params.size();
    }

    @Override
    public Value call(Interpreter interpreter, List<Value> arguments) {
        Environment environment = new Environment(getEnvironment());

        for (int i = 0; i < params.size(); i++) {
            environment.define(params.get(i), arguments.get(i));

        }
        try{
            interpreter.executeBlock(((Node)getValue()).children.get(2), environment);
            if(getType() == Type.CONSTRUCTOR){
                throw new ReturnException(new Value(Type.CONSTRUCTOR, environment,"constructor"));
            }
        }catch (ReturnException e){
            if(getType() == Type.CONSTRUCTOR){
                return environment.get("self");
            }
            return e.value;
        }
        if(getType() == Type.CONSTRUCTOR){
            return environment.get("self");
        }

        return null;
    }
}
