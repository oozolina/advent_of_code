package twenty_fifteen.day_21;

public abstract class GameCharacter {
    private int damageScore;
    private int armorScore;
    private int hitPoints;

    protected GameCharacter(int damageScore, int armorScore, int hitPoints) {
        this.damageScore = damageScore;
        this.armorScore = armorScore;
        this.hitPoints = hitPoints;
    }

    //both can attack
    public void attack(GameCharacter enemy){
        int totalDamage = this.damageScore - enemy.armorScore;
        if(totalDamage < 1){
            totalDamage = 1;
        }
        enemy.hitPoints -= totalDamage;
    }

    public int getDamageScore() {
        return damageScore;
    }

    public int getArmorScore() {
        return armorScore;
    }

    public int getHitPoints() {
        return hitPoints;
    }
}
