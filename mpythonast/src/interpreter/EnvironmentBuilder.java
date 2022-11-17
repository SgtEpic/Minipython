package interpreter;

import symboltable.Scope;
import symboltable.Symbol;

public class EnvironmentBuilder {
    public Scope scope;

    public EnvironmentBuilder(Scope scope) {
        this.scope = scope;
    }

    public Environment buildEnv(Scope scope, Environment parent) {
        Environment env =  new Environment(scope, parent);
        for (String symbolName : scope.getSymbols().keySet()) {
            env.define(symbolName, null);
        }
        for (Scope childScope : scope.getChildren()) {
            buildEnv(childScope, env);
        }
        return env;
    }

    public Environment build() {
        return buildEnv(scope, null);
    }


}
