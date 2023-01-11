package frontend;

import java.util.List;
import java.util.Optional;

public abstract class Expr {
    int distance = -1;
    interface Visitor<T> {
        T visitAssignmentExpr(Assignment expr);
        T visitBinaryExpr(Binary expr);
        T visitCallExpr(Call expr);
        T visitConditionExpr(Condition expr);
        T visitGetExpr(Get expr);
        T visitGroupingExpr(Grouping expr);
        T visitLambdaExpr(Lambda expr);
        T visitLiteralExpr(Literal expr);
        T visitLogicalExpr(Logical expr);
        T visitSelfExpr(Self expr);
        T visitSetExpr(Set expr);
        T visitSuperExpr(Super expr);
        T visitUnaryExpr(Unary expr);
        T visitVariableExpr(Variable expr);
        T visitListExpr(Array expr);

    }

    static class Assignment extends Expr {
        final Symbol symbol;
        final Expr value;
        Boolean declaration = false;
        Assignment(Symbol symbol, Expr value) {
            this.symbol = symbol;
            this.value = value;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitAssignmentExpr(this);
        }
    }

    static class Binary extends Expr {
        final Expr left;
        final Symbol operator;
        final Expr right;
        Binary(Expr left, Symbol operator, Expr right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitBinaryExpr(this);
        }
   }

   static class Call extends Expr {
         final Expr callee;
         final Symbol paren;
         final List<Expr> arguments;
         Call(Expr callee, Symbol paren, List<Expr> arguments) {
              this.callee = callee;
              this.paren = paren;
              this.arguments = arguments;
         }

         @Override
         <T> T accept(Visitor<T> visitor) {
              return visitor.visitCallExpr(this);
         }
   }

   static class Condition extends Expr {
            final Expr condition;
            final Expr thenBranch;
            final Expr elseBranch;
            Condition(Expr condition, Expr thenBranch, Expr elseBranch) {
                this.condition = condition;
                this.thenBranch = thenBranch;
                this.elseBranch = elseBranch;
            }
            @Override
            <T> T accept(Visitor<T> visitor) {
                return visitor.visitConditionExpr(this);
            }
   }

   static class Get extends Expr {
         final Expr object;
         final Symbol symbol;
         Get(Expr object, Symbol symbol) {
              this.object = object;
              this.symbol = symbol;
         }

         @Override
         <T> T accept(Visitor<T> visitor) {
              return visitor.visitGetExpr(this);
         }
   }
    static class Grouping extends Expr {
        final Expr expression;
        Grouping(Expr expression) {
            this.expression = expression;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitGroupingExpr(this);
        }
    }

    static class Lambda extends Expr {
        final List<Symbol> parameters;
        final Expr expr;
        Lambda(List<Symbol> parameters, Expr expr) {
            this.parameters = parameters;
            this.expr = expr;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitLambdaExpr(this);
        }
    }

   static class Literal extends Expr {
        final Object value;
        Literal(Object value) {
            this.value = value;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitLiteralExpr(this);
        }
    }

    static class Logical extends Expr {
        final Expr left;
        final Symbol operator;
        final Expr right;
        Logical(Expr left, Symbol operator, Expr right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitLogicalExpr(this);
        }
    }

    static class Self extends Expr {
        final Symbol keyword;
        Self(Symbol keyword) {
            this.keyword = keyword;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitSelfExpr(this);
        }
    }

    static class Set extends Expr {
        final Expr object;
        final Symbol symbol;
        final Expr value;
        Set(Expr object, Symbol symbol, Expr value) {
            this.object = object;
            this.symbol = symbol;
            this.value = value;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitSetExpr(this);
        }
    }

    static class Super extends Expr {
        final Symbol keyword;
        final List<Expr> arguments;
        Super(Symbol keyword, List<Expr> arguments) {
            this.keyword = keyword;
            this.arguments = arguments;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitSuperExpr(this);
        }
    }

    static class Unary extends Expr {
        final Symbol operator;
        final Expr right;

        Boolean postfix;
        Unary(Symbol operator, Expr right) {
            this.operator = operator;
            this.right = right;
        }

        Unary(Symbol operator, Expr right, Boolean postfix) {
            this.operator = operator;
            this.right = right;
            this.postfix = postfix;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitUnaryExpr(this);
        }
    }

    static class Variable extends Expr {
        final Symbol symbol;
        Variable(Symbol symbol) {
            this.symbol = symbol;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitVariableExpr(this);
        }
    }

    static class Array extends Expr {
        final List<Expr> content;
        Array(List<Expr> content) {
            this.content = content;
        }

        @Override
        <T> T accept(Visitor<T> visitor) {
            return visitor.visitListExpr(this);
        }
    }

    abstract <T> T accept(Visitor<T> visitor);
}
