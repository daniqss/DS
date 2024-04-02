package e2;

public class Fleet {
    private int hp;
    private final int armor;
    private final int firePower;
    private final int antiAir;
    private final int lineOfSight;

    public Fleet(int hp, int armor, int firePower, int antiAir, int lineOfSight) {
        this.hp = hp;
        this.armor = armor;
        this.firePower = firePower;
        this.antiAir = antiAir;
        this.lineOfSight = lineOfSight;
    }

    public int getHp() {
        return hp;
    }

    public int getArmor() {
        return armor;
    }

    public int getFirePower() {
        return firePower;
    }

    public int getAntiAir() {
        return antiAir;
    }

    public int getLineOfSight() {
        return lineOfSight;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    @Override
    public String toString() {
        return "HP: " + hp + ", Armor: " + armor + ", Firepower: " + firePower + ", AntiAir: " + antiAir + ", LineOfSight: " + lineOfSight;
    }
}