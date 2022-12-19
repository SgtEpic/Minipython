package frontend;

class Symbol {
    final SymbolType type;
    final String lexeme;
    final Object literal;
    final int line;
    final int charPositionInLine;

    boolean packing = false;

    boolean array = false;
    Symbol index = null;

    Symbol(SymbolType type, String lexeme, Object literal, int line, int charPositionInLine) {
        this.type = type;
        this.literal = literal;
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.lexeme = trimLexme(lexeme);
    }

    String trimLexme(String lexeme){
        if(lexeme.startsWith("*")){
            packing = true;
            return lexeme.substring(1);
        }
        if(lexeme.contains("[") && lexeme.contains("]")){
            array = true;
            String index_string = lexeme.substring(lexeme.indexOf("[")+1, lexeme.indexOf("]"));
            try{
                Integer.parseInt(index_string);
                index = new Symbol(SymbolType.NUMBER, index_string, null, line, charPositionInLine);
            } catch (NumberFormatException e) {
                index = new Symbol(SymbolType.NAME, index_string, null, line, charPositionInLine);
            }
            return lexeme.substring(0, lexeme.indexOf("["));
        } else {
            return lexeme;
        }
    }

    public String toString() {
        return type + " " + lexeme + " " + literal;
    }
}
