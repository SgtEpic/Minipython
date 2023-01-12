package frontend;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.*;
import java.util.ArrayList;
import java.util.List;

public class VisitorCSTExpr extends minipythonBaseVisitor<Expr> {
    @Override
    public Expr visitExpression(minipythonParser.ExpressionContext ctx) {
        return visit(ctx.assignment());
    }

    @Override
    public Expr visitAssignment(minipythonParser.AssignmentContext ctx) {
        // check for assignment
        if (ctx.ASSIGN() != null || ctx.ASSIGNPLUS() != null ||  ctx.ASSIGNMINUS() != null
            ||ctx.ASSIGNSTAR() != null ||ctx.ASSIGNDIVIDE() != null) {
            // get lvalue of assignment
            Expr value;
            if(ctx.assignment() != null){
                value = visit(ctx.assignment());
            }else{
                value = visit(ctx.lambda());
            }
            // check for call assignment
            if (ctx.call() != null) {
                Expr expr = visit(ctx.call());
                Symbol symbol;
                if(ctx.assignment() != null){
                    symbol = new Symbol(SymbolType.NAME, ctx.name().getText(), null, ctx.name().NAME(0).getSymbol().getLine(), ctx.name().NAME(0).getSymbol().getCharPositionInLine());
                }else{
                    symbol= new Symbol(SymbolType.NAME, ctx.NAME().getText(), null, ctx.NAME().getSymbol().getLine(), ctx.NAME().getSymbol().getCharPositionInLine());
                }

                if (expr instanceof Expr.Get) {
                    Expr.Get g = (Expr.Get) expr;
                    // chain last getter
                    Expr.Get get = new Expr.Get(g, symbol);
                    // create setter from getter
                    return new Expr.Set(get.object, get.symbol, determineValueForCallAssignment(ctx, value, get));
                } else if (expr instanceof Expr.Variable) {
                    Expr.Variable v = (Expr.Variable) expr;
                    // create getter from variable
                    Expr.Get get = new Expr.Get(v, symbol);
                    // create setter from getter
                    return new Expr.Set(get.object, get.symbol, determineValueForCallAssignment(ctx, value, get));
                } else if (expr instanceof Expr.Self) {
                    Expr.Self s = (Expr.Self) expr;
                    // create getter from self
                    Expr.Get get = new Expr.Get(s, symbol);
                    // create setter from getter
                    return new Expr.Set(get.object, get.symbol, determineValueForCallAssignment(ctx, value, get));
                }
                // TODO throw error
            }
            // no call -> simple assignment
            else {
                Symbol t;
                if(ctx.assignment() != null){
                    t = new Symbol(SymbolType.NAME, ctx.name().getText(), null, ctx.name().NAME(0).getSymbol().getLine(), ctx.name().NAME(0).getSymbol().getCharPositionInLine());
                }else{
                    t = new Symbol(SymbolType.NAME, ctx.NAME().getText(), null, ctx.NAME().getSymbol().getLine(), ctx.NAME().getSymbol().getCharPositionInLine());
                }

                return new Expr.Assignment(t, determineValueForStandardAssignment(ctx, value));
            }


        }
        // visit logic_or
        return visit(ctx.lambda());
    }

