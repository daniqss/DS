package e2;

public class Armor extends Objects implements DefenseMethods {

    DefenseObjects defenseObjects;

    public Armor() {
        super("Armor");
        defenseObjects = new DefenseObjects(4, 5);
    }

    public int getDefense() { return defenseObjects.defense(); }
    public int getMinStregth() { return defenseObjects.minStregth(); }

}
