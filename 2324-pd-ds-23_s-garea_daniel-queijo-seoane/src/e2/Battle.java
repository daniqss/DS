package e2;

class Battle extends BranchingNode {
    private final Fleet enemyFleet;

    public Battle(String name, int enemyHp, int enemyArmor, int enemyFirepower) {
        super(name);
        this.enemyFleet = new Fleet(enemyHp, enemyArmor, enemyFirepower, 0, 0);
    }

    private int calculateFleetAttackDamage(Fleet fleet) {
        int damage = fleet.getFirePower() - enemyFleet.getArmor();
        return Math.max(0, damage);
    }

    private int calculateEnemyAttackDamage(Fleet fleet) {
        int damage = enemyFleet.getFirePower() - fleet.getArmor();
        return Math.max(0, damage);
    }

    public MapNode nextNode(Fleet fleet) {
        int enemyDamage = calculateEnemyAttackDamage(fleet);
        fleet.takeDamage(enemyDamage);

        int fleetDamage = calculateFleetAttackDamage(fleet);
        enemyFleet.takeDamage(fleetDamage);

        if (fleet.getHp() <= 0)
            return null;
        else
            return (enemyFleet.getHp() <= 0) ? getLeftChild() : getRightChild();
    }
}

