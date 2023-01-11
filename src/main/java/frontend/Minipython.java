package frontend;

import CBuilder.ProgramBuilder;
import antlr.*;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.nio.file.Path;
import java.util.Arrays;

public class Minipython {

    public static void main(String[] args) throws Exception {
        // create interpreter
        minipythonLexer list_lexer = new minipythonLexer(CharStreams.fromFileName("stdlib/list.mpy"));
        minipythonLexer lexer = new minipythonLexer(CharStreams.fromFileName("program.mpy"));

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream list_tokens = new CommonTokenStream(list_lexer);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        minipythonParser list_parser = new minipythonParser(list_tokens);
        minipythonParser parser = new minipythonParser(tokens);

        ParseTree list_cst = list_parser.program();
        ParseTree cst = parser.program(); // begin parsing at init rule
        System.out.println(cst.toStringTree(parser)); // print LISP-style tree

        VistorCST list_visitorCST = new VistorCST();
        VistorCST visitorCST = new VistorCST();

        // create AST
        Stmt.Program list_ast = (Stmt.Program) list_visitorCST.visit(list_cst);
        Stmt.Program ast = (Stmt.Program) visitorCST.visit(cst);
        // combine list ast and program ast
        ast.statements.addAll(0, list_ast.statements);

        // visitor to print AST
        AstPrinter astVisitorPrinter = new AstPrinter();
        // print statements of the program
        System.out.println(astVisitorPrinter.print(ast));

        // create Resolver
        Symboltable symboltable = new Symboltable(true);
        // resolve AST / create symbol table
        symboltable.resolveAST(ast);
        symboltable.printGlobalTable();

        // run interpreter
        //interpreter.interpret(stmts);

        ProgramBuilder builder = new ProgramBuilder();
        Path fileOutput = java.nio.file.FileSystems.getDefault().getPath("compilerOutput");
        IntermediateCode code = new IntermediateCode(builder, fileOutput);
        code.generateProgram(ast);


        //        JFrame frame = new JFrame("Antlr CST");
//        JPanel panel = new JPanel();
//        TreeViewer viewer = new TreeViewer(Arrays.asList(
//            parser.getRuleNames()),cst);
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
