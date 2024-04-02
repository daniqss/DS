package e2;


import java.util.List;

public abstract class  Character {
    private int vida;
    final private int strength;
    final private int mana;
    private List<AttackMethods> attackObjList;
    private final List<DefenseMethods> defenseObjList;


    public Character() {
        vida = 10;
        strength = 10;
        mana = 20;

        attackObjList = null;
        defenseObjList = null;
    }

    public Character(int vida, int strength, int mana, List<AttackMethods> attackObjList, List<DefenseMethods> defenseObjList) {

        if (vida >= 1 && vida <=10 ) {
            this.vida = vida;
        }
        else
            throw new IllegalArgumentException();
        if (strength >= 1 && strength <=10 ) {
            this.strength = strength;
        }
        else
            throw new IllegalArgumentException();
        if (mana >= 0 && mana <=10 ) {
            this.mana = mana;
        }
        else
            throw new IllegalArgumentException();

        if (attackObjList != null && defenseObjList != null) {
            if (attackObjList.isEmpty() || attackObjList.size() > 5)
                throw new IllegalArgumentException("Lista de objetos de ataque no valida");
            if (defenseObjList.isEmpty() || defenseObjList.size() > 5)
                throw new IllegalArgumentException("Lista de objetos de defensa no valida");
            this.attackObjList = attackObjList;
            this.defenseObjList = defenseObjList;
        }
        else
            throw new IllegalArgumentException();
    }

    public int getVida() { return vida; }
    public int getStrength()  { return strength; }
    public int getMana() { return mana; }

    public void reduceVida (int damage) {
        int defense = getTotalDefense();
        int aux = defense - damage;

        if (aux < 0) {
            vida = vida + aux;
            if(vida<0){vida=0;}
        }
        else {
            System.out.println("El ataque no ha hecho daño");
        }
    }

    public List<AttackMethods> getAttackObjects() {
        return attackObjList;
    }
    public List<DefenseMethods> getDefenseObjects() {
        return defenseObjList;
    }

    public int getTotalDefense() {
        int defense = 0;

        for (DefenseMethods obj : defenseObjList) {
            if (obj.getMinStregth() <= getStrength()) {
                defense += obj.getDefense();
            }
        }
        return defense;
    }

    public void checkUses() {
        attackObjList.removeIf(obj -> obj.getUses() == 0);
    }

    public int attack(Character defendingCharacter) {
        int damage = getAttackObjects().get(0).getDamage();
        attackObjList.get(0).reduceUses();

        defendingCharacter.reduceVida(damage);
        checkUses();
        return damage;
    }

}

