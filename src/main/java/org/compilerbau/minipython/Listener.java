package org.compilerbau.minipython;

public class Listener extends minipythonBaseListener{
    @Override public void enterStmtsLabel(minipythonParser.StmtsLabelContext ctx) {
        System.out.println("test");
    }
}
