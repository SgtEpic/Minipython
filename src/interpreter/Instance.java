package interpreter;

import ast.ClassDefinition;
import ast.Node;

import java.util.HashMap;
import java.util.Map;

public class Instance extends Value {

    private Klass klass;

    private final Map<String, Value> fields = new HashMap<>();
    public Instance(Klass klass) {
        super(Type.INSTANCE, klass.getEnvironment(), klass);
        this.klass = klass;
    }


    Value get(String name) {

        if (fields.containsKey(name)) {
            return fields.get(name);
        }

        Function method = klass.findMethod(name);
        if (method != null) return new Value(Type.FUNCTION, null, method.bind(this));

        throw new RuntimeException(name + " Undefined property '" + name + "'.");

    }


    void set(String name, Value value) {
        fields.put(name, value);
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String toString() {
        return ((ClassDefinition)klass.getValue()).children.get(0).name;
    }
}
