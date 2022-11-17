package symboltable;

import ast.Node;

import java.util.ArrayList;
import java.util.Objects;

public class ErrorHandler {

    //stores occured errors which can be printed at the end of the traversal
    ArrayList<SymboltableErr> errors = new ArrayList<>();

    //
    public void addError(String message, String symbol_name, Node node, Scope scope){
        if(errors.isEmpty()){
            errors.add(new SymboltableErr(message, symbol_name, scope, node));
        } else {
            for(SymboltableErr err: errors){
                if(!Objects.equals(err.symbol, symbol_name) || err.scope != scope){
                    errors.add(new SymboltableErr(message, symbol_name, scope, node));
                    break;
                }
            }
        }
    }

    public Boolean isEmpty(){
        return errors.isEmpty();
    }

    public ArrayList<SymboltableErr> getErrorList(){
        return errors;
    }

}
