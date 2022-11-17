package symboltable;

public class Symbol {

    protected String name;
    protected Type type;
    protected Scope scope;

    public Symbol(){}

    public Symbol(String name){
        this.name = name;
    }

    public Symbol(String name, Type type){
        this.name = name;
        this.type = type;

    }

    public Symbol(String name, Scope scope){
        this.name = name;
        this.scope = scope;

    }

    public String getName(){
        return name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