    //depending on ctx a binary is built as value, example a+=5 becomes a = a+5
    public Expr determineValueForStandardAssignment(minipythonParser.AssignmentContext ctx, Expr value){
        if(ctx.ASSIGNPLUS() != null){
                return new Expr.Binary(new Expr.Variable(new Symbol(SymbolType.NAME, ctx.NAME().getText(),null, ctx.NAME().getSymbol().getLine(), ctx.NAME().getSymbol().getCharPositionInLine())),
                    new Symbol(SymbolType.PLUS, ctx.ASSIGNPLUS().getText(), null, ctx.ASSIGNPLUS().getSymbol().getLine(), ctx.ASSIGNPLUS().getSymbol().getCharPositionInLine()),
                    value);
        } else if(ctx.ASSIGNMINUS() != null){
                return new Expr.Binary(new Expr.Variable(new Symbol(SymbolType.NAME, ctx.NAME().getText(),null, ctx.NAME().getSymbol().getLine(), ctx.NAME().getSymbol().getCharPositionInLine())),
                    new Symbol(SymbolType.MINUS, ctx.ASSIGNMINUS().getText(), null, ctx.ASSIGNMINUS().getSymbol().getLine(), ctx.ASSIGNMINUS().getSymbol().getCharPositionInLine()),
                    value);
        }else if(ctx.ASSIGNSTAR() != null){
            return new Expr.Binary(new Expr.Variable(new Symbol(SymbolType.NAME, ctx.NAME().getText(),null, ctx.NAME().getSymbol().getLine(), ctx.NAME().getSymbol().getCharPositionInLine())),
                    new Symbol(SymbolType.STAR, ctx.ASSIGNSTAR().getText(), null, ctx.ASSIGNSTAR().getSymbol().getLine(), ctx.ASSIGNSTAR().getSymbol().getCharPositionInLine()),
                    value);
        }else if(ctx.ASSIGNDIVIDE() != null){
            return new Expr.Binary(new Expr.Variable(new Symbol(SymbolType.NAME, ctx.NAME().getText(),null, ctx.NAME().getSymbol().getLine(), ctx.NAME().getSymbol().getCharPositionInLine())),
                    new Symbol(SymbolType.DIVIDE, ctx.ASSIGNDIVIDE().getText(), null, ctx.ASSIGNDIVIDE().getSymbol().getLine(), ctx.ASSIGNDIVIDE().getSymbol().getCharPositionInLine()),
                    value);
        }
        return value;
    }

    public Expr determineValueForCallAssignment(minipythonParser.AssignmentContext ctx, Expr value, Expr getExpression){
        if(ctx.ASSIGNPLUS() != null){
            return new Expr.Binary(getExpression,
                new Symbol(SymbolType.PLUS, ctx.ASSIGNPLUS().getText(), null, ctx.ASSIGNPLUS().getSymbol().getLine(), ctx.ASSIGNPLUS().getSymbol().getCharPositionInLine()),
                value);
        } else if(ctx.ASSIGNMINUS() != null){
            return new Expr.Binary(getExpression,
                new Symbol(SymbolType.MINUS, ctx.ASSIGNMINUS().getText(), null, ctx.ASSIGNMINUS().getSymbol().getLine(), ctx.ASSIGNMINUS().getSymbol().getCharPositionInLine()),
                value);
        }else if(ctx.ASSIGNSTAR() != null){
            return new Expr.Binary(getExpression,
                new Symbol(SymbolType.STAR, ctx.ASSIGNSTAR().getText(), null, ctx.ASSIGNSTAR().getSymbol().getLine(), ctx.ASSIGNSTAR().getSymbol().getCharPositionInLine()),
                value);
        }else if(ctx.ASSIGNDIVIDE() != null){
            return new Expr.Binary(getExpression,
                new Symbol(SymbolType.DIVIDE, ctx.ASSIGNDIVIDE().getText(), null, ctx.ASSIGNDIVIDE().getSymbol().getLine(), ctx.ASSIGNDIVIDE().getSymbol().getCharPositionInLine()),
                value);
        }
        return value;
    }

    @Override
    public Expr visitLambda(minipythonParser.LambdaContext ctx) {
        // check for logic_or
        if (ctx.logic_or().size() == 1) {
            return visit(ctx.logic_or(0));
        }
        // check for condition expr
        if (ctx.logic_or().size() > 1) {
            Expr thenBranch = visit(ctx.logic_or(0));
            Expr condition = visit(ctx.logic_or(1));
            Expr elseBranch = visit(ctx.lambda());
            return new Expr.Condition(condition, thenBranch, elseBranch);
        }
        // check for lambda expr
        if (!ctx.lambda_fn().isEmpty()) {
            return visit(ctx.lambda_fn());
        }
        return null;
    }

    @Override
    public Expr visitLambda_fn(minipythonParser.Lambda_fnContext ctx) {
        Expr.Lambda lambda;
        // get params (args not supported)
        List<Symbol> params = new ArrayList<>();
        if (ctx.parameters() != null) {
            for (int i = 0; i < ctx.parameters().name().size(); i++) {
                params.add(new Symbol(SymbolType.NAME, ctx.parameters().name(i).getText(), null, ctx.parameters().name(i).NAME(0).getSymbol().getLine(), ctx.parameters().name(i).NAME(0).getSymbol().getCharPositionInLine()));
            }
        }
/*
        Expr condition = null;
        // check for condition
        if (ctx.lambda().IF() != null) {
            condition = visit(ctx.lambda());
        }
*/
        // get statement
        Expr expr = visit(ctx.lambda());

        return new Expr.Lambda(params, expr);
    }

