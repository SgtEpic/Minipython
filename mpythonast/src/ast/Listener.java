package ast;

import main.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class Listener extends minipythonBaseListener {

    List<Node> root = new ArrayList<Node>();
    Stack<ParseTree> stack = new Stack<ParseTree>();

    public void enterStmtsLabel(minipythonParser.StmtsLabelContext ctx) {
        System.out.println("Start " + ctx.getText());
    }
    public void exitStmtsLabel(minipythonParser.StmtsLabelContext ctx) {
        System.out.println(stack.toString());
    }

    public void enterAssign_stmt(minipythonParser.Assign_stmtContext ctx) {
    }

    public void exitAssign_stmtLabel(minipythonParser.Assign_stmtLabelContext ctx) {
        System.out.println(stack.toString());
    }

    public void exitNumberLabel(minipythonParser.NumberLabelContext ctx) {
        stack.push(ctx.INTEGER());
    }

    public void exitNameLabel(minipythonParser.NameLabelContext ctx) {
        stack.push(ctx.NAME());
    }
}
