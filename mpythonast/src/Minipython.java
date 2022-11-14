import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;

public class Minipython {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        System.out.println("nonono");
        minipythonLexer lexer = new minipythonLexer(CharStreams.fromFileName("program.txt"));

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        minipythonParser parser = new minipythonParser(tokens);

        ParseTree cst = parser.program(); // begin parsing at init rule

        //ParseTreeWalker walker = new ParseTreeWalker();
        //Listener listener = new Listener();
        //walker.walk(listener, tree);

        Visitor visitor = new Visitor();
        Node ast = visitor.visit(cst);
        AstVisitorPrinter astVisitorPrinter = new AstVisitorPrinter();
        astVisitorPrinter.visit(ast);

        SymboltableListener listener = new SymboltableListener();
        listener.walk(ast);

        System.out.println(cst.toStringTree(parser)); // print LISP-style tree



        // Create a parser
        //Parser parser = new Parser();
        // Parse the input
        // parser.parse(new InputStreamReader(System.in));
        // Get the AST
        // Node ast = parser.getAST();
        // Create an interpreter
        // Interpreter interpreter = new Interpreter();
        // Interpret the AST
        // interpreter.interpret(ast);
    }
}