    @Override
    public Expr visitLogic_or(minipythonParser.Logic_orContext ctx) {
        // check for or
        if (ctx.OR() != null) {
            Symbol symbol = new Symbol(SymbolType.OR, ctx.OR().getText(), null, ctx.OR().getSymbol().getLine(), ctx.OR().getSymbol().getCharPositionInLine());
            return new Expr.Logical(visit(ctx.logic_and()), symbol, visit(ctx.logic_or()));
        }
        // visit and_logic
        return visit(ctx.logic_and());
    }

    @Override
    public Expr visitLogic_and(minipythonParser.Logic_andContext ctx) {
        // check for and
        if (ctx.AND() != null) {
            Symbol symbol = new Symbol(SymbolType.AND, ctx.AND().getText(), null, ctx.AND().getSymbol().getLine(), ctx.AND().getSymbol().getCharPositionInLine());
            return new Expr.Logical(visit(ctx.equality()), symbol, visit(ctx.logic_and()));
        }
        // visit equality
        return visit(ctx.equality());
    }

    @Override
    public Expr visitEquality(minipythonParser.EqualityContext ctx) {
        // check for equal ==
        if (ctx.EQ() != null) {
            Symbol symbol = new Symbol(SymbolType.EQ, "==", null, ctx.EQ().getSymbol().getLine(), ctx.EQ().getSymbol().getCharPositionInLine());
            return new Expr.Binary(visit(ctx.comparison()), symbol, visit(ctx.equality()));
        }
        // check for not equal !=
        else if (ctx.NEQ() != null) {
            Symbol symbol = new Symbol(SymbolType.NEQ, "!=", null, ctx.NEQ().getSymbol().getLine(), ctx.NEQ().getSymbol().getCharPositionInLine());
            return new Expr.Binary(visit(ctx.comparison()), symbol, visit(ctx.equality()));
        }
        return visit(ctx.comparison());
    }

    @Override
    public Expr visitComparison(minipythonParser.ComparisonContext ctx) {
        // check for less than <
        if (ctx.LT() != null) {
            Symbol symbol = new Symbol(SymbolType.LT, "<", null, ctx.LT().getSymbol().getLine(), ctx.LT().getSymbol().getCharPositionInLine());
            return new Expr.Binary(visit(ctx.term()), symbol, visit(ctx.comparison()));
        }
        // check for greater than >
        if (ctx.GT() != null) {
            Symbol symbol = new Symbol(SymbolType.GT, ">", null, ctx.GT().getSymbol().getLine(), ctx.GT().getSymbol().getCharPositionInLine());
            return new Expr.Binary(visit(ctx.term()), symbol, visit(ctx.comparison()));
        }
        // check for less than or equal to <=
        if (ctx.LTE() != null) {
            Symbol symbol = new Symbol(SymbolType.LTE, "<=", null, ctx.LTE().getSymbol().getLine(), ctx.LTE().getSymbol().getCharPositionInLine());
            return new Expr.Binary(visit(ctx.term()), symbol, visit(ctx.comparison()));
        }
        // check for greater than or equal to >=
        if (ctx.GTE() != null) {
            Symbol symbol = new Symbol(SymbolType.GTE, ">=", null, ctx.GTE().getSymbol().getLine(), ctx.GTE().getSymbol().getCharPositionInLine());
            return new Expr.Binary(visit(ctx.term()), symbol, visit(ctx.comparison()));
        }
        return visit(ctx.term());
    }

    @Override
    public Expr visitTerm(minipythonParser.TermContext ctx) {
        // check for addition
        if (ctx.PLUS() != null) {
            Symbol symbol = new Symbol(SymbolType.PLUS, ctx.PLUS().getText(), null, ctx.PLUS().getSymbol().getLine(), ctx.PLUS().getSymbol().getCharPositionInLine());
            return new Expr.Binary(visit(ctx.factor()), symbol, visit(ctx.term()));
        }
        if (ctx.MINUS() != null) {
            Symbol symbol = new Symbol(SymbolType.MINUS, ctx.MINUS().getText(), null, ctx.MINUS().getSymbol().getLine(), ctx.MINUS().getSymbol().getCharPositionInLine());
            return new Expr.Binary(visit(ctx.factor()), symbol, visit(ctx.term()));
        }
        return visit(ctx.factor());
    }

