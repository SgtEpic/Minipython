package interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interpreter implements Expr.Visitor<Object>, Stmt.Visitor<Void>{
    final Environment globals = new Environment();
    private Environment environment = globals;

    public Interpreter() {
        globals.define("print", new MPCallable() {
            @Override
            public int arity() {
                return 1;
            }

            @Override
            public Object call(Interpreter interpreter, List<Object> arguments) {
                System.out.println(arguments.get(0).toString());
                return null;
            }
            @Override
            public String toString() { return "<print native fn>"; }
        });
        globals.define("input", new MPCallable() {
            @Override
            public int arity() {
                return 0;
            }

            @Override
            public Object call(Interpreter interpreter, List<Object> arguments) {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    return br.readLine();
                } catch (IOException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "<native fn>";
            }
        });
    };

    public void interpret(List<Stmt> statements) {
        try {
            for (Stmt statement : statements) {
                execute(statement);
            }
        } catch (RuntimeError error) {
            Minipython.runtimeError(error);
        }
    }

    private Object evaluate(Expr expr) {
        return expr.accept(this);
    }

    private void execute(Stmt stmt) {
        stmt.accept(this);
    }

    void executeBlock(List<Stmt> statements, Environment localEnvironment) {
        Environment previous = this.environment;
        try {
            this.environment = localEnvironment;

            for (Stmt statement : statements) {
                execute(statement);
            }
        } finally {
            this.environment = previous;
        }

    }

    @Override
    public Void visitBlockStmt(Stmt.Block stmt) {
        executeBlock(stmt.statements, new Environment(environment));
        return null;
    }

    @Override
    public Void visitClassStmt(Stmt.Class stmt) {
        Object superclass = null;
        if (stmt.superclass != null) {
            superclass = evaluate(stmt.superclass);
            if (!(superclass instanceof MPClass)) {
                throw new RuntimeError(stmt.superclass.symbol, "Superclass must be a class.");
            }
        }

        environment.define(stmt.symbol.lexeme, null);

        if (stmt.superclass != null) {
            environment = new Environment(environment);
            environment.define("super", superclass);
        }

        Map<String, MPFunction> methods = new HashMap<>();
        for (Stmt.Function method : stmt.methods) {
            MPFunction function = new MPFunction(method, environment, method.symbol.lexeme.equals("__init__"));
            methods.put(method.symbol.lexeme, function);
        }
        MPClass klass = new MPClass(stmt.symbol.lexeme, (MPClass)superclass, methods);

        if (superclass != null) {
            environment = environment.enclosing;
        }

        environment.assign(stmt.symbol, klass);
        return null;
    }

    @Override
    public Void visitExpressionStmt(Stmt.Expression stmt) {
        evaluate(stmt.expression);
        return null;
    }

    @Override
    public Void visitFunctionStmt(Stmt.Function stmt) {
        MPFunction function = new MPFunction(stmt, environment, false);
        environment.define(stmt.symbol.lexeme, function);
        return null;
    }

    @Override
    public Void visitIfStmt(Stmt.If stmt) {
        if (isTruthy(evaluate(stmt.condition))) {
            execute(stmt.ifBlock);
        } else if (!stmt.elifBranch.isEmpty()) {
            for (Stmt.Elif elif : stmt.elifBranch) {
                if (isTruthy(evaluate(elif.condition))) {
                    execute(elif.block);
                    break;
                }
            }
            if (stmt.elseBranch != null) {
                execute(stmt.elseBranch);
            }
            return null;
        } else {
            if (stmt.elseBranch != null) {
                execute(stmt.elseBranch);
            }
        }
        return null;

    }

    @Override
    public Void visitReturnStmt(Stmt.Return stmt) {
        Object value = null;
        if (stmt.value != null) value = evaluate(stmt.value);
        throw new ReturnError(value);
    }


    @Override
    public Void visitWhileStmt(Stmt.While stmt) {
        while(isTruthy(evaluate(stmt.condition))) {
            execute(stmt.body);
        }
        return null;
    }

    @Override
    public Object visitAssignmentExpr(Expr.Assignment expr) {
        Object value = evaluate(expr.value);

        Integer distance = expr.depth;
        // check for local variable before defining
        // no declaration, only assignment
        if (distance != -1) {
            environment.getAt(distance, expr.symbol.lexeme);
            environment.assignAt(distance, expr.symbol, value);
        } else {
            globals.define(expr.symbol.lexeme, value);
        }
        return value;
    }

    @Override
    public Object visitBinaryExpr(Expr.Binary expr) {
        Object left = evaluate(expr.left);
        Object right = evaluate(expr.right);
        switch (expr.operator.type) {
            case EQ: return isEqual(left, right);
            case NEQ: return !isEqual(left, right);
            case LT:
                checkNumberOperands(expr.operator, left, right);
                return (int) left < (int) right;
            case LTE:
                checkNumberOperands(expr.operator, left, right);
                return (int) left <= (int) right;
            case GT:
                checkNumberOperands(expr.operator, left, right);
                return (int) left > (int) right;
            case GTE:
                checkNumberOperands(expr.operator, left, right);
                return (int) left >= (int) right;
            case PLUS:
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left + (int) right;
                }
                if (left instanceof String && right instanceof String) {
                    return (String) left + (String) right;
                }
                throw new RuntimeError(expr.operator, "Operands must be two numbers or two strings.");
            case MINUS:
                checkNumberOperands(expr.operator, left, right);
                return (int) left - (int) right;
            case DIVIDE:
                checkNumberOperands(expr.operator, left, right);
                // check for division by zero
                if ((int) right == 0) throw new RuntimeError(expr.operator, "Cannot divide by zero.");
                return (int) left / (int) right;
            case STAR:
                checkNumberOperands(expr.operator, left, right);
                return (int) left * (int) right;
        }
        return null;
    }

    @Override
    public Object visitCallExpr(Expr.Call expr) {
        Object callee = evaluate(expr.callee);

        List<Object> arguments = new ArrayList<>();
        for (Expr argument : expr.arguments) {
            arguments.add(evaluate(argument));
        }

        if (!(callee instanceof MPCallable)) {
            throw new RuntimeError(expr.paren, "Can only call functions and classes.");
        }

        MPCallable function = (MPCallable) callee;
        if (arguments.size() != function.arity()) {
            throw new RuntimeError(expr.paren, "Expected " + function.arity() + " arguments but got " + arguments.size() + ".");
        }
        return function.call(this, arguments);
    }

    @Override
    public Object visitGetExpr(Expr.Get expr) {
        Object object = evaluate(expr.object);
        if (object instanceof MPInstance) {
            return ((MPInstance) object).get(expr.symbol);
        }
        throw new RuntimeError(expr.symbol, "Only instances have properties.");
    }

    @Override
    public Object visitGroupingExpr(Expr.Grouping expr) {
        return evaluate(expr.expression);
    }

    @Override
    public Object visitLiteralExpr(Expr.Literal expr) {
        return expr.value;
    }

    @Override
    public Object visitLogicalExpr(Expr.Logical expr) {
        Object left = evaluate(expr.left);
        if (expr.operator.type == SymbolType.OR) {
            if (isTruthy(left)) return left;
        } else {
            if (!isTruthy(left)) return left;
        }
        return evaluate(expr.right);
    }

    @Override
    public Object visitSelfExpr(Expr.Self expr) {
        return lookUpVariable(expr.keyword, expr);
    }

    @Override
    public Object visitSetExpr(Expr.Set expr) {
        Object object = evaluate(expr.object);
        if (!(object instanceof MPInstance)) {
            throw new RuntimeError(expr.symbol, "Only instances have fields.");
        }
        Object value = evaluate(expr.value);
        ((MPInstance) object).set(expr.symbol, value);
        return value;
    }

    @Override
    public Object visitSuperExpr(Expr.Super expr) {
        int distance = expr.depth;
        MPClass superclass = (MPClass) environment.getAt(distance, "super");
        MPInstance object = (MPInstance) environment.getAt(distance - 1, "self");
        MPFunction method = superclass.findMethod(expr.method.lexeme);
        if (method == null) {
            throw new RuntimeError(expr.method, "Undefined property '" + expr.method.lexeme + "'.");
        }
        return method.bind(object);
    }

    @Override
    public Object visitUnaryExpr(Expr.Unary expr) {
        Object right = evaluate(expr.right);
        switch (expr.operator.type) {
            case MINUS:
                checkNumberOperand(expr.operator, right);
                return -(int) right;
            case PLUS:
                checkNumberOperand(expr.operator, right);
                return +(int) right;
            case NOT:
                return !isTruthy(right);
        }
        return null;
    }

    @Override
    public Object visitVariableExpr(Expr.Variable expr) {
        return lookUpVariable(expr.symbol, expr);
        //return environment.get(expr.symbol);
    }

    private Object lookUpVariable(Symbol symbol, Expr expr) {
        if (expr.depth != -1) {
            // find local name
            return environment.getAt(expr.depth, symbol.lexeme);
        } else {
            // find global name
            return globals.get(symbol);
        }
    }

    private void checkNumberOperand(Symbol operator, Object operand) {
        if (operand instanceof Integer) return;
        throw new RuntimeError(operator, "Operand must be a Integer.");
    }

    private void checkNumberOperands(Symbol operator,
                                     Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) return;
        throw new RuntimeError(operator, "Operands must be Integers.");
    }

    private boolean isTruthy(Object object) {
        if (object instanceof Boolean) return (boolean)object;
        return true;
    }

    private boolean isEqual(Object a, Object b) {
        return a.equals(b);
    }


}
