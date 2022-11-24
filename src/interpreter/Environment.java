package interpreter;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    final Environment enclosing;
    private final Map<String, Object> symbols = new HashMap<>();

    public Environment() {
        enclosing = null;
    }

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    Object get(Symbol symbol) {
        if (symbols.containsKey(symbol.lexeme)) {
            return symbols.get(symbol.lexeme);
        }

        if (enclosing != null) return enclosing.get(symbol);

        throw new RuntimeError(symbol, "Undefined name '" + symbol.lexeme + "'.");
    }

    void assign(Symbol symbol, Object value) {
        if (symbols.containsKey(symbol.lexeme)) {
            symbols.put(symbol.lexeme, value);
            return;
        }

        if (enclosing != null) {
            enclosing.assign(symbol, value);
            return;
        }

        throw new RuntimeError(symbol, "Undefined name '" + symbol.lexeme + "'.");
    }

    void define(String name, Object value) {
        symbols.put(name, value);
    }

    Environment anchestor(int distance) {
        Environment environment = this;
        for (int i = 0; i < distance; i++) {
            environment = environment.enclosing;
        }

        return environment;
    }

    Object getAt(int distance, String name) {
        return anchestor(distance).symbols.get(name);
    }

    void assignAt(int distance, Symbol symbol, Object value) {
        anchestor(distance).symbols.put(symbol.lexeme, value);
    }

    @Override
    public String toString() {
        return symbols.toString();
    }
}
