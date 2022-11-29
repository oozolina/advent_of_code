package twenty_fifteen.day_21;

public enum Weapon {

    DAGGER(8, 4, 0),
    SHORT_SWORD(10, 5, 0),
    WAR_HAMMER(25, 6, 0),
    LONG_SWORD(40, 7, 0),
    GREAT_AXE(74, 8, 0);

    private int cost;
    private int damage;
    private int armor;

    Weapon(int cost, int damage, int armor) {
        this.cost = cost;
        this.damage = damage;
        this.armor = armor;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
