package interpreter;

import ast.*;

public class Interpreter extends minipythonAstVisitor {

    @Override
    public Object visit(Program node) {
        return null;
    }

    @Override
    public Object visit(FunctionDefinition node) {
        return null;
    }

    @Override
    public Object visit(ClassDefinition node) {
        return null;
    }

    @Override
    public Object visit(ArgList node) {
        return null;
    }

    @Override
    public Object visit(ReturnStatement node) {
        return null;
    }

    @Override
    public Object visit(WhileStatement node) {
        return null;
    }

    @Override
    public Object visit(BranchStatement node) {
        return null;
    }

    @Override
    public Object visit(IfStatement node) {
        return null;
    }

    @Override
    public Object visit(ElifStatement node) {
        return null;
    }

    @Override
    public Object visit(ElseStatement node) {
        return null;
    }

    @Override
    public Object visit(AssignmentStatement node) {
        return null;
    }

    @Override
    public Object visit(StatementBlock node) {
        return null;
    }

    @Override
    public Object visit(FunctionCall node) {
        return null;
    }

    @Override
    public Object visit(BinaryOperator node) {
        return null;
    }

    @Override
    public Object visit(NotNode node) {
        return null;
    }

    @Override
    public Object visit(NumberNode node) {
        return null;
    }

    @Override
    public Object visit(NameNode node) {
        return null;
    }

    @Override
    public Object visit(StringNode node) {
        return null;
    }

    @Override
    public Object visit(BooleanNode node) {
        return null;
    }

    @Override
    public Object visit(ZeroNode node) {
        return null;
    }
}
