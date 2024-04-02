package e2;

class AirRaid extends FixedPathNode {
    private final int enemyAirPower;

    public AirRaid(String name, int enemyAirPower) {
        super(name);
        this.enemyAirPower = enemyAirPower;
    }

    public int getEnemyAirPower() {
        return enemyAirPower;
    }

    private int calculateAerialAttackDamage(Fleet fleet) {
        int enemyAirPower = getEnemyAirPower();

        int damage = enemyAirPower - (2 * fleet.getAntiAir() + fleet.getArmor());
        return Math.max(0, damage);  // No podemos tener un daño negativo.
    }

    @Override
    public MapNode nextNode(Fleet fleet) {
        int damage = calculateAerialAttackDamage(fleet);
        fleet.takeDamage(damage);

        if (fleet.getHp() <= 0)
            return null;
        else
            return getChild();
    }
}

