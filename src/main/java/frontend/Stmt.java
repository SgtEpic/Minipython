package frontend;

import java.util.List;

public abstract class Stmt {
    interface Visitor<T> {
        T visitBlockStmt(Block stmt);
        T visitClassStmt(Class stmt);
        T visitExpressionStmt(Expression stmt);
        T visitFunctionStmt(Function stmt);
        T visitIfStmt(If stmt);
        T visitProgramStmt(Program stmt);
        T visitReturnStmt(Return stmt);
        T visitWhileStmt(While stmt);
    }

    static class Block extends Stmt {
        final List<Stmt> statements;
        Block(List<Stmt> statements) {
            this.statements = statements;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitBlockStmt(this);
        }


    }

    static class Class extends Stmt {
        final Symbol symbol;
        final Expr.Variable superclass;
        final List<Function> methods;
        Class(Symbol symbol, Expr.Variable superclass, List<Function> methods) {
            this.symbol = symbol;
            this.superclass = superclass;
            this.methods = methods;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitClassStmt(this);
        }
    }

    static class Expression extends Stmt {
        final Expr expression;
        public Expression(Expr expression) {
            this.expression = expression;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitExpressionStmt(this);
        }
    }

    static class Function extends Stmt {
        final Symbol symbol;
        final List<Symbol> params;
        final Block block;
        Function(Symbol symbol, List<Symbol> params, Block block) {
            this.symbol = symbol;
            this.params = params;
            this.block = block;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitFunctionStmt(this);
        }
    }

    static class If extends Stmt {
        final Expr condition;
        final Block ifBlock;
        final List<Elif> elifBranch;
        final Block elseBranch;
        If(Expr condition, Block ifBlock, List<Elif> elifBranch, Block elseBranch) {
            this.ifBlock = ifBlock;
            this.condition = condition;
            this.elifBranch = elifBranch;
            this.elseBranch = elseBranch;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
           return visitor.visitIfStmt(this);
        }
    }

    static class Elif {
        final Expr condition;
        final Block block;
        Elif(Expr condition, Block block) {
            this.condition = condition;
            this.block = block;
        }
    }

    static class Program extends Stmt {
        final List<Stmt> statements;
        Program(List<Stmt> statements) {
            this.statements = statements;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitProgramStmt(this);
        }
    }

    static class Return extends Stmt {
        final Symbol keyword;
        final Expr value;
        Return(Symbol keyword, Expr value) {
            this.keyword = keyword;
            this.value = value;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitReturnStmt(this);
        }
    }

    static class While extends Stmt {
        final Expr condition;
        final Block body;
        While(Expr condition, Block body) {
            this.condition = condition;
            this.body = body;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitWhileStmt(this);
        }
    }

    <T> T accept(Visitor<T> visitor) {
        return null;
    }

}
