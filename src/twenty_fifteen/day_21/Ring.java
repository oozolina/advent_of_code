package twenty_fifteen.day_21;

public enum Ring {
    DAMAGE_1(25, 1, 0),
    DAMAGE_2(50, 2, 0),
    DAMAGE_3(100, 3, 0),
    DEFENSE_1(20, 0, 1),
    DEFENSE_2(40, 0, 2),
    DEFENSE_3(80, 0, 3),
    NO_LEFT_RING(0, 0, 0),
    NO_RIGHT_RING(0, 0, 0),
    ;

    private final int cost;
    private final int damage;
    private final int armor;

    Ring(int cost, int damage, int armor) {
        this.cost = cost;
        this.damage = damage;
        this.armor = armor;
    }

    public int getCost() {
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }
}
