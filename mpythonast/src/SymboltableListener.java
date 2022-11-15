import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class SymboltableListener {
    //current Scope
    Scope scope;

    static ErrorHandler errors = new ErrorHandler();

    public boolean walk(Node node){
        walk_node(node);
        if(!errors.isEmpty()){
            for(SymboltableErr error: errors.getErrorList()){
                System.err.println(error);
            }
//            throw new RuntimeException("There were errors");
            return false;
        }
        printTableOfScope();
        return true;
    }

    public void walk_node(Node node){
        enter(node);
        for(Node child: node.children){
            walk_node(child);
        }
        exit(node);
        //printTableOfScope();
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

    //creates new Scope at the beginning; should bind all built-in functions
    private void enter_program_node(Program node){
        scope= new Scope();
        scope.bind(new BuiltIn("print"));
        scope.bind(new BuiltIn("self"));
    }

    //
    private void enter_fuction_definiton_node(FunctionDefinition node){
        //gets name of the function
        Function func = new Function(node.children.get(0).name);
        scope.bind(func);
        //scope.print();
        //inside of the function body
        scope = new Scope(scope);
    }

    private void enter_class_definition_node(ClassDefinition node){
        //find the parent
        Symbol parent = scope.resolve(node.children.get(1).name);
        //create the Symbol of the Class
        Symbol classSymbol = new Symbol(node.children.get(0).name);
        //bind Symbol of Class to Scope
        scope.bind(classSymbol);
        //create the ClassScope, needs the parent Scope, the classSymbol and the Scope of the parent
        //in Type is usually the Class (Class should be a type, symbol and scope),
        //but since there is no multiple inheritance, we need to store the Scope in the type of the Symbol
        if(parent != null){
            Scope classScope = new Scope(scope, classSymbol, (Scope)parent.getType());
        }
        Scope classScope = new Scope(scope, classSymbol);
        //store scope in types
        classScope.setType(classScope);
        classSymbol.setType(classScope);
        scope = classScope;


    }
    //binds parameters of arglist, doppelt mit exit?
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
        //für z.B. a = A()
        if(!node.children.get(1).children.isEmpty()){
            Symbol symbol = scope.resolve(node.children.get(1).children.get(0).name);
            if(symbol == null){
                errors.addError(node.children.get(1).children.get(0).name + " not found", node.children.get(1).children.get(0).name, node, scope);
            }
            //is = A() a class?
            else if(symbol.getType() != null){
                scope.bind(new Symbol(node.children.get(0).name, symbol.getType()));
            //it's a function if not a variable
            }else if (!(symbol instanceof Variable)){
                Variable var = new Variable(node.children.get(0).name);
                scope.bind(var);
            }
                else{
                errors.addError(symbol.name + " is not a function nor class", symbol.name, node, scope);
            }
        //für Fälle wie a = 5 oder a.e = 5
        }else {
            String node_name = node.children.get(0).name;

            //checks if self is in the string
            if(node_name.contains(".")) {
                int index_point = node_name.indexOf(".");
                String instance_name = node_name.substring(0, index_point);
                if(instance_name.equals("self")){
                    node_name = node_name.substring(index_point+1);
                }
            }
            System.out.println(node_name);
            //für a.e = 5
            if(node_name.contains(".")) {
                int index_point = node_name.indexOf(".");
                String instance_name = node_name.substring(0, index_point);

                String[] member_names = splitMembers(node_name.substring(index_point + 1));
                //find a
                Symbol instance = scope.resolve(instance_name);
                if(instance == null){
                    errors.addError(instance_name + " doesn't exist", instance_name, node, scope);
                } else {
                    //instance.getType() gets the Scope of the Class
                    Scope classScope = (Scope) instance.getType();

                    if (classScope == null) {
                        errors.addError(member_names + " has no Scope", member_names[0], node, scope);
                    } else {
                        //find e (or all members after 'a.' that might follow
                        //if not all are found, addError
                        Symbol lastMember = classScope.resolve_members(member_names);
                        if (lastMember == null) {
                            errors.addError(member_names + " do not exist", member_names[0], node, scope);
                        } else if (!(lastMember instanceof Variable)) {
                            errors.addError(lastMember.name + " not a Variable that can be assigned to", member_names[member_names.length - 1], node, scope);
                        }
                    }
                }

            }
            //für a = 5
            else {
                Variable var = new Variable(node.children.get(0).name);
                scope.bind(var);
            }
        }

    }

    private void enter_statement_node(StatementBlock node){
        //we dont want the statement block, that lies between a class declaration and the statements, as a scope
        if(scope.getType() == null){
            scope = new Scope(scope);
        }
    }

    private String[] splitMembers(String members){
        String split[] = members.split("\\.", 0);
        return split;
    }

    //WIP
    private void enter_function_call_node(FunctionCall node) {
        String node_name = node.children.get(0).name;

        //checks if self is in the string
        if(node_name.contains(".")) {
            int index_point = node_name.indexOf(".");
            String instance_name = node_name.substring(0, index_point);
            if(instance_name.equals("self")){
                node_name = node_name.substring(index_point+1);
            }
        }
        //für Fälle wie a.b()
        if(node_name.contains(".")){
            int index_point = node_name.indexOf(".");
            String instance_name = node_name.substring(0, index_point);

            String[] member_names = splitMembers(node_name.substring(index_point+1));
            Symbol instance = scope.resolve(instance_name);


            if(instance == null){
                errors.addError(instance_name + " doesn't exist", instance_name, node, scope);
            } else {
                Scope classScope = (Scope)instance.getType();
                if(classScope == null){
                    errors.addError( member_names + " has no Scope", member_names[0], node, scope);
                }else {
                    Symbol lastMember = classScope.resolve_members(member_names);
                    if (lastMember == null) {
                        errors.addError(member_names + " do not exist", member_names[0], node, scope);
                    } else if (lastMember instanceof Variable) {
                        errors.addError(lastMember.name + " is not a function", lastMember.name, node, scope);
                    }
                }
            }
            //für Fälle wie a()
        } else {
            Symbol func = scope.resolve(node.children.get(0).name);
            if(func instanceof Variable) {
                errors.addError(func.name + " is not a function", func.name, node, scope);
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
        printTableOfScope();
        scope = scope.getEnclosingScope();
    }

    private void exit_class_definition_node(ClassDefinition node){
        printTableOfScope();
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

        if(scope.getType() == null){
            //printTableOfScope();
            scope =scope.getEnclosingScope();
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
        //a.e should not be checked
        if(!node.name.contains(".")){
            if(scope.resolve(node.name) == null){
                errors.addError("Could not find symbol: " + node.name, node.name, node, scope);
//            throw new Exception("Could not find symbol: " + node.name);
            }
        }

    }

    private void exit_string_node(StringNode node){

    }

    private void exit_boolean_node(BooleanNode node){

    }

    private void exit_zero_node(ZeroNode node){

    }

    private void printTableOfScope(){
        System.out.println("SCOOOOOPE");
        scope.print();
    }
}
