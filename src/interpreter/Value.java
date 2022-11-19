package interpreter;

public class Value {
    private Type type;
    private Environment environment;

    private Object value;

    public Value(Type type, Environment environment) {
        this.type = type;
        this.environment = environment;
    }

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

    public void setValue(Object value) {
        this.value = value;
    }
}
