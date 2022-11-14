import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class SymboltableListener {
    Scope scope;
    ArrayList<SymboltableErr> errors = new ArrayList<>();

    private void addError(String message, String symbol_name, Node node){
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

    public boolean walk(Node node){
        walk_node(node);
        if(!errors.isEmpty()){
            for(SymboltableErr error: errors){
                System.err.println(error);
            }
//            throw new RuntimeException("There were errors");
            return false;
        }
        return true;
    }
    public void walk_node(Node node){
        enter(node);
        for(Node child: node.children){
            walk_node(child);
        }
        exit(node);
    }

    private void enter(Node node) {
        if (node instanceof Program) {
            enter_program_node((Program) node);
        } else if (node instanceof FunctionDefinition) {
            enter_fuction_definiton_node((FunctionDefinition) node);
        } else if (node instanceof ClassDefinition) {
            enter_class_definition_node((ClassDefinition) node);
        } else if (node instanceof ArgList) {
            enter_arglist_node((ArgList) node);
        } else if (node instanceof ReturnStatement) {
            enter_return_node((ReturnStatement) node);
        } else if (node instanceof WhileStatement) {
            enter_while_node((WhileStatement) node);
        } else if (node instanceof BranchStatement) {
            enter_branch_node((BranchStatement) node);
        } else if (node instanceof IfStatement) {
            enter_if_node((IfStatement) node);
        } else if (node instanceof ElifStatement) {
            enter_elif_node((ElifStatement) node);
        } else if (node instanceof ElseStatement) {
            enter_else_node((ElseStatement) node);
        } else if (node instanceof AssignmentStatement) {
            enter_assignment_node((AssignmentStatement) node);
        } else if (node instanceof StatementBlock) {
            enter_statement_node((StatementBlock) node);
        } else if (node instanceof FunctionCall) {
            enter_function_call_node((FunctionCall) node);
        } else if (node instanceof BinaryOperator) {
            enter_binary_operator_node((BinaryOperator) node);
        } else if (node instanceof NotNode) {
            enter_not_node((NotNode) node);
        } else if (node instanceof NumberNode) {
            enter_number_node((NumberNode) node);
        } else if (node instanceof NameNode) {
            enter_name_node((NameNode) node);
        } else if (node instanceof StringNode) {
            enter_string_node((StringNode) node);
        } else if (node instanceof BooleanNode) {
            enter_boolean_node((BooleanNode) node);
        } else if (node instanceof ZeroNode) {
            enter_zero_node((ZeroNode) node);
        } else {
            throw new RuntimeException("Unknown node type");
        }
    }

    private void enter_program_node(Program node){
        scope= new Scope();
        scope.bind(new BuiltIn("print"));
    }

    private void enter_fuction_definiton_node(FunctionDefinition node){
        Function func = new Function(node.children.get(0).name);
        scope.bind(func);
        scope.print();
        scope.getClazz().getScope().bind(func);
        scope = new Scope(scope);
    }

    private void enter_class_definition_node(ClassDefinition node){
        Clazz parent = (Clazz) scope.resolve(node.children.get(1).name);
        Clazz clazz = new Clazz(node.children.get(0).name, parent);
        Scope new_scope = new Scope(scope, clazz);

        clazz.setScope(new_scope);
        System.out.println(new_scope.getDepth());
        System.out.println(clazz.getScope().getDepth());
        scope.bind(clazz);
        scope = new_scope;
//        System.out.println(clazz.getScope().equals(new_scope));
    }

    private void enter_arglist_node(ArgList node){
        for(Node child: node.children){
            if(!Objects.equals(child.name, "arg_list")){
                scope.bind(new Variable(child.name));
            }
        }
    }

    private void enter_return_node(ReturnStatement node){

    }

    private void enter_while_node(WhileStatement node){

    }

    private void enter_branch_node(BranchStatement node){

    }

    private void enter_if_node(IfStatement node){

    }

    private void enter_elif_node(ElifStatement node){

    }

    private void enter_else_node(ElseStatement node){

    }

    private void enter_assignment_node(AssignmentStatement node){
        Symbol symbol = scope.resolve(node.children.get(1).children.get(0).name);
        if(symbol instanceof Clazz){
            scope.bind(new Instance(node.children.get(0).name, (Clazz) symbol));
        } else {
            scope.bind(new Variable(node.children.get(0).name));
        }
    }

    private void enter_statement_node(StatementBlock node){
        if(scope.getClazz() == null){
            scope = new Scope(scope);
        }
    }

    private void enter_function_call_node(FunctionCall node) {
        String node_name = node.children.get(0).name;
        if(node_name.contains(".")){
            int index_point = node_name.indexOf(".");
            String instance_name = node_name.substring(0, index_point);
            String member_name = node_name.substring(index_point+1);
            Symbol instance = scope.resolve(instance_name);

            if(instance == null){
                addError(instance_name + " doesn't exist", instance_name, node);
            } else {
                Instance inst = (Instance) instance;
                System.out.println(inst.getClazz().name);
                inst.getClazz().getScope().print();
                if(inst.getClazz().getScope().resolve_member(member_name) == null){
                    addError(member_name + " does not exist", member_name, node);
                }
            }
        } else {
            Symbol func = scope.resolve(node.children.get(0).name);
            if(func instanceof Variable) {
                addError(func.name + " is not a function", func.name, node);
//            throw new Exception(func.name + " is not a function");
            }
        }
    }

    private void enter_binary_operator_node(BinaryOperator node){

    }

    private void enter_not_node(NotNode node){

    }

    private void enter_number_node(NumberNode node){

    }

    private void enter_name_node(NameNode node){

    }

    private void enter_string_node(StringNode node){

    }

    private void enter_boolean_node(BooleanNode node){

    }

    private void enter_zero_node(ZeroNode node){

    }

    private void exit(Node node) {
        if (node instanceof Program) {
            exit_program_node((Program) node);
        } else if (node instanceof FunctionDefinition) {
            exit_fuction_definiton_node((FunctionDefinition) node);
        } else if (node instanceof ClassDefinition) {
            exit_class_definition_node((ClassDefinition) node);
        } else if (node instanceof ArgList) {
            exit_arglist_node((ArgList) node);
        } else if (node instanceof ReturnStatement) {
            exit_return_node((ReturnStatement) node);
        } else if (node instanceof WhileStatement) {
            exit_while_node((WhileStatement) node);
        } else if (node instanceof BranchStatement) {
            exit_branch_node((BranchStatement) node);
        } else if (node instanceof IfStatement) {
            exit_if_node((IfStatement) node);
        } else if (node instanceof ElifStatement) {
            exit_elif_node((ElifStatement) node);
        } else if (node instanceof ElseStatement) {
            exit_else_node((ElseStatement) node);
        } else if (node instanceof AssignmentStatement) {
            exit_assignment_node((AssignmentStatement) node);
        } else if (node instanceof StatementBlock) {
            exit_statement_node((StatementBlock) node);
        } else if (node instanceof FunctionCall) {
            exit_function_call_node((FunctionCall) node);
        } else if (node instanceof BinaryOperator) {
            exit_binary_operator_node((BinaryOperator) node);
        } else if (node instanceof NotNode) {
            exit_not_node((NotNode) node);
        } else if (node instanceof NumberNode) {
            exit_number_node((NumberNode) node);
        } else if (node instanceof NameNode) {
            exit_name_node((NameNode) node);
        } else if (node instanceof StringNode) {
            exit_string_node((StringNode) node);
        } else if (node instanceof BooleanNode) {
            exit_boolean_node((BooleanNode) node);
        } else if (node instanceof ZeroNode) {
            exit_zero_node((ZeroNode) node);
        } else {
            throw new RuntimeException("Unknown node type");
        }
    }

    private void exit_program_node(Program node){

    }

    private void exit_fuction_definiton_node(FunctionDefinition node){
        scope = scope.getEnclosingScope();
    }

    private void exit_class_definition_node(ClassDefinition node){
        scope = scope.getEnclosingScope();
    }

    private void exit_arglist_node(ArgList node){
        for(Node child: node.children){
            if(!Objects.equals(child.name, "arg_list")){
                scope.bind(new Variable(child.name));
            }
        }
    }

    private void exit_return_node(ReturnStatement node){

    }

    private void exit_while_node(WhileStatement node){

    }

    private void exit_branch_node(BranchStatement node){

    }

    private void exit_if_node(IfStatement node){

    }

    private void exit_elif_node(ElifStatement node){

    }

    private void exit_else_node(ElseStatement node){

    }

    private void exit_assignment_node(AssignmentStatement node){

    }

    private void exit_statement_node(StatementBlock node){
        //scope.print();
        if(scope.getClazz() == null){
            scope = scope.getEnclosingScope();
        }
    }

    private void exit_function_call_node(FunctionCall node){

    }

    private void exit_binary_operator_node(BinaryOperator node){

    }

    private void exit_not_node(NotNode node){

    }

    private void exit_number_node(NumberNode node){

    }

    private void exit_name_node(NameNode node) {
        if(scope.resolve(node.name) == null){
            addError("Could not find symbol: " + node.name, node.name, node);
//            throw new Exception("Could not find symbol: " + node.name);
        }
    }

    private void exit_string_node(StringNode node){

    }

    private void exit_boolean_node(BooleanNode node){

    }

    private void exit_zero_node(ZeroNode node){

    }
}