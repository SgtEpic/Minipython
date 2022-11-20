package interpreter;

import ast.Node;

import java.util.Map;

public class Klass extends Value implements MPCallable {

    private Klass superclass;
    private Map<String, Function> methods;

    public Klass(Environment env, Node entryPoint, Klass superclass) {
        super(Type.CLASS, env, env);
        this.superclass = superclass;
    }
    public Klass(Environment env, Node entryPoint, Klass superclass, Map<String, Function> methods) {
        super(Type.CLASS, env, env);
        this.superclass = superclass;
        this.methods = methods;
    }

    Function findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        if (superclass != null) {
            return superclass.findMethod(name);
        }

        return null;
    }

    @Override
    public int arity() {
    /*    MPFunction initializer = findMethod("__init__");
        if (initializer == null) return 0;
        return initializer.arity();*/
        return 0;
    }

    @Override
    public Object call(Interpreter interpreter, Object[] arguments) {
        Instance instance = new Instance(this);
        Function initializer = findMethod("__init__");

        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }
        return instance;
        return null;
    }

    @Override
    public String toString() {
        return ((Node) getValue()).name;
    }

}

