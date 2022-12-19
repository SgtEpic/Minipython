package frontend;

import CBuilder.Expression;
import CBuilder.Statement;
import CBuilder.ProgramBuilder;
import CBuilder.conditions.IfThenElseStatement;
import CBuilder.conditions.conditionalStatement.ElifStatement;
import CBuilder.conditions.conditionalStatement.ElseStatement;
import CBuilder.conditions.conditionalStatement.IfStatement;
import CBuilder.conditions.conditionalStatement.WhileStatement;
import CBuilder.keywords.bool.AndKeyword;
import CBuilder.keywords.bool.NotKeyword;
import CBuilder.keywords.bool.OrKeyword;
import CBuilder.literals.BoolLiteral;
import CBuilder.literals.IntLiteral;
import CBuilder.literals.StringLiteral;
import CBuilder.objects.*;
import CBuilder.objects.functions.Argument;
import CBuilder.objects.functions.Function;
import CBuilder.objects.functions.ReturnStatement;
import CBuilder.variables.Assignment;
import CBuilder.Reference;
import CBuilder.variables.VariableDeclaration;

import java.nio.file.Path;
import java.util.*;

public class IntermediateCode implements Expr.Visitor<Statement>, Stmt.Visitor<Statement>{

    ProgramBuilder builder;
    Path fileOutput;

    ArrayList<Frontend_Function> functions = new ArrayList<>();

    private int list_expr_count = 0;
    List<Statement> statements = new ArrayList<>();

    IntermediateCode(ProgramBuilder programBuilder, Path fileOutput) {
        this.builder = programBuilder;
        this.fileOutput = fileOutput;
    }

    public void generateProgram(Stmt stmt) {
        stmt.accept(this);
    }

    @Override
    public Statement visitProgramStmt(Stmt.Program stmt) {
        stmt.statements.forEach(statement -> statements.add(statement.accept(this)));
        for (Statement statement : statements) {
            if (statement instanceof Function) {
                builder.addFunction((Function) statement);
            } else if (statement instanceof MPyClass) {
                builder.addClass((MPyClass) statement);
            }
            else {
                builder.addStatement(statement);
            }
        }
        builder.writeProgram(fileOutput);
        return null;
    }



    @Override
    public Statement visitBlockStmt(Stmt.Block stmt) {
        // never used
        return null;
    }

    @Override
    public Statement visitClassStmt(Stmt.Class stmt) {
        // methods
        List<Function> methods = new ArrayList<>();

        // parent
        Reference parent;
        if (stmt.superclass == null) {
            parent = new Reference("__MPyType_Object");
            // check if __init__ does not exist, add it
            if (stmt.methods.isEmpty() || !stmt.methods.get(0).symbol.lexeme.equals("__init__")) {
                Function f = new Function("__init__", List.of(new SuperCall(List.of())), List.of(new Argument[]{new Argument("self", 0)}), List.of() );
                methods.add(f);
            }
            // if __init__ exists, check if super() is called
            else if (!stmt.methods.get(0).block.statements.isEmpty()) {
               List<Stmt> statements = stmt.methods.get(0).block.statements;
               Expr.Super superCall = new Expr.Super(new Symbol(SymbolType.SUPER, "super", new Object(), 0,0), List.of());
               if (statements.isEmpty()) {
                   statements.add(0, new Stmt.Expression(superCall));
               } else if (statements.get(0) instanceof Stmt.Expression) {
                   Stmt.Expression expr = (Stmt.Expression) statements.get(0);
                   if (!(expr.expression instanceof Expr.Super)) {
                       statements.add(0, new Stmt.Expression(superCall));
                   }
               }
            }
        } else {
            parent = new Reference(stmt.superclass.symbol.lexeme);
        }

        // add methods
        stmt.methods.forEach(method -> methods.add((Function) method.accept(this)));

        return new MPyClass(stmt.symbol.lexeme, parent, methods, Map.of());
    }

    @Override
    public Statement visitExpressionStmt(Stmt.Expression stmt) {
        return stmt.expression.accept(this);
    }

    @Override
    public Statement visitFunctionStmt(Stmt.Function stmt) {
        // arguments
        int argumentAmount = 0;
        int argumentAmountBeforePacking = 0;
        boolean packing = false;
        List<Argument> arguments = new ArrayList<>();
        for (int i=0; i<stmt.params.size(); i++) {
            argumentAmount++;
            if(stmt.params.get(i).packing){
                packing = true;
            }
            if(!packing){
                argumentAmountBeforePacking++;
            }
            arguments.add(new Argument(stmt.params.get(i).lexeme, i));
        }

        functions.add(new Frontend_Function(stmt.symbol.lexeme, packing, argumentAmount, argumentAmountBeforePacking));

        // body
        List<Statement> body = new ArrayList<>();
       /* // if method is __init__ and first statement is not super, add super
        if (stmt.symbol.lexeme.equals("__init__")) {
           if (!stmt.block.statements.isEmpty()) {
               if (stmt.block.statements.get(0) instanceof Stmt.Expression) {
                   Stmt.Expression expr = (Stmt.Expression) stmt.block.statements.get(0);
                     if (!(expr.expression instanceof Expr.Super)) {
                         body.add(new SuperCall(List.of()));
                     }
               }
           }
        }*/
        stmt.block.statements.forEach(statement -> body.add(statement.accept(this)));

        List<VariableDeclaration> localVariables = new ArrayList<>();
        return new Function(stmt.symbol.lexeme, body, arguments, localVariables);
    }

