public class AstVisitorPrinter extends minipythonAstVisitor<Node>{

    @Override
    public Node visit(Program node) {
        print(node);
        System.out.print("\n");
        return node;
    }

    @Override
    public Node visit(FunctionDefinition node) {
        print(node);
        return node;
    }
    @Override
    public Node visit(ClassDefinition node) {
        print(node);
        return node;
    }
    @Override
    public Node visit(ArgList node) {
        print(node);
        return node;
    }

    @Override
    public Node visit(ReturnStatement node) {
        print(node);
        return node;
    }

    @Override
    public Node visit(WhileStatement node) {
        print(node);
        return node;
    }

    @Override
    public Node visit(BranchStatement node) {
        print(node);
        return node;
    }

    @Override
    public Node visit(IfStatement node) {
        print(node);
        return node;
    }

    @Override
    public Node visit(ElifStatement node) {
        print(node);
        return node;
    }

    @Override
    public Node visit(ElseStatement node) {
        print(node);
        return node;
    }


    @Override
    public Node visit(AssignmentStatement node) {
        print(node);
        return node;
    }

    @Override
    public Node visit(StatementBlock node) {
        print(node);
        return node;
    }

    @Override
    public Node visit(FunctionCall node) {
        print(node);
        return node;
    }

    @Override
    public Node visit(BinaryOperator node) {
        print(node);
        return node;
    }


    @Override
    public Node visit(NotNode node) {
        print(node);
        return node;
    }

    @Override
    public Node visit(NumberNode node) {
        System.out.print(node.name + " ");
        return node;
    }

    @Override
    public Node visit(NameNode node) {
        System.out.print(node.name + " ");
        return node;
    }

    @Override
    public Node visit(StringNode node) {
        System.out.print(node.name + " ");
        return node;
    }

    @Override
    public Node visit(BooleanNode node) {
        System.out.print(node.name + " ");
        return node;
    }

    @Override
    public Node visit(ZeroNode node) {
        System.out.print(node.name + " ");
        return node;
    }

    private void print(Node node) {
        System.out.print("(");
        System.out.print(node.name + " ");
        for (Node child : node.children) {
            visit(child);
        }
        System.out.print(")");
    }

}
