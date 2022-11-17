package symboltable;

import java.util.ArrayList;
import java.util.HashMap;

public class Scope implements Type{
    private final HashMap<String,Symbol> symbols;

    private final ArrayList<Scope> children = new ArrayList<>();
    private String name;
    private final Scope enclosingScope;

    private final int depth;

    //ClassLogic
    private Type type;
    private Scope parentClass;


    public Scope(){
        this.symbols = new HashMap<>();
        this.enclosingScope = null;
        this.depth = 0;
    }

    public Scope(Scope enclosingScope){
        symbols = new HashMap<>();
        this.enclosingScope = enclosingScope;
        this.depth = enclosingScope.depth + 1;
        enclosingScope.children.add(this);
    }

    public Scope(Scope enclosingScope, Scope parentClass){
        symbols = new HashMap<>();
        this.enclosingScope = enclosingScope;
        this.parentClass = parentClass;
        this.depth = enclosingScope.depth + 1;
        enclosingScope.children.add(this);
    }

    public void bind(Symbol symbol){
        symbols.put(symbol.getName(), symbol);
    }

    public Symbol resolve(String name){
        if (symbols.containsKey(name)){
            return symbols.get(name);
        }
        else if(enclosingScope == null) {
            return null;
        }
        return enclosingScope.resolve(name);

    }

    public Symbol resolve_member(String[] names, int index){
        //all names processed
        if(names.length <= index ) {

            return symbols.get(names[index-1]);
        }
        //member exists
        if (symbols.containsKey(names[index])){

            Symbol foundMember = symbols.get(names[index]);
            //point to next member
            index++;
            //foundMember is a class
            if(foundMember.getType() != null) {
                //go into symboltable.Scope of member class and search there for next member
                Scope memberScope = (Scope) foundMember.getType();
                return memberScope.resolve_member(names, index);
            //found member is not a class
            }else{
                return resolve_member(names, index);
            }
        //look in parent class
        }else if(parentClass != null) {
            return parentClass.resolve_member(names, index);

        }

        return null;

    }

    public Symbol resolve_members(String[] names){
        int counter = 0;
        if(type == null){
            return null;
        }

        return resolve_member(names, 0);
    }

    public void printChildren(){
        print();
        for(Scope child: children){
            child.printChildren();
        }
    }


    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void print() {
        System.out.println(name + ": " + depth);
        for (String key : symbols.keySet()) {
            System.out.println(this.depth + ": " + key);
        }
        if(symbols.isEmpty()){
            System.out.println("No symbols here");
        }
        System.out.println("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepth() {
        return depth;
    }

    public HashMap<String, Symbol> getSymbols() {
        return symbols;
    }

    public ArrayList<Scope> getChildren() {
        return children;
    }

    public Scope getParentClass() {
        return parentClass;
    }

}
