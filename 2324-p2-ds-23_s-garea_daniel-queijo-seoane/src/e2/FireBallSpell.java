package e2;

public class FireBallSpell extends Objects implements AttackMethods {
    int USES = 8;

    AttackObjects attackObjects;

    public FireBallSpell() {
        super( "FireBallSpell");
        attackObjects = new AttackObjects(10, USES, 5);
    }

    public void reduceUses() { attackObjects.reduceUses(); }
    public int getMinMana() { return attackObjects.getMinMana(); }
    public int getUses() { return attackObjects.getUses(); }
    public int getDamage() {
        if (getUses() == 1) {
            return attackObjects.getDamage() - 1;
        } else {
            return attackObjects.getDamage();
        }
    }

}
