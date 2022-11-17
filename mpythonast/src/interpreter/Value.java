package interpreter;

public class Value {
    private Type type;
    private Environment environment;

    public Value(Type type, Environment environment) {
        this.type = type;
        this.environment = environment;
    }

    public Type getType() {
        return type;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
