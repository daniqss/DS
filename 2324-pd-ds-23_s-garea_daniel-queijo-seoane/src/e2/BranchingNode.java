package e2;

abstract class BranchingNode extends MapNode {
    private MapNode leftChild;
    private MapNode rightChild;

    public BranchingNode(String nodeName) {
        super(nodeName);
    }

    public MapNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MapNode leftChild) {
        this.leftChild = leftChild;
    }

    public MapNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(MapNode rightChild) {
        this.rightChild = rightChild;
    }
}
