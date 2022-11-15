import java.util.ArrayList;
import java.util.HashMap;

public class Scope implements Type{
    private HashMap<String,Symbol> symbols;



    private Scope enclosingScope;

    private Symbol functionSymbol;
    //private Node functionNode

    private final int depth;



    private Clazz clazz = null;

    //ClassLogic
    private Type type;
    private Symbol classSymbol;
    private Scope parentClass;


    public Scope(){
        this.symbols = new HashMap<>();
        this.enclosingScope = null;
        this.depth = 0;
    }

    public Scope(Scope enclosingScope, Clazz clazz){
        symbols = new HashMap<>();
        this.enclosingScope = enclosingScope;
        this.depth = enclosingScope.depth + 1;
        this.clazz = clazz;
    }


    public Scope(Scope enclosingScope){
        symbols = new HashMap<>();
        this.enclosingScope = enclosingScope;
        this.depth = enclosingScope.depth + 1;
    }


    public Scope(Scope enclosingScope, Symbol classSymbol){
        symbols = new HashMap<>();
        this.enclosingScope = enclosingScope;
        this.depth = enclosingScope.depth + 1;
        this.classSymbol = classSymbol;
    }
    public Scope(Scope enclosingScope, Symbol classSymbol, Scope parentClass){
        symbols = new HashMap<>();
        this.enclosingScope = enclosingScope;
        this.classSymbol = classSymbol;
        this.parentClass = parentClass;
        this.depth = enclosingScope.depth + 1;
    }





    public Scope(Scope enclosingScope, HashMap<String,Symbol> symbols){
        this.symbols = new HashMap<>(symbols);
        this.enclosingScope = enclosingScope;
        this.depth = enclosingScope.depth + 1;
    }


    public void bind(Symbol symbol){
        symbols.put(symbol.getName(), symbol);
//        symbol.setScope(this);
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
                //go into Scope of member class and search there for next member
                Scope memberScope = (Scope) foundMember.getType();
                return memberScope.resolve_member(names, index);
            //found member is not a class
            }else{
                return resolve_member(names, index);
            }

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

    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    public void setEnclosingScope(Scope enclosingScope) {
        this.enclosingScope = enclosingScope;
    }

    public Symbol getFunctionSymbol() {
        return functionSymbol;
    }

    public void setFunctionSymbol(Symbol functionSymbol) {
        this.functionSymbol = functionSymbol;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void print() {
        for (String key : symbols.keySet()) {
            System.out.println(this.depth + ": " + key);
        }
        System.out.println("");
    }

    public int getDepth(){
        return this.depth;
    }

    public Symbol getClazz(){
        return this.clazz;
    }
}
