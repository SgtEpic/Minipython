package frontend;

import antlr.minipythonParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Symboltable implements Expr.Visitor<Void>, Stmt.Visitor<Void>{
    private final Stack<Map<String, Symbol>> scopes = new Stack<>();
    private final Map<String, Symbol> globals = new HashMap<>();
    private FunctionType currentFunction = FunctionType.NONE;
    private ClassType currentClass = ClassType.NONE;
    private final Boolean printTables;

    Symboltable(Boolean printTables) {
        this.printTables = printTables;
        globals.put("print", new Symbol(SymbolType.L_PAREN, "print", null, -1, -1));
        globals.put("input", new Symbol(SymbolType.L_PAREN, "print", null, -1, -1));
        globals.put("raw_list", new Symbol(SymbolType.L_PAREN, "raw_list", null, -1, -1));
    }

    private enum FunctionType {
        NONE, FUNCTION, INITIALIZER, METHOD
    }

    private enum ClassType {
        NONE, CLASS, SUBCLASS
    }

    void resolveAST(Stmt stmt) {
        resolve(stmt);
    }

    void resolve(List<Stmt> statements) {
        for (Stmt statement : statements) {
            resolve(statement);
        }
    }


    @Override
    public Void visitBlockStmt(Stmt.Block stmt) {
        beginScope();
        resolve(stmt.statements);
        endScope();
        return null;
    }

    @Override
    public Void visitClassStmt(Stmt.Class stmt) {
        // TODO if class has superclass, check for __init__ method and first stmt super()
        ClassType enclosingClass = currentClass;
        currentClass = ClassType.CLASS;

        define(stmt.symbol);

        if (stmt.superclass != null && stmt.symbol.lexeme.equals(stmt.superclass.symbol.lexeme)) {
            Minipython.error(stmt.superclass.symbol, "A class cannot inherit from itself.");
        }

        if (stmt.superclass != null) {
            currentClass = ClassType.SUBCLASS;
            resolve(stmt.superclass);
        }

        if (stmt.superclass != null) {
            beginScope();
            scopes.peek().put("super()", stmt.superclass.symbol);
        }

        beginScope();
        scopes.peek().put("self", new Symbol(SymbolType.SELF, "self", null, -1, -1));

        for (Stmt.Function method : stmt.methods) {
            FunctionType declaration = FunctionType.METHOD;
            // check required first param self
            if (method.params.isEmpty() || !method.params.get(0).lexeme.equals("self")) {
                Minipython.error(method.symbol, "Methods must have 'self' as first parameter.");
            }
            if (method.symbol.lexeme.equals("__init__")) {
                declaration = FunctionType.INITIALIZER;
            }
            resolveFunction(method, declaration);

        }
        if (printTables) printScopeTable("Class " + stmt.symbol.lexeme);
        endScope();
        if (stmt.superclass != null) endScope();
        currentClass = enclosingClass;
        return null;
    }

    @Override
    public Void visitExpressionStmt(Stmt.Expression stmt) {
        resolve(stmt.expression);
        return null;
    }

    @Override
    public Void visitFunctionStmt(Stmt.Function stmt) {
        define(stmt.symbol);

        resolveFunction(stmt, FunctionType.FUNCTION);
        return null;
    }

    @Override
    public Void visitIfStmt(Stmt.If stmt) {
        resolve(stmt.condition);
        resolve(stmt.ifBlock.statements);
        if (!stmt.elifBranch.isEmpty()) {
            for (Stmt.Elif elif : stmt.elifBranch) {
                resolve(elif.condition);
                resolve(elif.block.statements);
            }
        }
        if (stmt.elseBranch != null) {
            resolve(stmt.elseBranch.statements);
        }
        return null;
    }

    @Override
    public Void visitProgramStmt(Stmt.Program stmt) {
        resolve(stmt.statements);
        return null;
    }

    @Override
    public Void visitReturnStmt(Stmt.Return stmt) {
        if (currentFunction == FunctionType.NONE) {
            Minipython.error(stmt.keyword, "Cannot return outside function.");
        }
        if (stmt.value != null) {
            // init must not return expression
            if (currentFunction == FunctionType.INITIALIZER) {
                Minipython.error(stmt.keyword, "Cannot return from initializer.");
            }
            resolve(stmt.value);
        }
        return null;
    }

    @Override
    public Void visitWhileStmt(Stmt.While stmt) {
        resolve(stmt.condition);
        resolve(stmt.body.statements);
        return null;
    }
    @Override
    public Void visitAssignmentExpr(Expr.Assignment expr) {
        // check if variable is already defined -> assignment
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(expr.symbol.lexeme)) {
                resolve(expr.value);
                resolveLocal(expr, expr.symbol);
                return null;
            }
        }

        // -> declaration, definition and assignment
        define(expr.symbol);
        resolve(expr.value);
        resolveLocal(expr, expr.symbol);
        return null;
    }

    @Override
    public Void visitBinaryExpr(Expr.Binary expr) {
        resolve(expr.left);
        resolve(expr.right);
        return null;
    }

    @Override
    public Void visitCallExpr(Expr.Call expr) {
        resolve(expr.callee);
        for (Expr argument : expr.arguments) {
            resolve(argument);
        }
        return null;
    }

    @Override
    public Void visitGetExpr(Expr.Get expr) {
        resolve(expr.object);
        return null;
    }

    @Override
    public Void visitGroupingExpr(Expr.Grouping expr) {
        resolve(expr.expression);
        return null;
    }

    @Override
    public Void visitLiteralExpr(Expr.Literal expr) {
        return null;
    }

    @Override
    public Void visitLogicalExpr(Expr.Logical expr) {
        resolve(expr.left);
        resolve(expr.right);
        return null;
    }

    @Override
    public Void visitSelfExpr(Expr.Self expr) {
        if (currentClass == ClassType.NONE) {
            Minipython.error(expr.keyword, "Cannot use 'self' outside of a class.");
        }
        resolveLocal(expr, expr.keyword);
        return null;
    }

    @Override
    public Void visitSetExpr(Expr.Set expr) {
        resolve(expr.value);
        resolve(expr.object);
        return null;
    }

    @Override
    public Void visitSuperExpr(Expr.Super expr) {
        if (currentClass == ClassType.NONE) {
            Minipython.error(expr.keyword, "Cannot use 'super' outside of a class.");
        }
        if (currentFunction != FunctionType.INITIALIZER) {
            Minipython.error(expr.keyword, "Cannot use 'super' outside of __init__ method.");
        }
        return null;
    }

    @Override
    public Void visitUnaryExpr(Expr.Unary expr) {
        resolve(expr.right);
        return null;
    }

    @Override
    public Void visitVariableExpr(Expr.Variable expr) {
        if (!scopes.isEmpty() && scopes.peek().get(expr.symbol.lexeme) == expr.symbol) {
            Minipython.error(expr.symbol, "Cannot read local variable in its own initializer.");
        }
        resolveLocal(expr, expr.symbol);
        return null;
    }

    private void resolve(Stmt stmt) {
        stmt.accept(this);
    }
    private void resolve(Expr expr) {
        expr.accept(this);
    }
    private void resolveFunction(Stmt.Function function, FunctionType type) {
        FunctionType enclosingFunction = currentFunction;
        currentFunction = type;

        beginScope();
        for (Symbol param : function.params) {
            define(param);
        }
        resolve(function.block.statements);
        if (printTables) printScopeTable("Function " + function.symbol.lexeme);
        endScope();

        currentFunction = enclosingFunction;
    }
    private void beginScope() {
        scopes.push(new HashMap<String, Symbol>());
    }
    private void endScope() {
        scopes.pop();
    }

    private void define(Symbol symbol) {
        if (scopes.isEmpty()) {
            globals.put(symbol.lexeme, symbol) ;
            return;
        }
        scopes.peek().put(symbol.lexeme, symbol);
    }
    private void resolveLocal(Expr expr, Symbol symbol) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(symbol.lexeme)) {
                expr.distance = scopes.size() - 1 - i;
                return;
            }
        }
        if (!globals.containsKey(symbol.lexeme)) {
            Minipython.error(symbol, "Name undefined.");
        }
    }

    void printGlobalTable() {
        System.out.println("\n\nGlobal Table:");
        for (String key : globals.keySet()) {
            System.out.println(key + " :: " + globals.get(key));
        }
        System.out.println("\n\n");
    }

private void printScopeTable(String name) {
    System.out.println("\n" + name + " Scope Table:");
    if(scopes.size() > 0) {
        System.out.println("Scope depth " + scopes.size());
        for (String key : scopes.get(scopes.size()-1).keySet()) {
            System.out.println(key + " :: " + scopes.get(scopes.size()-1).get(key));
        }

    }
}
}


