package e2;

abstract class FixedPathNode extends MapNode {
    private MapNode child;
    public FixedPathNode(String nodeName) {
        super(nodeName);
    }

    public MapNode getChild(){
        return child;
    }

    public void setChild(MapNode child) {
        this.child = child;
    }
}
