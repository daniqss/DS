package e2;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapNodeTest {

    @Test
    public void testAirRaid() {
        Fleet fleet = new Fleet(100, 20, 30, 10, 50);
        AirRaid airRaid = new AirRaid("AirRaidNode", 40);

        MapNode NextNode = new AirRaid("NextNode", 30);
        airRaid.setChild(NextNode);

        MapNode nextNode = airRaid.nextNode(fleet);

        assertNotNull(nextNode);
        assertTrue(nextNode instanceof FixedPathNode);
        assertEquals("NextNode", nextNode.getNodeName());
    }

    @Test
    public void testMaelstrom() {
        Fleet fleet = new Fleet(100, 20, 30, 10, 50);
        Maelstrom maelstrom = new Maelstrom("MaelstromNode", 25);

        MapNode NextNode = new Maelstrom("NextNode", 20);
        maelstrom.setChild(NextNode);

        MapNode nextNode = maelstrom.nextNode(fleet);

        assertNotNull(nextNode);
        assertTrue(nextNode instanceof FixedPathNode);
        assertEquals("NextNode", nextNode.getNodeName());
    }

    @Test
    public void testBattle() {
        Fleet fleet = new Fleet(100, 20, 30, 10, 50);
        Fleet fleet2 = new Fleet(0, 0, 0, 0, 00);
        Battle battle = new Battle("BattleNode", 150, 25, 40);

        Battle leftNode = new Battle("LeftNode", 120, 20, 35);
        Battle rightNode = new Battle("RightNode", 100, 30, 45);

        battle.setLeftChild(leftNode);
        battle.setRightChild(rightNode);

        MapNode nextNode = battle.nextNode(fleet);
        MapNode nextNode2 = battle.nextNode(fleet2);

        assertNotNull(nextNode);
        assertTrue(nextNode instanceof BranchingNode);
        assertEquals("RightNode", nextNode.getNodeName());

    }

    @Test
    public void testWaypointSpotting() {
        Fleet fleet = new Fleet(100, 20, 30, 10, 50);
        WaypointSpotting waypointSpotting = new WaypointSpotting("WaypointSpottingNode", 15);

        MapNode leftNode = new WaypointSpotting("LeftNode", 10);
        MapNode rightNode = new WaypointSpotting("RightNode", 20);

        waypointSpotting.setLeftChild(leftNode);
        waypointSpotting.setRightChild(rightNode);

        MapNode nextNode = waypointSpotting.nextNode(fleet);

        assertNotNull(nextNode);
        assertTrue(nextNode instanceof BranchingNode);
        assertEquals("LeftNode", nextNode.getNodeName());
    }

}
