package e2;

public abstract class MapNode {
    protected String name;

    public MapNode(String nodeName) {
        this.name = nodeName;
    }

    public String getNodeName() {
        return name;
    }

    public abstract MapNode nextNode(Fleet fleet);
}