    @Override
    public Statement visitIfStmt(Stmt.If stmt) {
        // if stmt
        Expression ifCondition = (Expression) stmt.condition.accept(this);
        List<Statement> ifBody = new ArrayList<>();
        stmt.ifBlock.statements.forEach(statement -> ifBody.add(statement.accept(this)));
        IfStatement ifStmt = new IfStatement(ifCondition, ifBody);

        // elif stmt
        List<ElifStatement> elifStatements = new ArrayList<>();
        stmt.elifBranch.forEach(elifBlock -> {
            Expression elifCondition = (Expression) elifBlock.condition.accept(this);
            List<Statement> elifBody = new ArrayList<>();
            elifBlock.block.statements.forEach(statement -> elifBody.add(statement.accept(this)));
            elifStatements.add(new ElifStatement(elifCondition, elifBody));
        });

        // else stmt
        List<Statement> elseBody = new ArrayList<>();
        stmt.elseBranch.statements.forEach(statement -> elseBody.add(statement.accept(this)));
        ElseStatement elseStmt = new ElseStatement(elseBody);

        return new IfThenElseStatement(ifStmt, Optional.of(elifStatements), Optional.of(elseStmt));
    }


    @Override
    public Statement visitReturnStmt(Stmt.Return stmt) {
        return new ReturnStatement((Expression) stmt.value.accept(this));
    }

    @Override
    public Statement visitWhileStmt(Stmt.While stmt) {
        Expression e = (Expression) stmt.condition.accept(this);
        List<Statement> statements = new ArrayList<>();
        for (Stmt s : stmt.body.statements) {
            statements.add(s.accept(this));
        }
        return new WhileStatement(e, statements);
    }

    @Override
    public Statement visitAssignmentExpr(Expr.Assignment expr) {
        // TODO fix variable declaration and assignment
        if(expr.symbol.array){
            Expression e = (Expression) expr.value.accept(this);
            List<Expression> args = new ArrayList<>();
            if(expr.symbol.index.type == SymbolType.NUMBER){
                args.add(new IntLiteral(Integer.parseInt(expr.symbol.index.lexeme)));
            } else {
                args.add(new Reference(expr.symbol.index.lexeme));
            }
            args.add(e);
            return new Call(new AttributeReference("set", new Reference(expr.symbol.lexeme)), args);
        }
        VariableDeclaration varD = new VariableDeclaration(expr.symbol.lexeme);
        builder.addVariable(varD);
        Reference r = new Reference(expr.symbol.lexeme);
        Expression e = (Expression) expr.value.accept(this);
        Statement s = new Assignment(r, e);
        return s;
    }

    @Override
    public Expression visitBinaryExpr(Expr.Binary expr) {
        Expression left = (Expression) expr.left.accept(this);
        Expression right = (Expression) expr.right.accept(this);
        switch (expr.operator.type) {
            case EQ:
                return new Call(new AttributeReference("__eq__", left), List.of(right));
            case NEQ:
                return new Call(new AttributeReference("__neq__", left), List.of(right));
            case LT:
                return new Call(new AttributeReference("__lt__", left), List.of(right));
            case LTE:
                return new Call(new AttributeReference("__lte__", left), List.of(right));
            case GT:
                return new Call(new AttributeReference("__gt__", left), List.of(right));
            case GTE:
                return new Call(new AttributeReference("__gte__", left), List.of(right));
            case PLUS:
                return new Call(new AttributeReference("__add__", left), List.of(right));
            case MINUS:
                return new Call(new AttributeReference("__sub__", left), List.of(right));
            case DIVIDE:
                return new Call(new AttributeReference("__div__", left), List.of(right));
            case STAR:
                return new Call(new AttributeReference("__mul__", left), List.of(right));
        }
        return null;
    }

