package e2;

// Clase para representar nodos de tormenta marina
class Maelstrom extends FixedPathNode {
    private final int stormStrength;

    public Maelstrom(String name, int stormStrength) {
        super(name);
        this.stormStrength = stormStrength;
    }

    public int getStormForce(){
        return stormStrength;
    }

    @Override
    public MapNode nextNode(Fleet fleet) {
        if (fleet.getLineOfSight() < getStormForce())
            fleet.takeDamage(10);  // Pierde 10 HP en la tormenta

        if (fleet.getHp() <= 0)
            return null;  // Flota destruida, termina la incursión
        else
            return getChild();  // Flota sobrevive y sigue la ruta izquierda
    }
}
