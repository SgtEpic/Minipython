import java.util.ArrayList;
import java.util.HashMap;

public class Scope {
    private HashMap<String,Symbol> symbols;



    private Scope enclosingScope;

    private Symbol functionSymbol;
    //private Node functionNode

    private final int depth;

    private Clazz clazz = null;



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

    public Symbol resolve_member(String name){
        if(clazz == null){
            return null;
        }
        if (symbols.containsKey(name)){
            return symbols.get(name);
        } else if(clazz.getParent() != null) {
            return clazz.getParent().getScope().resolve_member(name);
        }

        return null;
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

    public void print() {
        for (String key : symbols.keySet()) {
            System.out.println(this.depth + ": " + key);
        }
        if (enclosingScope != null) {
            enclosingScope.print();
        }
        //System.out.println(this.depth);
        System.out.println("");
    }

    public int getDepth(){
        return this.depth;
    }

    public Symbol getClazz(){
        return this.clazz;
    }
}
