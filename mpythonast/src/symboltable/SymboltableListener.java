package symboltable;

import ast.*;

import java.util.Objects;

public class SymboltableListener {
    //current symboltable.Scope
    Scope scope;

    static ErrorHandler errors = new ErrorHandler();

    public Scope walk(Node node) {
        // walk through all the child nodes
        walk_node(node);

        // print the current(global) scope
        //scope.printChildren();

        // if there are errors print them
        if (!errors.isEmpty()) {
            for (SymboltableErr error : errors.getErrorList()) {
                System.err.println(error);
            }
            return null;
        }

        return scope;
    }

    public void walk_node(Node node) {
        // call the enter function for this node
        enter(node);
        // go through all the children
        for (Node child : node.children) {
            walk_node(child);
        }
        // call the exit function for this node
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

    /**
     * Deals with navigating e.g. a.b.c, and also checks for the usage of self
     * @param isAssignment if true the last member is created and bound to the second-to-last-member's scope
     * @param checkFunction if true it is checked if the last member is a function
     */
    private void navigateMembers(Node node, boolean isAssignment, boolean checkFunction) {
        String node_name = node.name;
        int index_point = node_name.indexOf(".");
        String instance_name = node_name.substring(0, index_point);
        Scope classScope = scope;
        String[] member_names = splitMembers(node_name.substring(index_point + 1));
        if (instance_name.equals("self")) {
            classScope = findNextClassScope();

        } else {
            Symbol instance = scope.resolve(instance_name);
            if (instance == null) {
                errors.addError(instance_name + " doesn't exist", instance_name, node, scope);
            } else {
                if (instance.getType() == null) {
                    errors.addError(memberArrayToString(member_names) + " has no symboltable.Scope", member_names[0], node, scope);
                } else {
                    classScope = (Scope) instance.getType();
                }
            }
        }

        Symbol lastMember = classScope.resolve_members(member_names);
        if (lastMember == null && !isAssignment) {
            errors.addError(memberArrayToString(member_names) + " does not exist", member_names[0], node, scope);
        }else if(isAssignment && lastMember == null){

            String[] memberList = new String[member_names.length-1];
            System.arraycopy(member_names, 0, memberList, 0, member_names.length - 1);
            if(memberList.length != 0) {
                Symbol bindingClass = classScope.resolve_members(memberList);
                if(bindingClass.getType() != null) {
                    ((Scope) bindingClass.getType()).bind(new Symbol(member_names[member_names.length - 1], bindingClass.getType()));
                }
                else{
                    errors.addError(memberList[memberList.length-1] + " is not a Class", memberList[0], node, scope);
                }
            }else{
                classScope.bind(new Symbol(member_names[member_names.length-1], classScope));
            }
        } else if(!isAssignment && checkFunction){
            if(lastMember instanceof Variable) {
                errors.addError(lastMember.name + " is not a function", lastMember.name, node, scope);
            }
        }
    }

    /**
     * ast.Program is always the first node in the AST. Sets up a global scope and binds all the built-ins
     */
    private void enter_program_node(Program node) {
        scope = new Scope();
        scope.setName("global");
        scope.bind(new BuiltIn("print"));
        //scope.bind(new symboltable.BuiltIn("self"));
    }

    /**
     * Binds the newly defined function to its scope and creates a new scope for the function that the parameters
     * will be bound to
     */
    private void enter_fuction_definiton_node(FunctionDefinition node) {
        //gets name of the function
        Function func = new Function(node.children.get(0).name);
        scope.bind(func);
        //inside the function body
        scope = new Scope(scope);
        scope.setName("function " + func.name);
    }

    /**
     * Binds the newly defined class to its scope. Creates a new scope for the class that can contain a parent scope if
     * the class is inheriting from another class
     */
    private void enter_class_definition_node(ClassDefinition node) {
        //find the parent
        Symbol parent = scope.resolve(node.children.get(1).name);
        //create the symboltable.Symbol of the Class
        Symbol classSymbol = new Symbol(node.children.get(0).name);
        //bind symboltable.Symbol of Class to symboltable.Scope
        scope.bind(classSymbol);
        //create the ClassScope, needs the parent symboltable.Scope, the classSymbol and the symboltable.Scope of the parent
        //in symboltable.Type is usually the Class (Class should be a type, symbol and scope),
        //but since there is no multiple inheritance, we need to store the symboltable.Scope in the type of the symboltable.Symbol
        Scope classScope;
        if (parent != null) {
            classScope = new Scope(scope, (Scope) parent.getType());
        } else {
            classScope = new Scope(scope);
        }
        //store scope in types
        classScope.setType(classScope);
        classScope.setName("class " + classSymbol.name);
        classSymbol.setType(classScope);
        scope = classScope;


    }

    /**
     * Binds parameters of the arguments to the function scope
     */
    private void enter_arglist_node(ArgList node) {
        for (Node child : node.children) {
            if (!Objects.equals(child.name, "arg_list")) {
                scope.bind(new Variable(child.name));
            }
        }
    }

    /**
     * Checks if symbols on both sides of the assignment exist. Firstly the right side is checked.
     * The classtype is the scope of the class that we instantiate.
     * After that the left side is checked, where the symbol is bound to its scope. If the symbol already exists in that
     * scope it doesn't get bound twice because the symbols are a HashMap
     */
    private void enter_assignment_node(AssignmentStatement node) {
        Type classType = null;
        // if the right side is a name of a symbol
        if(node.children.get(1)instanceof NameNode){
            // if there is a . in the name then we have to deal with instances and classes and stuff
            if(node.children.get(1).name.contains(".")){
                navigateMembers(node.children.get(1), false, false);
            }else{
                // here we just try to find the symbol
                Symbol symbol = scope.resolve(node.children.get(1).name);
                if(symbol == null){
                    errors.addError(node.children.get(1).name + " not found", node.children.get(1).name, node, scope);
                }
            }
        // if the right side is a function/constructor call
        }else if(node.children.get(1) instanceof FunctionCall){
            // if there is a . in the name then we have to deal with instances and classes and stuff
            if(node.children.get(1).name.contains(".")){
                navigateMembers(node.children.get(1), false, false);
            }else{
                // here we just try to find the symbol
                Symbol symbol = scope.resolve(node.children.get(1).children.get(0).name);
                // if we can't find the symbol we create an error
                if(symbol == null){
                    errors.addError(node.children.get(1).name + " not found", node.children.get(1).name, node, scope);
                }else{
                    // if we can find the symbol we want to save the type because it could be a class scope
                    classType = symbol.getType();
                }
            }
        }
        // now onto the left side of the assignment
        // if there is a . in the name then we have to deal with instances and classes and stuff
        if(node.children.get(0).name.contains(".")){
            navigateMembers(node.children.get(0), true, false);
        }else{
            // if the classtype is null we don't have a class instantiation, so it's a variable
            if(classType == null){
                Variable var = new Variable(node.children.get(0).name);
                scope.bind(var);
            }else {
                // here the classtype is not null so the right side of the assigment was a constructor call,
                // meaning that this symbol that we have to bind is an instance of that class
                Symbol var = new Symbol(node.children.get(0).name, classType);
                scope.bind(var);
            }
        }
    }

    /**
     * Creates a new scope for the statement block except when the current scope is a class, to not have to scopes under
     * a class and then the functions an attributes
     */
    private void enter_statement_node(StatementBlock node) {
        // only when the scope belongs to a class is the type not null
        if (scope.getType() == null) {
            scope = new Scope(scope);
            scope.setName("block");
        }
    }

    /**
     * Splits member names at the '.'
     * @param members the string that contains all the members, e.g. "a.b.c"
     * @return an array of all the members seperated, e.g. ["a", "b", "c"]
     */
    private String[] splitMembers(String members) {
        return members.split("\\.", 0);
    }

    private void enter_function_call_node(FunctionCall node) {
        String node_name = node.children.get(0).name;

        //für Fälle wie a.b()
        if (node_name.contains(".")) {
            navigateMembers(node.children.get(0), false, true);
        //für Fälle wie a()
        } else {
            Symbol func = scope.resolve(node.children.get(0).name);
            if (func instanceof Variable) {
                errors.addError(func.name + " is not a function", func.name, node, scope);
            }
        }
    }

    /**
     * Checks that the symbols on both sides of a binary operator, e.g. +, -, <, exist
     */
    private void enter_binary_operator_node(BinaryOperator node) {
        // check the left side first
        // only check at all if the node is a name node, and not a number or string
        // if there is a . in the name then we have to deal with instances and classes and stuff
        if(node.children.get(0) instanceof NameNode && node.children.get(0).name.contains(".")){
            navigateMembers(node.children.get(0), false, false);
        // else if without a . , just a simple symbol
        }else if(node.children.get(0) instanceof NameNode){
            if(scope.resolve(node.children.get(0).name) == null){
                errors.addError(node.children.get(0).name + " not found", node.children.get(0).name, node, scope);
            }
        }

        // same checks for the right side as for the left side
        if(node.children.get(1) instanceof NameNode && node.children.get(1).name.contains(".")){
            navigateMembers(node.children.get(1), false, false);
        }else if(node.children.get(1) instanceof NameNode){
            if(scope.resolve(node.children.get(1).name) == null){
                errors.addError(node.children.get(1).name + " not found", node.children.get(1).name, node, scope);
            }
        }

    }

    private void enter_return_node(ReturnStatement node) {

    }

    private void enter_while_node(WhileStatement node) {

    }

    private void enter_branch_node(BranchStatement node) {

    }

    private void enter_if_node(IfStatement node) {

    }

    private void enter_elif_node(ElifStatement node) {

    }

    private void enter_else_node(ElseStatement node) {

    }

    private void enter_not_node(NotNode node) {

    }

    private void enter_number_node(NumberNode node) {

    }

    private void enter_name_node(NameNode node) {

    }

    private void enter_string_node(StringNode node) {

    }

    private void enter_boolean_node(BooleanNode node) {

    }

    private void enter_zero_node(ZeroNode node) {

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

    /**
     * Go back to the scope above when the function definition is over
     */
    private void exit_fuction_definiton_node(FunctionDefinition node) {
        scope = scope.getEnclosingScope();
    }

    /**
     * Go back to the scope above when the class definition is over
     */
    private void exit_class_definition_node(ClassDefinition node) {
        scope = scope.getEnclosingScope();
    }

    /**
     * Goes back to the scope above except when the current scope is a class. We didn't create a new scope for a block
     * under a class, so we shouldn't go back to an enclosing scope
     */
    private void exit_statement_node(StatementBlock node) {
        if (scope.getType() == null) {
            //printTableOfScope();
            scope = scope.getEnclosingScope();
        }
    }

    private String memberArrayToString(String[] members){
        StringBuilder output = new StringBuilder();
        for(String member: members){
            output.append(member).append(".");
        }
        output.deleteCharAt(output.length()-1);
        return output.toString();
    }


    /**
     * Finds an enclosing scope belonging to a class if such a scope exists, if not the current scope is returned
     * @return a scope, eiter the class or the current scope
     */
    private Scope findNextClassScope() {
        Scope currentScope = scope;
        while (currentScope != null && currentScope.getType() == null) {
            currentScope = currentScope.getEnclosingScope();
        }
        if (currentScope == null) {
            return scope;
        }
        return currentScope;
    }

    /**
     * Checks if the name that we want to access exists
     */
    private void exit_name_node(NameNode node) {
        if (node.name.contains(".")) {
            navigateMembers(node, false, false);
        } else {
            if (scope.resolve(node.name) == null) {
                errors.addError("Could not find symbol: " + node.name, node.name, node, scope);
            }
        }
    }

    private void exit_arglist_node(ArgList node) {

    }

    private void exit_program_node(Program node) {

    }

    private void exit_return_node(ReturnStatement node) {

    }

    private void exit_while_node(WhileStatement node) {

    }

    private void exit_branch_node(BranchStatement node) {

    }

    private void exit_if_node(IfStatement node) {

    }

    private void exit_elif_node(ElifStatement node) {

    }

    private void exit_else_node(ElseStatement node) {

    }

    private void exit_assignment_node(AssignmentStatement node) {

    }

    private void exit_function_call_node(FunctionCall node) {

    }

    private void exit_binary_operator_node(BinaryOperator node) {

    }

    private void exit_not_node(NotNode node) {

    }

    private void exit_number_node(NumberNode node) {

    }


    private void exit_string_node(StringNode node) {

    }

    private void exit_boolean_node(BooleanNode node) {

    }

    private void exit_zero_node(ZeroNode node) {

    }
}
