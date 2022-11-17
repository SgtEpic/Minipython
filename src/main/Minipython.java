package main;

import ast.AstVisitorPrinter;
import ast.Node;
import ast.Visitor;
import interpreter.EnvironmentBuilder;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import symboltable.Scope;
import symboltable.SymboltableListener;

import javax.swing.*;
import java.util.Arrays;

public class Minipython {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        minipythonLexer lexer = new minipythonLexer(CharStreams.fromFileName("program.txt"));

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        minipythonParser parser = new minipythonParser(tokens);

        ParseTree cst = parser.program(); // begin parsing at init rule

        //ParseTreeWalker walker = new ParseTreeWalker();
        //ast.Listener listener = new ast.Listener();
        //walker.walk(listener, tree);

        Visitor visitor = new Visitor();
        Node ast = visitor.visit(cst);
        AstVisitorPrinter astVisitorPrinter = new AstVisitorPrinter();
        astVisitorPrinter.visit(ast);

        Scope symbolTable;
        SymboltableListener listener = new SymboltableListener();
        symbolTable = listener.walk(ast);
        if(symbolTable == null) {
            return;
        }

        EnvironmentBuilder environmentBuilder = new EnvironmentBuilder(symbolTable);
        environmentBuilder.build().printChildren();

        System.out.println(cst.toStringTree(parser)); // print LISP-style tree

      /*  JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewer = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),ast);
        viewer.setScale(1.5); // Scale a little
        panel.add(viewer);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);*/



        // Create a parser
        //Parser parser = new Parser();
        // Parse the input
        // parser.parse(new InputStreamReader(System.in));
        // Get the AST
        // ast.Node ast = parser.getAST();
        // Create an interpreter
        // Interpreter interpreter = new Interpreter();
        // Interpret the AST
        // interpreter.interpret(ast);
    }
}
