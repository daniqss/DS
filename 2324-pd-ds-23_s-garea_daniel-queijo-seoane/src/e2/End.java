package e2;

class End extends MapNode {

    public End(String nodeName) {
        super(nodeName);
    }
    @Override
    public MapNode nextNode(Fleet fleet) {
        return null;
    }
}

