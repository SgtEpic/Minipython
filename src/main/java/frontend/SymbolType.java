package frontend;

public enum SymbolType {
    // Single-character tokens.
    L_PAREN, R_PAREN, COLON,
    COMMA, DOT, MINUS, PLUS, STAR, DIVIDE, INCREMENT, DECREMENT,

    // One or two character tokens.
    LT, GT, LTE, GTE, EQ, NEQ, ASSIGN,

    // Literals.
    NAME, STRING, NUMBER,

    // Keywords.
    AND, CLASS, ELSE, FALSE, DEF, IF, OR,
    RETURN, SUPER, TRUE, VAR, WHILE, NOT,
    SELF,

    EOF
}
