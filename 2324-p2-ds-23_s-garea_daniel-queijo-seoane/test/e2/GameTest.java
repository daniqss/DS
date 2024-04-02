package e2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testCharacterCreation(){
        Wand wand = new Wand();
        List<AttackMethods> attackObjListAttacker = new ArrayList<>();
        attackObjListAttacker.add(wand);
        List<DefenseMethods> defenseObjListAttacker = new ArrayList<>();
        defenseObjListAttacker.add(new Wand());

        Character player1 = new Warrior(10, 8, 10, attackObjListAttacker, defenseObjListAttacker);

        assertNotNull(player1);
        assertEquals("Wand", wand.getCodeName());
        assertEquals(10, player1.getVida());
        assertEquals(8, player1.getStrength());
        assertEquals(10, player1.getMana());

        Character player2 = new Warrior();
        assertEquals(10, player2.getVida());
        assertEquals(10, player2.getStrength());
        assertEquals(20, player2.getMana());
        Character player3 = new Wizard();

    }

    @Test
    public void testAttack() {
        List<AttackMethods> attackListAttacker = new ArrayList<>();
        attackListAttacker.add(new Wand());
        List<DefenseMethods> defenseListAttacker = new ArrayList<>();
        defenseListAttacker.add(new Wand());
        //wand damage=4
        //wand damage en el primer turno=4*2=8
        //wand defense=2
        //vida+defensa-daño=10+2-8=4

        Character attacker = new Warrior(10, 8, 10, attackListAttacker, defenseListAttacker);

        List<AttackMethods> attackListDefender = new ArrayList<>();
        attackListDefender.add(new Wand());
        List<DefenseMethods> defenseListDefender = new ArrayList<>();
        defenseListDefender.add(new Wand());

        Character defender = new Warrior(10, 8, 10, attackListDefender, defenseListDefender);

        attacker.attack(defender);

        assertEquals(4,defender.getVida());
    }

    @Test
    public void testCharacterDeath() {
        List<AttackMethods> attackListAttacker = new ArrayList<>();
        attackListAttacker.add(new Sword());
        List<DefenseMethods> defenseListAttacker = new ArrayList<>();
        defenseListAttacker.add(new Wand());
        //sword damage=15
        //wand defense=2

        Character attacker = new Wizard(10, 8, 10, attackListAttacker, defenseListAttacker);

        List<AttackMethods> attackListDefender = new ArrayList<>();
        attackListDefender.add(new Sword());
        List<DefenseMethods> defenseListDefender = new ArrayList<>();
        defenseListDefender.add(new Armor());
        //Sword damage=15
        //Armor defense=4

        Character defender = new Warrior(10, 8, 10, attackListDefender, defenseListDefender);

        attacker.attack(defender);
        assertEquals(0, defender.getVida());
    }

    @Test
    public void testGameResult() {
        List<AttackMethods> attackListAttacker = new ArrayList<>();
        attackListAttacker.add(new Sword());
        List<DefenseMethods> defenseListAttacker = new ArrayList<>();
        defenseListAttacker.add(new Armor());
        Character player2 = new Warrior(10, 8, 10, attackListAttacker, defenseListAttacker);

        List<AttackMethods> attackListDefender = new ArrayList<>();
        attackListDefender.add(new FireBallSpell());
        List<DefenseMethods> defenseListDefender = new ArrayList<>();
        defenseListDefender.add(new Sword());
        Character player1 = new Wizard(10, 8, 10, attackListDefender, defenseListDefender);

        Game game = new Game(player1, player2);
        Character winner = game.normalBattle(20);

        assertNotNull(winner);
        assertSame(winner, player2);
    }
}
