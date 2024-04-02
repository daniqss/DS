package e2;

public class Wand extends Objects implements AttackMethods, DefenseMethods {
    int USES = 8;

    AttackObjects attackObjects;
    DefenseObjects defenseObjects;

    public Wand() {
        super("Wand");
        defenseObjects = new DefenseObjects(2, 5);
        attackObjects = new AttackObjects(4, USES, 5);
    }

    public int getDefense() { return defenseObjects.defense(); }
    public int getMinStregth() { return defenseObjects.minStregth(); }
    public void reduceUses() { attackObjects.reduceUses(); }
    public int getMinMana() { return attackObjects.getMinMana(); }
    public int getUses() { return attackObjects.getUses(); }
    public int getDamage() {
        int damage = attackObjects.getDamage();
        if (getUses() == USES) {
            return damage * 2;
        }
        else {
            return damage;
        }
    }

}
