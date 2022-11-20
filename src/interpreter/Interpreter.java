package interpreter;

import ast.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Interpreter extends minipythonAstVisitor<Value> {

    Environment env;

    public Interpreter(Environment env){
        this.env = env;
    }

    @Override
    public Value visit(Program node) {
        Function print = new Function(Type.NATIVE_FUNCTION, env, null);
        print.setParam(0, "string");
        env.assign("print", print);
        env.assign("input", new Function(Type.NATIVE_FUNCTION, env, null));
        for(Node child: node.children){
            visit(child);
        }
        System.out.println("------------------------------------------------------------");
        env.printChildren();
        return null;
    }

    /**
     * Creates a function value for a function. Does not execute the function itself
     */
    @Override
    public Value visit(FunctionDefinition node) {
        // get func environment to still be in the same order as the scopes
        Environment func_env = env.getChildEnvironment();
        // value is the node here to give the function call an entry point for execution
        Function value = new Function(Type.FUNCTION, func_env, node);
        env.assign(node.children.get(0).name, value);
        // go to the argument list
        visit(node.children.get(1));

        return null;
    }

    /**
     * Save the name and position of the parameters to the function value.
     * Needed in the function call to identify which argument belongs to which parameter
     */
    @Override
    public Value visit(ArgList node) {
        Function value = (Function) env.get(node.parent.children.get(0).name);
        for(int i = 0; i < node.children.size(); i++){
            value.setParam(i, node.children.get(i).name);
        }
        return null;
    }

    /**
     * Calls the function with the specified name
     */
    @Override
    public Value visit(FunctionCall node) {
        // get the function value
        Function func = (Function) env.get(node.children.get(0).name);

        if (func.getType() == Type.CLASS) {
            // if the function is a class, create a new instance of it
            return ((Klass) func).call(this, null);
        } else {

        }

        if(func.getType() != Type.FUNCTION && func.getType() != Type.NATIVE_FUNCTION){
            throw new RuntimeException(node.children.get(0).name + " is not a function at: " + node.position);
        }

        // check if the amount of arguments is the same as the amount of parameters for the function
        if(node.children.size()-1 != func.getParamAmount()){
            throw new RuntimeException("argument amount not matching in " + node.children.get(0).name);
        }

        // if the function is a native function like print and input
        if(func.getType() == Type.NATIVE_FUNCTION){
            // put the arguments into an array
            Value[] params = new Value[func.getParamAmount()];
            for(int i = 1; i < node.children.size(); i++){
                params[i-1] = visit(node.children.get(i));
            }
            // the return value is whatever the native functions return
            return nativeFunctionCall(node.children.get(0).name, params);
        }

        // only here if it is not a native function
        // get the node as an entry point for function execution
        Node func_node = (Node)func.getValue();
        // go into the function environment
        Environment prev = env;
        env = func.getEnvironment();

        // set all the parameters to the values from the corresponding arguments
        for(int i = 1; i < node.children.size(); i++){
            String paramName = func.getParam(i-1);
            env.assign(paramName, visit(node.children.get(i)));
        }

        // return value is done via an exception thrown in the return statement
        // if there is not a return value to a function then the return value is null
        Value returnValue = null;
        try{
            // visit the statement block of the function
            visit(func_node.children.get(2));
        } catch (ReturnException e){
            returnValue = e.value;
        }
        // go back to the calling environment
        env = prev;
        return returnValue;
    }

    /**
     * Throws an exception containing the return value that has to be caught in the function call
     */
    @Override
    public Value visit(ReturnStatement node) {
        Value value = visit(node.children.get(0));
        throw new ReturnException(value);
    }

    private Value nativeFunctionCall(String funcName, Value[] params){
        switch (funcName){
            case "print":
                System.out.println(params[0].getValue());
                return null;
            case "input":
                Scanner scanner = new Scanner(System.in);
                return new Value(Type.STRING, env, scanner.nextLine());
            default:
                return null;
        }
    }

    @Override
    public Value visit(ClassDefinition node) {
        Environment classEnv = env.getChildEnvironment();
        Klass superclass = null;
        int statementBlockIndex = 1;

        if (node.children.get(1) instanceof NameNode) {
            Value v = visit(node.children.get(1));
            if (v == null) {
                throw new RuntimeException("Superclass not found");
            }
            superclass = (Klass) visit(node.children.get(1)).getValue();
            if (superclass.getType() != Type.CLASS) {
                throw new RuntimeException("Superclass must be a class.");
            }
            statementBlockIndex++;
        }

        HashMap<String, Function> methods = new HashMap<>();
        Environment funcEnv = classEnv.getChildEnvironment();
        for (Node child : node.children.get(statementBlockIndex).children) {
            if (child instanceof FunctionDefinition) {
                Function value = new Function(Type.FUNCTION, funcEnv, node);
                for (int i = 0; i < child.children.size(); i++) {
                    value.setParam(i, child.children.get(i).name);
                }
            }
        }

        Klass value = new Klass(classEnv, node, superclass, methods);
        env.assign(node.children.get(0).name, value);

        return value;
    }

    @Override
    public Value visit(WhileStatement node) {
        Value condition = visit(node.children.get(0));
        while((Boolean)condition.getValue()){
            visit(node.children.get(1));
            condition = visit(node.children.get(0));
        }
        return null;
    }

    @Override
    public Value visit(BranchStatement node) {
        Value condition = visit(node.children.get(0));
        for(int i = 1; i < node.children.size() ; i++){
            if(!(Boolean)condition.getValue()){
                condition = visit(node.children.get(i));
            }else{
                break;
            }

        }

        return null;
    }

    private Value ifElifVisit(Node node){
        Value condition = visit(node.children.get(0));
        if((Boolean)condition.getValue()){
            visit(node.children.get(1));
            return new Value(Type.BOOL, env, true);
        }else {
            return new Value(Type.BOOL, env, false);
        }
    }

    @Override
    public Value visit(IfStatement node) {
        return ifElifVisit(node);
    }

    @Override
    public Value visit(ElifStatement node) {
        return ifElifVisit(node);
    }

    @Override
    public Value visit(ElseStatement node) {
        visit(node.children.get(0));
        return new Value(Type.BOOL, env, true);
    }

    @Override
    public Value visit(AssignmentStatement node) {
        String symbolName = node.children.get(0).name;
        Value rightChild = visit(node.children.get(1));
        if(rightChild == null){
            throw new RuntimeException(node.children.get(1).name +" is not defined at " + node.position);
        }
        env.assign(symbolName, rightChild);
        return null;
    }

    @Override
    public Value visit(StatementBlock node) {
        Environment prev = null;
        if(env.getScope().getType() == null
                && !(node.parent instanceof BranchStatement)
                && !(node.parent instanceof IfStatement)
                && !(node.parent instanceof ElifStatement)
                && !(node.parent instanceof ElseStatement)
                && !(node.parent instanceof WhileStatement)){
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
    public Value visit(BinaryOperator node) {

        Value left =visit(node.children.get(0));
        Value right = visit(node.children.get(1));
        if(left == null){
            throw new RuntimeException(node.children.get(0) + " not defined at " + node.position);
        }

        if(right == null){
            throw new RuntimeException(node.children.get(1) + " not defined at " + node.position);
        }

        switch(node.name){
            case "+":
                if(left.getType() == Type.INT && right.getType() == Type.INT){
                    return new Value(Type.INT, env,(Integer)left.getValue() + (Integer)right.getValue());
                }else if(left.getType() == Type.STRING && right.getType() == Type.STRING) {
                    return new Value(Type.STRING, env, left.getValue() + (String) right.getValue());
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
        boolean b;
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
        return new Value(Type.BOOL, env, Boolean.valueOf(node.name));
    }

    @Override
    public Value visit(ZeroNode node) {
        return new Value(Type.INT, env, 0);
    }
}