    @Override
    public Expression visitCallExpr(Expr.Call expr) {
        Expression callee = (Expression) expr.callee.accept(this);
        List<Expression> arguments = new ArrayList<>();

        String functionName = callee.buildExpression();
        for(Frontend_Function func: functions){
            if(func.name().equals(functionName)){
                for(int i = 0; i < func.paramAmountBeforePacking(); i++){
                    arguments.add((Expression) expr.arguments.get(i).accept(this));
                }
                if(func.packing()){
                    VariableDeclaration varD = new VariableDeclaration("list" + list_expr_count);
                    builder.addVariable(varD);
                    Reference r = new Reference("list" + list_expr_count);
                    statements.add(new Assignment(r, new Call(new Reference("List"), List.of())));
                    if(expr.arguments.size() > func.paramAmountBeforePacking()){
                        for(int i = func.paramAmountBeforePacking(); i < expr.arguments.size(); i++){
                            Expression item_expression = (Expression)expr.arguments.get(i).accept(this);
                            statements.add(new Call(new AttributeReference("append", r), List.of(item_expression)));
                        }
                    }
                    arguments.add(r);
                    list_expr_count++;
                }
                return new Call(callee, arguments);
            }
        }

        for (Expr argument : expr.arguments) {
            arguments.add((Expression)argument.accept(this));
        }
        return new Call(callee, arguments);
    }

    @Override
    public Expression visitGetExpr(Expr.Get expr) {
        Expression e = (Expression) expr.object.accept(this);
        return new AttributeReference(expr.symbol.lexeme, e);
    }

    @Override
    public Expression visitGroupingExpr(Expr.Grouping expr) {
        return (Expression) expr.expression.accept(this);
    }

    @Override
    public Expression visitLiteralExpr(Expr.Literal expr) {
        if (expr.value instanceof String) {
            return new StringLiteral((String) expr.value);
        }
        if (expr.value instanceof Boolean) {
            return new BoolLiteral((Boolean) expr.value);
        }
        if (expr.value instanceof Integer) {
            return new IntLiteral((Integer) expr.value);
        }

        return null;
    }

    @Override
    public Expression visitLogicalExpr(Expr.Logical expr) {
        Expression left = (Expression) expr.left.accept(this);
        Expression right = (Expression) expr.right.accept(this);
        switch(expr.operator.type) {
            case AND:
                return new AndKeyword(left, right);
            case OR:
                return new OrKeyword(left, right);
        }
        return null;
    }

    @Override
    public Expression visitSelfExpr(Expr.Self expr) {
        return new Reference(expr.keyword.lexeme);
    }

    @Override
    public Statement visitSetExpr(Expr.Set expr) {
        Statement stmt = expr.object.accept(this);
        AttributeReference ref;
        // check if left hand-side of the assign-symbol is a simple reference
        if (stmt instanceof Reference) {
            Reference r = (Reference) stmt;
            ref = new AttributeReference(expr.symbol.lexeme, r);
        }
        // check if left hand-side of the assign-symbol is a chained getter
        else if (stmt instanceof AttributeReference) {
            ref = new AttributeReference(expr.symbol.lexeme, (AttributeReference) stmt);
        }
        else {
            throw new RuntimeException("Invalid set expression");
        }
        Expression value = (Expression) expr.value.accept(this);
        return new AttributeAssignment(ref, value);
    }

    @Override
    public Expression visitSuperExpr(Expr.Super expr) {
        List<Expression> expressions = new ArrayList<>();
        expr.arguments.forEach(e -> expressions.add((Expression) e.accept(this)));
        return new SuperCall(expressions);
    }

    @Override
    public Expression visitUnaryExpr(Expr.Unary expr) {
        Expression right = (Expression) expr.right.accept(this);
        switch(expr.operator.type) {
            case MINUS:
                return new Call(new AttributeReference("__sub__", new IntLiteral(0)), List.of(right));
            case PLUS:
                return new Call(new AttributeReference("__add__", new IntLiteral(0)), List.of(right));
            case NOT:
                return new NotKeyword(right);
        }
        return null;
    }

    @Override
    public Expression visitVariableExpr(Expr.Variable expr) {
        if(expr.symbol.array){
            List<Expression> args = new ArrayList<>();
            if(expr.symbol.index.type == SymbolType.NUMBER){
                args.add(new IntLiteral(Integer.parseInt(expr.symbol.index.lexeme)));
            } else {
                args.add(new Reference(expr.symbol.index.lexeme));
            }
            return new Call(new AttributeReference("get", new Reference(expr.symbol.lexeme)), args);
        }
        return new Reference(expr.symbol.lexeme);
    }

    @Override
    public Statement visitListExpr(Expr.Array expr) {
        VariableDeclaration varD = new VariableDeclaration("list" + list_expr_count);
        builder.addVariable(varD);
        Reference r = new Reference("list" + list_expr_count);

        statements.add(new Assignment(r, new Call(new Reference("List"), List.of())));

        for(Expr item: expr.content){
            Expression item_expression = (Expression)item.accept(this);
            statements.add(new Call(new AttributeReference("append", r), List.of(item_expression)));
        }
        list_expr_count++;
        return r;
    }
}
