package interpreter;

import ast.Node;

import java.util.HashMap;

/**
 * A function is a value that also stores the positions + names of the parameters, so that the arguments can be
 * properly matched
 */
public class Function extends Value {
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
}
