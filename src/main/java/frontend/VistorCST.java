package frontend;

import antlr.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VistorCST extends minipythonBaseVisitor<Stmt> {

    public VisitorCSTExpr exprVisitor = new VisitorCSTExpr();

    private static Stmt fileToAST(String fileName) throws IOException {
        minipythonLexer lexer = new minipythonLexer(CharStreams.fromFileName(fileName + ".mpy"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        minipythonParser parser = new minipythonParser(tokens);
        ParseTree cst = parser.program();
        VistorCST visitorCST = new VistorCST();

        return visitorCST.visit(cst);
    }
    @Override
    public Stmt visitProgram(minipythonParser.ProgramContext ctx) {
        List<Stmt> statements = new ArrayList<>();
        for (minipythonParser.Import_statementContext importStatementContext : ctx.import_statement()) {
            Stmt statement = visit(importStatementContext);
            if(statement instanceof Stmt.Program program){
                statements.addAll(program.statements);
            } else {
                statements.add(statement);
            }
        }
        for (minipythonParser.StatementContext statementContext : ctx.statement()) {
            statements.add(visit(statementContext));
        }
        return new Stmt.Program(statements);
    }

    @Override public Stmt visitImport_statement(minipythonParser.Import_statementContext ctx) {
        if(ctx.file_import() != null){
            return visitFile_import(ctx.file_import());
        } else {
            return visitMember_import(ctx.member_import());
        }
    }

    @Override public Stmt visitFile_import(minipythonParser.File_importContext ctx) {
        try {
            return fileToAST(ctx.NAME().getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override public Stmt visitMember_import(minipythonParser.Member_importContext ctx){
        Stmt.Program ast = null;
        try {
            ast = (Stmt.Program) fileToAST(ctx.NAME(0).getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(Stmt statement: ast.statements){
            if(statement instanceof Stmt.Function func){
                if(func.symbol.lexeme.equals(ctx.NAME(1).getText())){
                    return func;
                }
            }
            if(statement instanceof Stmt.Class clazz){
                if(clazz.symbol.lexeme.equals(ctx.NAME(1).getText())){
                    return clazz;
                }
            }
        }
        throw new RuntimeException("Requested object " + ctx.NAME(1).getText() + " does not exist");
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
            for (int i = 0; i < ctx.parameters().name().size(); i++) {
                params.add(new Symbol(SymbolType.NAME, ctx.parameters().name(i).getText(), null, ctx.parameters().name(i).NAME(0).getSymbol().getLine(), ctx.parameters().name(i).NAME(0).getSymbol().getCharPositionInLine()));
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

