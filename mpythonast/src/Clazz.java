public class Clazz extends Symbol implements Type{
    private Clazz parent;
    private Scope scope;

    public Clazz(String name, Clazz parent, Scope scope) {
        super(name);
        this.parent = parent;
        this.scope = scope;
    }

    public Clazz(String name, Clazz parent) {
        super(name);
        this.parent = parent;
    }


    public Clazz getParent(){
        return this.parent;
    }

    @Override
    public Scope getScope() {
        return scope;
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
