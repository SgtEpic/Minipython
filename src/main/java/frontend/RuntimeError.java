package frontend;

class RuntimeError extends RuntimeException {
    final Symbol symbol;

    RuntimeError(Symbol symbol, String message) {
        super(message);
        this.symbol = symbol;
    }
}
