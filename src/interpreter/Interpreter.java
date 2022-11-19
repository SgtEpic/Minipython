package interpreter;

import ast.*;

public class Interpreter extends minipythonAstVisitor<Value> {

    Environment env;

    public Interpreter(Environment env){
        this.env = env;
    }

    @Override
    public Value visit(Program node) {
        for(Node child: node.children){
            visit(child);
        }
        env.printChildren();
        return null;
    }

    @Override
    public Value visit(FunctionDefinition node) {
        Environment prev = env;
        env = env.getChildEnvironment();
        for(Node child: node.children){
            visit(child);
        }
        env = prev;
        return null;
    }

    @Override
    public Value visit(ClassDefinition node) {
        Environment prev = env;
        env = env.getChildEnvironment();
        for(Node child: node.children){
            visit(child);
        }
        env = prev;
        return null;
    }

    @Override
    public Value visit(ArgList node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Value visit(ReturnStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Value visit(WhileStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Value visit(BranchStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Value visit(IfStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Value visit(ElifStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Value visit(ElseStatement node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Value visit(AssignmentStatement node) {
//        for(Node child: node.children){
//            visit(child);
//        }

        String symbolName = node.children.get(0).name;
        Value rightChild = (Value)visit(node.children.get(1));
        env.assign(symbolName, rightChild);
        return null;
    }

    @Override
    public Value visit(StatementBlock node) {
        Environment prev = null;
        if(env.scope.getType() == null){
            prev = env;
            env = env.getChildEnvironment();
        }

        for(Node child: node.children){
            visit(child);
        }
        if(prev != null){
            env = prev;
        }
        return null;
    }

    @Override
    public Value visit(FunctionCall node) {
        for(Node child: node.children){
            visit(child);
        }
        return null;
    }

    @Override
    public Value visit(BinaryOperator node) {

        Value left =visit(node.children.get(0));
        Value right = visit(node.children.get(1));

        switch(node.name){
            case "+":
                if(left.getType() == Type.INT && right.getType() == Type.INT){
                    return new Value(Type.INT, env,(Integer)left.getValue() + (Integer)right.getValue());
                }else if(left.getType() == Type.STRING && right.getType() == Type.STRING) {
                    return new Value(Type.STRING, env, (String) left.getValue() + (String) right.getValue());
                }else{
                    throw new RuntimeException("cannot add the objects");
                }
            case "-":
                if(left.getType() == Type.INT && right.getType() == Type.INT){
                    return new Value(Type.INT, env,(Integer)left.getValue() - (Integer)right.getValue());
                }else{
                    throw new RuntimeException("cannot subtract the objects");
                }
            case "*":
                if(left.getType() == Type.INT && right.getType() == Type.INT){
                    return new Value(Type.INT, env,(Integer)left.getValue() * (Integer)right.getValue());
                }else{
                    throw new RuntimeException("cannot multiply the objects");
                }
            case "/":

                if(left.getType() == Type.INT && right.getType() == Type.INT){
                    if(((Integer)right.getValue()) == 0){
                        throw new ArithmeticException("cannot divide by 0");
                    }
                    return new Value(Type.INT, env,(Integer)left.getValue() / (Integer)right.getValue());
                }else{
                    throw new RuntimeException("cannot divide the objects");
                }
            case "<":
                if(left.getType() == Type.INT && right.getType() == Type.INT){
                    return new Value(Type.BOOL, env,(Integer)left.getValue() < (Integer)right.getValue());
                }else{
                    throw new RuntimeException("< not allowed");
                }
            case "<=":
                if(left.getType() == Type.INT && right.getType() == Type.INT){
                    return new Value(Type.BOOL, env,(Integer)left.getValue() <= (Integer)right.getValue());
                }else{
                    throw new RuntimeException("<= not allowed");
                }
            case ">":
                if(left.getType() == Type.INT && right.getType() == Type.INT){
                    return new Value(Type.BOOL, env,(Integer)left.getValue() > (Integer)right.getValue());
                }else{
                    throw new RuntimeException("> not allowed");
                }
            case ">=":
                if(left.getType() == Type.INT && right.getType() == Type.INT){
                    return new Value(Type.BOOL, env,(Integer)left.getValue() >= (Integer)right.getValue());
                }else{
                    throw new RuntimeException(">= not allowed");
                }
            case "==":
                return new Value(Type.BOOL, env,left.getValue().equals (right.getValue()));

            case "!=":
                return new Value(Type.BOOL, env,!(left.getValue().equals (right.getValue())));
            case "and":
                boolean leftBool = parseBool(left);
                boolean rightBool = parseBool(right);
                return new Value(Type.BOOL, env,leftBool && rightBool);
            case "or":
                leftBool = parseBool(left);
                rightBool = parseBool(right);
                return new Value(Type.BOOL, env,leftBool || rightBool);
            default:
                throw new RuntimeException("something went wrong: " + node.position);
        }

    }

    private boolean parseBool(Value v){
        boolean b = true;
        switch(v.getType()){
            case INT:
                b = (Integer)v.getValue() != 0 ;
                break;
            case STRING:
                b = !((String)v.getValue()).isEmpty();
                break;
            case BOOL:
                b = (Boolean)v.getValue();
                break;
            case FUNCTION:
            case INSTANCE:
                b = true;
                break;
            default:
                b = false;
                break;
        }
        return b;
    }

    @Override
    public Value visit(NotNode node) {
        Value v = visit(node.children.get(0));
        boolean b = parseBool(v);
        return new Value(Type.BOOL, env, !b);
    }


    @Override
    public Value visit(NumberNode node) {
        return new Value(Type.INT, env, Integer.parseInt(node.name));
    }

    @Override
    public Value visit(NameNode node) {
        return env.get(node.name);
    }

    @Override
    public Value visit(StringNode node) {

        return new Value(Type.STRING, env, node.name.substring(1,node.name.length()-1));
    }

    @Override
    public Value visit(BooleanNode node) {
        return new Value(Type.BOOL, env, new Boolean(node.name));
    }

    @Override
    public Value visit(ZeroNode node) {
        return new Value(Type.INT, env, 0);
    }
}
