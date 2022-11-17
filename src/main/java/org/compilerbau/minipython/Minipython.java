/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
// import ANTLR's runtime libraries
package org.compilerbau.minipython;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Minipython {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        //main.minipythonLexer lexer = new main.minipythonLexer(CharStreams.fromStream(System.in));
        minipythonLexer lexer = new minipythonLexer(CharStreams.fromFileName("program.txt"));

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        minipythonParser parser = new minipythonParser(tokens);

        ParseTree tree = parser.program(); // begin parsing at init rule

        ParseTreeWalker walker = new ParseTreeWalker();

        Listener listener = new Listener();

        walker.walk(listener,tree);

        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    }
}
