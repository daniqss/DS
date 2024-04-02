package e2;

public class Sword extends Objects implements AttackMethods, DefenseMethods {
    AttackObjects attackObjects;
    DefenseObjects defenseObjects;
    int USES = 8;

    public Sword() {
        super("Sword");
        defenseObjects = new DefenseObjects(3, 5);
        attackObjects = new AttackObjects(15, USES, 5);
    }

    public void reduceUses() { attackObjects.reduceUses(); }
    public int getDefense() { return defenseObjects.defense(); }
    public int getMinStregth() { return defenseObjects.minStregth(); }
    public int getMinMana() { return attackObjects.getMinMana(); }
    public int getUses() { return attackObjects.getUses(); }
    public int getDamage() { return attackObjects.getDamage(); }

}
