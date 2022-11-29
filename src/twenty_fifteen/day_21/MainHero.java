package twenty_fifteen.day_21;

public class MainHero extends GameCharacter {
    private Weapon weapon;
    private Armor armor;
    private Ring leftRing;
    private Ring rightRing;

    public MainHero(int hitPoints, Weapon weapon, Armor armor, Ring leftRing, Ring rightRing) {
        super(weapon.getDamage()+ armor.getDamage()+ leftRing.getDamage()+ rightRing.getDamage(),
                weapon.getArmor()+ armor.getArmor()+ leftRing.getArmor()+ rightRing.getArmor(),
                hitPoints);
        this.weapon = weapon;
        this.armor = armor;
        this.leftRing = leftRing;
        this.rightRing = rightRing;
    }
}
