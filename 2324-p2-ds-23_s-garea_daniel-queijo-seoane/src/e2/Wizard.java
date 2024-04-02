package e2;

import java.util.List;

public class Wizard extends Character{
    public Wizard(int vida, int strength, int mana, List<AttackMethods> attackObjList, List<DefenseMethods> defenseObjList) {
        super(vida, strength, mana, attackObjList, defenseObjList);
    }

    public Wizard() { super(); }
}