    @Override
    public Expr visitFactor(minipythonParser.FactorContext ctx) {
        // check for multiplication
        if (ctx.STAR() != null) {
            Symbol symbol = new Symbol(SymbolType.STAR, ctx.STAR().getText(), null, ctx.STAR().getSymbol().getLine(), ctx.STAR().getSymbol().getCharPositionInLine());
            return new Expr.Binary(visit(ctx.not()), symbol, visit(ctx.factor()));
        }
        // check for division
        if (ctx.DIVIDE() != null) {
            Symbol symbol = new Symbol(SymbolType.DIVIDE, ctx.DIVIDE().getText(), null, ctx.DIVIDE().getSymbol().getLine(), ctx.DIVIDE().getSymbol().getCharPositionInLine());
            return new Expr.Binary(visit(ctx.not()), symbol, visit(ctx.factor()));
        }
        return visit(ctx.not());
    }

    @Override
    public Expr visitNot(minipythonParser.NotContext ctx) {
        // check for not
        if (ctx.NOT() != null) {
            Symbol symbol = new Symbol(SymbolType.NOT, ctx.NOT().getText(), null, ctx.NOT().getSymbol().getLine(), ctx.NOT().getSymbol().getCharPositionInLine());
            return new Expr.Unary(symbol, visit(ctx.not()));
        }
        if(ctx.inc_dec() != null){
            return visit(ctx.inc_dec());
        }
        return visit(ctx.unary());
    }

    @Override
    public Expr visitPREFIX(minipythonParser.PREFIXContext ctx) {
        if (ctx.INCREMENT() != null) {
            Symbol symbol = new Symbol(SymbolType.INCREMENT, ctx.INCREMENT().getText(), "++", ctx.INCREMENT().getSymbol().getLine(), ctx.INCREMENT().getSymbol().getCharPositionInLine());
            return new Expr.Unary(symbol, visit(ctx.call()), false);
        }
        if (ctx.DECREMENT() != null ) {
            Symbol symbol = new Symbol(SymbolType.DECREMENT, ctx.DECREMENT().getText(), "--", ctx.DECREMENT().getSymbol().getLine(), ctx.DECREMENT().getSymbol().getCharPositionInLine());
            return new Expr.Unary(symbol, visit(ctx.call()), false);
        }
        return null;
    }

    @Override
    public Expr visitPOSTFIX(minipythonParser.POSTFIXContext ctx) {
        if (ctx.INCREMENT() != null) {
            Symbol symbol = new Symbol(SymbolType.INCREMENT, ctx.INCREMENT().getText(), "++", ctx.INCREMENT().getSymbol().getLine(), ctx.INCREMENT().getSymbol().getCharPositionInLine());
            return new Expr.Unary(symbol, visit(ctx.call()), true);
        }
        if (ctx.DECREMENT() != null ) {
            Symbol symbol = new Symbol(SymbolType.DECREMENT, ctx.DECREMENT().getText(), "--", ctx.DECREMENT().getSymbol().getLine(), ctx.DECREMENT().getSymbol().getCharPositionInLine());
            return new Expr.Unary(symbol, visit(ctx.call()), true);
        }
        return null;
    }

    @Override
    public Expr visitUnary(minipythonParser.UnaryContext ctx) {
        // check for unary minus
        if (ctx.MINUS() != null) {
            Symbol symbol = new Symbol(SymbolType.MINUS, ctx.MINUS().getText(), null, ctx.MINUS().getSymbol().getLine(), ctx.MINUS().getSymbol().getCharPositionInLine());
            return new Expr.Unary(symbol, visit(ctx.call()));
        }
        // check for unary plus
        if (ctx.PLUS() != null) {
            Symbol symbol = new Symbol(SymbolType.PLUS, ctx.PLUS().getText(), null, ctx.PLUS().getSymbol().getLine(), ctx.PLUS().getSymbol().getCharPositionInLine());
            return new Expr.Unary(symbol, visit(ctx.call()));
        }
        return visit(ctx.call());
    }

