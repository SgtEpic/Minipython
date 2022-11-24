package interpreter;

import java.util.List;
import java.util.Map;

class MPClass implements MPCallable{
    final String name;
    final MPClass superclass;
    private final Map<String, MPFunction> methods;

    MPClass(String name, MPClass superclass, Map<String, MPFunction> methods) {
        this.name = name;
        this.superclass = superclass;
        this.methods = methods;
    }

    MPFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        return null;
    }


    @Override
    public int arity() {
        MPFunction initializer = findMethod("__init__");
        if (initializer == null) return 0;
        return initializer.arity();
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        MPInstance instance = new MPInstance(this);
        MPFunction initializer = findMethod("__init__");
        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }
        return instance;
    }

    @Override
    public String toString() {
        return name;
    }
}
