package ast;

public class ReturnStatement extends Node{
    public ReturnStatement(Position position) {
        super(position, "return_stmt");
    }
}
