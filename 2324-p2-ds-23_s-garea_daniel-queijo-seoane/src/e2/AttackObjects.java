package e2;

public class AttackObjects {
    final int damage;
    int uses;
    final int minMana;

    public AttackObjects(int damage, int uses, int minMana) {
        this.damage = damage;
        this.uses = uses;
        this.minMana = minMana;
    }

    public void reduceUses() { uses--; }
    public int getDamage() { return damage; }
    public int getUses() { return uses; }
    public int getMinMana() { return minMana; }

}