    @Override
    public Expr visitCall(minipythonParser.CallContext ctx) {
        // check for call or instance get
        if (ctx.L_PAREN() != null || ctx.DOT() != null) {
            Expr expr = visit(ctx.primary());
            int dotIndex = 0;
            int parenIndex = 0;
            Symbol symbol;
            for (ParseTree child : ctx.children) {
                switch(child.getText()) {
                    case "(":
                        List<Expr> arguments = new ArrayList<>();
                        // check for arguments
                        if (!ctx.arguments().isEmpty()) {
                            for (minipythonParser.ExpressionContext expression : ctx.arguments(parenIndex).expression()) {
                                arguments.add(visit(expression));
                            }
                        }
                        symbol = new Symbol(SymbolType.R_PAREN, ctx.R_PAREN(parenIndex).getText(), null, ctx.R_PAREN(parenIndex).getSymbol().getLine(), ctx.R_PAREN(parenIndex).getSymbol().getCharPositionInLine());
                        expr = new Expr.Call(expr, symbol, arguments);
                        parenIndex++;
                        break;
                    case ".":
                        symbol = new Symbol(SymbolType.NAME, ctx.name(dotIndex).getText(), null, ctx.name(dotIndex).NAME(0).getSymbol().getLine(), ctx.name(dotIndex).NAME(0).getSymbol().getCharPositionInLine());
                        expr = new Expr.Get(expr, symbol);
                        dotIndex++;
                        break;
                }
            }
            return expr;
        }
        return visit(ctx.primary());
    }

    @Override
    public Expr visitPrimary(minipythonParser.PrimaryContext ctx) {
        // check for name
        if (ctx.name() != null && ctx.SUPER() == null) {
            // check for keyword self
            if (ctx.name().NAME(0).getText().equals("self")) {
                Symbol symbol = new Symbol(SymbolType.SELF, ctx.name().getText(), null, ctx.name().NAME(0).getSymbol().getLine(), ctx.name().NAME(0).getSymbol().getCharPositionInLine());
                return new Expr.Self(symbol);
            }
            // simple name
            return new Expr.Variable(new Symbol(SymbolType.NAME, ctx.name().getText(), null, ctx.name().NAME(0).getSymbol().getLine(), ctx.name().NAME(0).getSymbol().getCharPositionInLine()));
        }
        // check for number
        if (ctx.NUMBER() != null) {
            return new Expr.Literal(Integer.parseInt(ctx.NUMBER().getText()));
        }
        // check for string
        if (ctx.STRING() != null) {
            // remove quotes substring(1, len-1)
            return new Expr.Literal(ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1));
        }
        // check for boolean value true
        if (ctx.TRUE() != null) {
            return new Expr.Literal(true);
        }
        // check for boolean value false
        if (ctx.FALSE() != null) {
            return new Expr.Literal(false);
        }
        // check for super call
        if (ctx.SUPER() != null) {
            Symbol superSymbol = new Symbol(SymbolType.SUPER, ctx.SUPER().getText(), null, ctx.SUPER().getSymbol().getLine(), ctx.SUPER().getSymbol().getCharPositionInLine());
            List<Expr> arguments = new ArrayList<>();
            if (ctx.arguments() != null) {
                for (minipythonParser.ExpressionContext expression : ctx.arguments().expression()) {
                    arguments.add(visit(expression));
                }
            }
            return new Expr.Super(superSymbol, arguments);
        }
        // check for grouping
        if (ctx.L_PAREN() != null) {
            return new Expr.Grouping(visit(ctx.expression()));
        }

        if(ctx.list_expression() != null){
            return visit(ctx.list_expression());
        }

        // not implemented
        /*if (ctx.NONE() != null) {
            return new Expr.Literal(null);
        }*/
        return visit(ctx.expression());
    }


    @Override
    public Expr visitList_expression(minipythonParser.List_expressionContext ctx) {
        List<Expr> arguments = new ArrayList<>();
        if(!ctx.isEmpty() && ctx.arguments() != null &&!ctx.arguments().isEmpty()){
            for (minipythonParser.ExpressionContext expression : ctx.arguments().expression()) {
                arguments.add(visit(expression));
            }
        }
        return new Expr.Array(arguments);
    }
}
