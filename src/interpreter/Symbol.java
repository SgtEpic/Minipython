package interpreter;

class Symbol {
    final SymbolType type;
    final String lexeme;
    final Object literal;
    final int line;
    final int charPositionInLine;

    Symbol(SymbolType type, String lexeme, Object literal, int line, int charPositionInLine) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
        this.charPositionInLine = charPositionInLine;
    }

    public String toString() {
        return type + " " + lexeme + " " + literal;
    }
}