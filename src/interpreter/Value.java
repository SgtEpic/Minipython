package interpreter;

public class Value {
    private final Type type;
    protected final Environment environment;

    private final Object value;

    public Value(Type type, Environment environment, Object value) {
        this.type = type;
        this.environment = environment;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public Object getValue() {
        return value;
    }
}
