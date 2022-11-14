import java.sql.Statement;

public abstract class minipythonAstVisitor<T> {

    public abstract T visit(Program node);
    public abstract T visit(FunctionDefinition node);
    public abstract T visit(ClassDefinition node);
    public abstract T visit(ArgList node);
    public abstract T visit(ReturnStatement node);
    public abstract T visit(WhileStatement node);
    public abstract T visit(BranchStatement node);
    public abstract T visit(IfStatement node);
    public abstract T visit(ElifStatement node);
    public abstract T visit(ElseStatement node);
    public abstract T visit(AssignmentStatement node);
    public abstract T visit(StatementBlock node);

    public abstract T visit(FunctionCall node);

    public abstract T visit(BinaryOperator node);

    public abstract T visit(NotNode node);

    public abstract T visit(NumberNode node);
    public abstract T visit(NameNode node);
    public abstract T visit(StringNode node);
    public abstract T visit(BooleanNode node);

    public abstract T visit(ZeroNode node);

    public T visit(Node node) {
        if (node instanceof Program) {
            return visit((Program) node);
        } else if (node instanceof FunctionDefinition) {
            return visit((FunctionDefinition) node);
        } else if (node instanceof ClassDefinition) {
            return visit((ClassDefinition) node);
        } else if (node instanceof ArgList) {
            return visit((ArgList) node);
        } else if (node instanceof ReturnStatement) {
            return visit((ReturnStatement) node);
        } else if (node instanceof WhileStatement) {
            return visit((WhileStatement) node);
        } else if (node instanceof BranchStatement) {
            return visit((BranchStatement) node);
        } else if (node instanceof IfStatement) {
            return visit((IfStatement) node);
        } else if (node instanceof ElifStatement) {
            return visit((ElifStatement) node);
        } else if (node instanceof ElseStatement) {
            return visit((ElseStatement) node);
        } else if (node instanceof AssignmentStatement) {
            return visit((AssignmentStatement) node);
        } else if (node instanceof StatementBlock) {
            return visit((StatementBlock) node);
        } else if (node instanceof FunctionCall) {
            return visit((FunctionCall) node);
        } else if (node instanceof BinaryOperator) {
            return visit((BinaryOperator) node);
        } else if (node instanceof NotNode) {
            return visit((NotNode) node);
        } else if (node instanceof NumberNode) {
            return visit((NumberNode) node);
        } else if (node instanceof NameNode) {
            return visit((NameNode) node);
        } else if (node instanceof StringNode) {
            return visit((StringNode) node);
        } else if (node instanceof BooleanNode) {
            return visit((BooleanNode) node);
        } else if (node instanceof ZeroNode) {
            return visit((ZeroNode) node);
        } else {
            throw new RuntimeException("Unknown node type");
        }
    }
}
