package frontend;

import java.util.List;

public class AstPrinter implements Expr.Visitor<String>, Stmt.Visitor<String> {
    String print(Expr expr) {
        return expr.accept(this);
    }

    public String print(Stmt stmt) {
        return stmt.accept(this);
    }


    @Override
    public String visitBlockStmt(Stmt.Block stmt) {
        StringBuilder builder = new StringBuilder();
        builder.append("(block ");

        for (Stmt statement : stmt.statements) {
            builder.append(statement.accept(this));
        }

        builder.append(")");
        return builder.toString();
    }

    @Override
    public String visitClassStmt(Stmt.Class stmt) {
        StringBuilder builder = new StringBuilder();
        builder.append("(class " + stmt.symbol.lexeme);

        if (stmt.superclass != null) {
            builder.append("( " + print(stmt.superclass) + " )");
        }

        for (Stmt.Function method : stmt.methods) {
            builder.append(" " + print(method));
        }

        builder.append(")");
        return builder.toString();
    }

    @Override
    public String visitExpressionStmt(Stmt.Expression stmt) {
        return parenthesize(";", stmt.expression);
    }

    @Override
    public String visitFunctionStmt(Stmt.Function stmt) {
        StringBuilder builder = new StringBuilder();
        builder.append("(fun " + stmt.symbol.lexeme + "(");

        for (Symbol param : stmt.params) {
            if (param != stmt.params.get(0)) builder.append(" ");
            builder.append(param.lexeme);
        }

        builder.append(") ");

/*
        for (Stmt body : stmt.block.statements) {
            builder.append(body.accept(this));
        }
*/
        builder.append(stmt.block.accept(this));

        builder.append(")");
        return builder.toString();
    }

    @Override
    public String visitIfStmt(Stmt.If stmt) {
        return parenthesize2("if-elif-else", stmt.condition,
                stmt.elseBranch);
    }

    @Override
    public String visitProgramStmt(Stmt.Program stmt) {
        StringBuilder builder = new StringBuilder();
        builder.append("(program ");

        for (Stmt statement : stmt.statements) {
            builder.append(statement.accept(this));
        }

        builder.append(")");
        return builder.toString();
    }

    @Override
    public String visitReturnStmt(Stmt.Return stmt) {
        if (stmt.value == null) return "(return)";
        return parenthesize("return", stmt.value);
    }

    @Override
    public String visitWhileStmt(Stmt.While stmt) {
        return parenthesize2("while", stmt.condition, stmt.body);
    }


    @Override
    public String visitAssignmentExpr(Expr.Assignment expr) {
        return parenthesize2("=", expr.symbol.lexeme, expr.value);
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
        return parenthesize(expr.operator.lexeme,
                expr.left, expr.right);
    }

    @Override
    public String visitCallExpr(Expr.Call expr) {
        return parenthesize2("call", expr.callee, expr.arguments);
    }

    @Override
    public String visitGetExpr(Expr.Get expr) {
        return parenthesize2(".", expr.object, expr.symbol.lexeme);
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
        return parenthesize("group", expr.expression);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }

    @Override
    public String visitLogicalExpr(Expr.Logical expr) {
        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitSelfExpr(Expr.Self expr) {
        return "self";
    }

    @Override
    public String visitSetExpr(Expr.Set expr) {
        return parenthesize2("=",
                expr.object, expr.symbol.lexeme, expr.value);
    }

    @Override
    public String visitSuperExpr(Expr.Super expr) {
        return parenthesize2("super", expr.arguments);
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        return parenthesize(expr.operator.lexeme, expr.right);
    }

    @Override
    public String visitVariableExpr(Expr.Variable expr) {
        return expr.symbol.lexeme;
    }

    @Override
    public String visitListExpr(Expr.Array expr) {
        return parenthesize2("list", expr.content);
    }

    //> print-utilities
        private String parenthesize(String name, Expr... exprs) {
            StringBuilder builder = new StringBuilder();

            builder.append("(").append(name);
            for (Expr expr : exprs) {
                builder.append(" ");
                builder.append(expr.accept(this));
            }
            builder.append(")");

            return builder.toString();
        }
        //< print-utilities
//> omit
        // Note: AstPrinting other types of syntax trees is not shown in the
        // book, but this is provided here as a reference for those reading
        // the full code.
        private String parenthesize2(String name, Object... parts) {
            StringBuilder builder = new StringBuilder();

            builder.append("(").append(name);
            transform(builder, parts);
            builder.append(")");

            return builder.toString();
        }

        private void transform(StringBuilder builder, Object... parts) {
            for (Object part : parts) {
                builder.append(" ");
                if (part instanceof Expr) {
                    builder.append(((Expr)part).accept(this));
//> Statements and State omit
                } else if (part instanceof Stmt) {
                    builder.append(((Stmt) part).accept(this));
//< Statements and State omit
                } else if (part instanceof Symbol) {
                    builder.append(((Symbol) part).lexeme);
                } else if (part instanceof List) {
                    transform(builder, ((List) part).toArray());
                } else {
                    builder.append(part);
                }
            }
        }
//< omit
/* Representing Code printer-main < Representing Code omit
  public static void main(String[] args) {
    Expr expression = new Expr.Binary(
        new Expr.Unary(
            new Token(TokenType.MINUS, "-", null, 1),
            new Expr.Literal(123)),
        new Token(TokenType.STAR, "*", null, 1),
        new Expr.Grouping(
            new Expr.Literal(45.67)));
    System.out.println(new AstPrinter().print(expression));
  }
*/
}
