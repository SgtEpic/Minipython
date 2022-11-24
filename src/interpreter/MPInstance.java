package interpreter;

import java.util.HashMap;
import java.util.Map;

class MPInstance {
    final MPClass klass;
    private final Map<String, Object> fields = new HashMap<>();

    MPInstance(MPClass klass) {
        this.klass = klass;
    }

    Object get(Symbol name) {
        if (fields.containsKey(name.lexeme)) {
            return fields.get(name.lexeme);
        }

        MPFunction method = klass.findMethod(name.lexeme);
        if (method != null) return method.bind(this);

        throw new RuntimeError(name, "Undefined property '" + name.lexeme + "'.");
    }

    void set(Symbol name, Object value) {
        fields.put(name.lexeme, value);
    }

    @Override
    public String toString() {
        return klass.name + " instance";
    }
}
