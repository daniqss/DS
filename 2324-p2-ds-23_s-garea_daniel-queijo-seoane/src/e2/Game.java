package e2;

public class Game {
    private int turn;
    Character p0;
    Character p1;

    public Game(Character p0, Character p1) {
        turn = 0;
        this.p0 = p0;
        this.p1 = p1;
    }

    public int getTurn() { return turn; }
    private void advanceTurn() { turn++; }

    public int eachTurn(Character attacking, Character defending) {
        int damage;
        damage = attacking.attack(defending);
        System.out.println("Atacante hace " + damage + " a el defensor!\n");
        if (p1.getVida() > 0) System.out.println("Defensor tiene " + defending.getVida() + " de vida!\n");
        else System.out.println("Defensor ha muerto!\n");
        return damage;
    }

    public Character normalBattle(int maxTurns) {
        while (p0.getVida() > 0 && p1.getVida() > 0 && getTurn() < maxTurns) {
            if (turn % 2 == 0) {
                eachTurn(p0, p1);
            } else {
                eachTurn(p1, p0);
            }
            advanceTurn();
        }
        if (p0.getVida()>0 && p1.getVida()>0) { return null; }
        else if (p0.getVida() > p1.getVida()) { return p0; }
        else { return p1; }
    }

}
