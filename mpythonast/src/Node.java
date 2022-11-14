import java.util.ArrayList;
import java.util.List;

public class Node {

    public final String name;
    public final Position position;
    public List<Node> children = new ArrayList<>();
    public Node(Position position, String name) {
        this.name = name;
        this.position = position;
    }

}
