package e2;

class WaypointSpotting extends BranchingNode {
    private final int distance;

    public WaypointSpotting(String name, int distance) {
        super(name);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public MapNode nextNode(Fleet fleet) {
        if (fleet.getLineOfSight() >= getDistance())
            return getLeftChild();
         else
            return getRightChild();
    }

}

