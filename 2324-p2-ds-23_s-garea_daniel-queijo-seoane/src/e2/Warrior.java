package e2;

import java.util.List;


public class Warrior extends Character {

    public Warrior(int vida, int strength, int mana, List<AttackMethods> attackObjList, List<DefenseMethods> defenseObjList) {
        super(vida, strength, mana, attackObjList, defenseObjList);
    }

    public Warrior() { super(); }
}

