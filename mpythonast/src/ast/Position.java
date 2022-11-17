package ast;

public class Position {
    public final int line;
    public final int positionInLine;
    public Position(int line, int positionInLine) {
        this.line = line;
        this.positionInLine = positionInLine;
    }

    @Override
    public String toString(){
        return "Line: " + this.line + ", Column: " + this.positionInLine;
    }
}
