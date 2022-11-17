package interpreter;

import ast.*;

public class Interpreter extends minipythonAstVisitor<Object> {

    Environment env;

    public Interpreter(Environment env){
        this.env = env;
    }

    @Override
    public Object visit(Program node) {
        env.print();
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(FunctionDefinition node) {
        Environment prev = env;
        env = env.getChildEnvironment();
        env.print();
        for(Node child: node.children){
            visit(child);
        }
        env = prev;
        return null;
    }

    @Override
    public Object visit(ClassDefinition node) {
        Environment prev = env;
        env = env.getChildEnvironment();
        for(Node child: node.children){
            visit(child);
        }
        env = prev;
        return null;
    }

    @Override
    public Object visit(ArgList node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(ReturnStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(WhileStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(BranchStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(IfStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(ElifStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(ElseStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(AssignmentStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(StatementBlock node) {
        Environment prev = null;
        if(env.scope.getType() == null){
            prev = env;
            env = env.getChildEnvironment();
        }
        env.print();
        for(Node child: node.children){
            visit(child);
        }
        if(prev != null){
            env = prev;
        }
        return null;
    }

    @Override
    public Object visit(FunctionCall node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(BinaryOperator node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(NotNode node) {
        for(Node child: node.children){
            visit(child);
        }
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
