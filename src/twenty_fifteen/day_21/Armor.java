package twenty_fifteen.day_21;

public enum Armor {
    LEATHER(13, 0, 1),
    CHAIN_MAIL(31, 0, 2),
    SPLINT_MAIL(53, 0, 3),
    BANDED_MAIL(75, 0, 4),
    PLATE_MAIL(102, 0, 5),
    NO_ARMOR(0,0,0)
    ;

    private final int cost;
    private final int damage;
    private final int armor;

    Armor(int cost, int damage, int armor) {
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
