package frontend;

import antlr.*;

import java.util.ArrayList;
import java.util.List;

public class VistorCST extends minipythonBaseVisitor<Stmt> {

    public VisitorCSTExpr exprVisitor = new VisitorCSTExpr();

    @Override
    public Stmt visitProgram(minipythonParser.ProgramContext ctx) {
        List<Stmt> statements = new ArrayList<>();
        for (minipythonParser.StatementContext statementContext : ctx.statement()) {
            statements.add(visit(statementContext));
        }
        return new Stmt.Program(statements);
    }

    @Override
    public Stmt visitBlock(minipythonParser.BlockContext ctx) {
        List<Stmt> statements = new ArrayList<>();
        for (minipythonParser.StatementContext statementContext : ctx.statement()) {
            statements.add(visit(statementContext));
        }
        return new Stmt.Block(statements);
    }

    @Override
    public Stmt visitBranch_stmt(minipythonParser.Branch_stmtContext ctx) {
        // if branch
        Expr condition = exprVisitor.visit(ctx.if_stmt().expression_stmt());
        Stmt.Block ifBlock = (Stmt.Block) visit(ctx.if_stmt().block());

        List<Stmt.Elif> elifBranch = new ArrayList<>();
        // elif branch
        if (ctx.elif_stmt() != null) {
            for (minipythonParser.Elif_stmtContext elif : ctx.elif_stmt()) {
                Expr elifCondition = exprVisitor.visit(elif.expression_stmt());
                Stmt.Block elifBlock = (Stmt.Block) visit(elif.block());
                elifBranch.add(new Stmt.Elif(elifCondition, elifBlock));
            }
        }

        // else branch
        Stmt.Block elseBranch = null;
        if (ctx.else_stmt() != null) {
            elseBranch = (Stmt.Block) visit(ctx.else_stmt().block());
        }
        return new Stmt.If(condition, ifBlock, elifBranch, elseBranch);
    }

    @Override
    public Stmt visitClassdef(minipythonParser.ClassdefContext ctx) {
        Symbol className = new Symbol(SymbolType.NAME, ctx.NAME(0).getText(), null, ctx.NAME(0).getSymbol().getLine(), ctx.NAME(0).getSymbol().getCharPositionInLine());
        Expr.Variable superClass = null;
        // check for superclass
        if (ctx.NAME().size() == 2) {
            Symbol name = new Symbol(SymbolType.NAME, ctx.NAME(1).getText(), null, ctx.NAME(1).getSymbol().getLine(), ctx.NAME(1).getSymbol().getCharPositionInLine());
            superClass = new Expr.Variable(name);
        }
        // methods
        List<Stmt.Function> methods = new ArrayList<>();
        for (minipythonParser.FuncdefContext funcdef : ctx.funcdef()) {
            methods.add((Stmt.Function) visit(funcdef));
        }
        return new Stmt.Class(className, superClass, methods);
    }

    @Override
    public Stmt visitExpression_stmt(minipythonParser.Expression_stmtContext ctx) {
        return new Stmt.Expression(exprVisitor.visit(ctx.expression()));
    }

    @Override
    public Stmt visitFuncdef(minipythonParser.FuncdefContext ctx) {
        Symbol name = new Symbol(SymbolType.NAME, ctx.NAME().getText(), null, ctx.NAME().getSymbol().getLine(), ctx.NAME().getSymbol().getCharPositionInLine());
        List<Symbol> params = new ArrayList<>();
        if (ctx.parameters() != null) {
            for (int i = 0; i < ctx.parameters().NAME().size(); i++) {
                params.add(new Symbol(SymbolType.NAME, ctx.parameters().NAME(i).getText(), null, ctx.parameters().NAME(i).getSymbol().getLine(), ctx.parameters().NAME(i).getSymbol().getCharPositionInLine()));
            }
        }
        Stmt.Block block = (Stmt.Block) visit(ctx.block());
        return new Stmt.Function(name, params, block);
    }

    @Override
    public Stmt visitReturn_stmt(minipythonParser.Return_stmtContext ctx) {
        Symbol symbol = new Symbol(SymbolType.RETURN, ctx.RETURN().getText(), null, ctx.RETURN().getSymbol().getLine(), ctx.RETURN().getSymbol().getCharPositionInLine());
        Expr value = null;
        if (ctx.expression_stmt() != null) {
            value = exprVisitor.visit(ctx.expression_stmt());
        }
        return new Stmt.Return(symbol, value);
    }

    @Override
    public Stmt visitWhile_stmt(minipythonParser.While_stmtContext ctx) {
        Expr condition = exprVisitor.visit(ctx.expression_stmt());
        Stmt.Block block = (Stmt.Block) visit(ctx.block());
        return new Stmt.While(condition, block);
    }


}

