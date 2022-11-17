package interpreter;

import symboltable.Scope;
import symboltable.Symbol;

import java.util.ArrayList;
import java.util.HashMap;

public class Environment {
    String name;
    private int depth;
    Environment baseEnclosing;
    Environment enclosing = null;
    HashMap<String, Value> values = new HashMap<>();
    Scope scope;

    private final ArrayList<Environment> children = new ArrayList<>();

    public Environment(Scope scope, Environment env) {
        this.scope = scope;
        this.name = scope.getName();
        this.depth = scope.getDepth();
        this.enclosing = env;
        if (env != null) {
            this.enclosing.children.add(this);
        }
        this.baseEnclosing = getBaseEnvironmentFromScope();
    }

    public void define(String name, Value value) {
        values.put(name, value);
    }
    public void assign(String name, Value value) {

    }
    public Value get(String name){
        if (values.containsKey(name)){
            return values.get(name);
        }
        else if(enclosing == null) {
            return null;
        }
        return enclosing.get(name);

    }

    public Value resolve_member(String[] names, int index){
        //all names processed
        if(names.length <= index ) {

            return values.get(names[index-1]);
        }
        //member exists
        if (values.containsKey(names[index])){

            Value foundMember = values.get(names[index]);
            //point to next member
            index++;
            //foundMember is a class
            if(foundMember.getType() == Type.CLASS) {
                //go into symboltable.Scope of member class and search there for next member
                Environment memberEnvironment = foundMember.getEnvironment();
                return memberEnvironment.resolve_member(names, index);
                //found member is not a class
            }else{
                return resolve_member(names, index);
            }
            //look in parent class
        }else if(baseEnclosing != null) {
            return baseEnclosing.resolve_member(names, index);

        }

        return null;

    }

    public Value resolve_members(String[] names){
        if(scope.getType() == null){
            return null;
        }

        return resolve_member(names, 0);
    }

    public void print() {
        System.out.println(name + ": " + depth);
        for (String key : values.keySet()) {
            System.out.println(this.depth + ": " + key);
        }
        if(values.isEmpty()){
            System.out.println("No symbols here");
        }
        System.out.println("");
    }

    public void printChildren(){
        print();
        for(Environment child: children){
            child.printChildren();
        }
    }

    private Environment getBaseEnvironmentFromScope() {
       Environment env = enclosing;
       while (env != null) {
           if (scope.getParentClass() == env.scope) {
               return env;
           }
           env = env.enclosing;
       }
       return null;
    }
}
