public class SymboltableErr {
    String message;
    Scope scope;
    String symbol;

    Node node;

    public SymboltableErr(String message, String symbol, Scope scope, Node node){
        this.message = message;
        this.scope = scope;
        this.symbol = symbol;
        this.node = node;
    }

    @Override
    public String toString(){
        return this.message + " at: " +  this.node.position;
    }
}
