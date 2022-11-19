package ast;

import org.antlr.v4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Node implements Tree {

    public final String name;
    public final Position position;
    public List<Node> children = new ArrayList<>();
    public Node(Position position, String name) {
        this.name = name;
        this.position = position;
    }

    public Node parent;

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public Object getPayload() {
        return name;
    }

    @Override
    public Tree getChild(int i) {
        return children.get(i);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public String toStringTree() {
        return null;
    }
}
