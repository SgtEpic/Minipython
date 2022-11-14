
public abstract class Symbol {

    protected String name;
    protected Type type;
    protected Scope scope;

    public Symbol(){

    }

    public Symbol(String name){
        this.name = name;
    }

    public Symbol(String name, Scope scope){
        this.name = name;
        this.scope = scope;

    }

    public String getName(){
        return name;
    }

    public Scope getScope(){
        return scope;
    }

    public void setScope(Scope scope){
        this.scope = scope;
    }
}