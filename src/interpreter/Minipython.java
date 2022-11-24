package interpreter;

import antlr.minipythonLexer;
import antlr.minipythonParser;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Minipython {
    private static final Interpreter interpreter = new Interpreter();
    
    public static void main(String[] args) throws Exception {
        // create interpreter
        minipythonLexer lexer = new minipythonLexer(CharStreams.fromFileName("program.txt"));

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        minipythonParser parser = new minipythonParser(tokens);

        ParseTree cst = parser.program(); // begin parsing at init rule
        System.out.println(cst.toStringTree(parser)); // print LISP-style tree


        interpreter.VistorCST visitorCST = new interpreter.VistorCST();
        // create AST
        visitorCST.visit(cst);
        List<Stmt> stmts = visitorCST.statements;

        // visitor to print AST
        interpreter.AstPrinter astVisitorPrinter = new interpreter.AstPrinter();
        // print statements of the program
        for (Stmt stmt : stmts) {
            System.out.println(astVisitorPrinter.print(stmt));
        }
        // create Resolver
        Symboltable symboltable = new Symboltable(interpreter, true);
        // resolve AST / create symbol table
        symboltable.resolve(stmts);
        symboltable.printGlobalTable();

        // run interpreter
        interpreter.interpret(stmts);


//        JFrame frame = new JFrame("Antlr CST");
//        JPanel panel = new JPanel();
//        TreeViewer viewer = new TreeViewer(Arrays.asList(
//                parser.getRuleNames()),cst);
//        viewer.setScale(1.5); // Scale a little
//        panel.add(viewer);
//        frame.add(panel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);

    }

    static void error(int line, String message) {
        System.err.println("[line " + line + "] Error " + ": " + message);
    }

    private static void report(int line, int charPositionInLine, String where, String message) {
        System.err.println("[line " + line + ":" + charPositionInLine + "] Error" + where + ": " + message);
    }
    static void error(Symbol symbol, String message) {
        if (symbol.type == SymbolType.EOF) {
            report(symbol.line, symbol.charPositionInLine, " at end", message);
        } else {
            report(symbol.line, symbol.charPositionInLine, " at '" + symbol.lexeme + "'", message);
        }
    }

    static void runtimeError(RuntimeError error) {
        System.err.println(error.getMessage() + "\n[line " + error.symbol.line + "]");
    }
}
