package e2;

import static org.junit.Assert.*;

import org.junit.Test;

public class NavalRaidsGameTest {
    private MapNode createMap() {
        WaypointSpotting NodeA = new WaypointSpotting("A", 28);
        Battle NodeB = new Battle("B", 20, 30, 25);
        Maelstrom NodeC = new Maelstrom("C", 20);
        End NodeD = new End("D");
        AirRaid NodeE = new AirRaid("E", 151);
        Battle NodeF = new Battle("F", 30, 17, 41);
        Maelstrom NodeG = new Maelstrom("G", 67);
        End NodeH = new End("H");
        End NodeI = new End("I");
        End NodeK = new End("K");

        NodeA.setLeftChild(NodeB);
        NodeA.setRightChild(NodeC);

        NodeB.setLeftChild(NodeD);
        NodeB.setRightChild(NodeE);

        NodeC.setChild(NodeF);

        NodeE.setChild(NodeK);

        NodeF.setLeftChild(NodeH);
        NodeF.setRightChild(NodeG);

        NodeG.setChild(NodeI);

        return NodeA;
    }

    @Test
    public void testGameWithFleetA() {
        Fleet fleet = new Fleet(11, 42, 47, 0, 0);
        MapNode startNode = createMap();
        navalRaidsGame.game(fleet, startNode);
        assertEquals(1, fleet.getHp());
    }

    @Test
    public void testGameWithFleetB() {
        Fleet fleet = new Fleet(1, 25, 0, 46, 28);
        MapNode startNode = createMap();
        navalRaidsGame.game(fleet, startNode);
        assertEquals(-33, fleet.getHp());
    }
    @Test
    public void testGameWithFleetC() {
        Fleet fleet = new Fleet(999, 15, 25, 5, 30);
        MapNode startNode = createMap();
        navalRaidsGame.game(fleet, startNode);
        assertTrue(fleet.getHp() > 0);
    }
    @Test
    public void testGameWithFleetD() {
        Fleet fleet = new Fleet(0, 0, 0, 0, 28);
        MapNode startNode = createMap();
        navalRaidsGame.game(fleet, startNode);
        assertTrue(fleet.getHp() <= 0);
    }
    @Test
    public void testGameWithFleetE() {
        Fleet fleet = new Fleet(10, 0, 0, 0, 0);
        MapNode startNode = createMap();
        navalRaidsGame.game(fleet, startNode);
        assertTrue(fleet.getHp() <= 0);
    }


    @Test
    public void testMapStructure() {
        MapNode startNode = createMap();
        assertEquals("A", startNode.getNodeName());
        assertTrue(startNode instanceof WaypointSpotting);
        assertNotNull(((WaypointSpotting) startNode).getLeftChild());
        assertNotNull(((WaypointSpotting) startNode).getRightChild());
    }

    @Test
    public void testMinimumNodeCountToDestruction() {
        MapNode startNode = createMap();
        int minNodeCount = navalRaidsGame.getSmallestNumberRout(startNode);
        assertEquals(3, minNodeCount);
    }

    @Test
    public void testInitialFleetAttributes() {
        Fleet fleet = new Fleet(50, 20, 30, 10, 50);
        assertEquals(50, fleet.getHp());
        assertEquals(20, fleet.getArmor());
        assertEquals(30, fleet.getFirePower());
        assertEquals(10, fleet.getAntiAir());
        assertEquals(50, fleet.getLineOfSight());
    }

    @Test
    public void testGameWithEmptyFleet() {
        Fleet emptyFleet = new Fleet(0, 0, 0, 0, 0);
        MapNode startNode = createMap();
        navalRaidsGame.game(emptyFleet, startNode);
        assertEquals(0, emptyFleet.getHp());
    }

    @Test
    public void testGameWithHighFirepowerFleet() {
        Fleet highFirepowerFleet = new Fleet(50, 10, 100, 20, 40);
        MapNode startNode = createMap();
        navalRaidsGame.game(highFirepowerFleet, startNode);
        assertTrue(highFirepowerFleet.getHp() > 0);
    }

    @Test
    public void testGameWithLowLineOfSightFleet() {
        Fleet lowLineOfSightFleet = new Fleet(50, 20, 30, 10, 5);
        MapNode startNode = createMap();
        navalRaidsGame.game(lowLineOfSightFleet, startNode);
        assertTrue(lowLineOfSightFleet.getHp() > 0);
    }
}
