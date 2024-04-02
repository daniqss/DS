package e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FleetTest {

    @Test
    void testInitialization() {
        Fleet fleet = new Fleet(100, 50, 30, 20, 10);

        assertEquals(100, fleet.getHp());
        assertEquals(50, fleet.getArmor());
        assertEquals(30, fleet.getFirePower());
        assertEquals(20, fleet.getAntiAir());
        assertEquals(10, fleet.getLineOfSight());
    }

    @Test
    void testTakeDamage() {
        Fleet fleet = new Fleet(100, 50, 30, 20, 10);

        assertEquals(100, fleet.getHp());

        fleet.takeDamage(20);
        assertEquals(80, fleet.getHp());

        fleet.takeDamage(30);
        assertEquals(50, fleet.getHp());

        fleet.takeDamage(50);
        assertEquals(0, fleet.getHp());
    }

    @Test
    void testToString() {
        Fleet fleet = new Fleet(100, 50, 30, 20, 10);

        assertEquals("HP: 100, Armor: 50, Firepower: 30, AntiAir: 20, LineOfSight: 10", fleet.toString());
    }

}
