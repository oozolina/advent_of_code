package twenty_fifteen.day_22;

public class Spell {

    public static Spell MAGIC_MISSILE(){return new Spell("magic missile", 53, 1, (wizard, boss) -> {
        boss.setHitPoints(boss.getHitPoints()-4);
    });}

    public static Spell DRAIN(){return new Spell("drain",73, 1, (wizard, boss) -> {
        boss.setHitPoints(boss.getHitPoints()-2);
        wizard.setHitPoints(wizard.getHitPoints()+2);
    });}

    public static Spell SHIELD(){return new Spell("shield",113, 6, (wizard, boss) -> {
        wizard.setArmorScore(wizard.getArmorScore() + 7);
    });}

    public static Spell POISON(){return new Spell("poison", 173, 6, (wizard, boss) -> {
        boss.setHitPoints(boss.getHitPoints() - 3);
    });}

    public static Spell RECHARGE(){return new Spell("recharge", 229, 5, (wizard, boss) -> {
        wizard.setMana(wizard.getMana() + 101);
    });}

    private String name;
    private final SpellLambda effect;
    private final int cost;
    private final int duration;
    private int remainingTurns;

    private interface SpellLambda {
        void applyEffect(Wizard wizard, BossEnemy boss);
    }

    private Spell(String name, int cost, int duration, SpellLambda effect) {
        this.name = name;
        this.cost = cost;
        this.duration = duration;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public boolean canCast(int mana) {
        return remainingTurns == 0 && cost <= mana;
    }

    public void applyEffect(Wizard wizard, BossEnemy boss) {
        if(this.remainingTurns>0){
            this.effect.applyEffect(wizard, boss);
            this.remainingTurns--;
        }
    }

    public Spell clone(){
        Spell retVal = new Spell(this.name, this.cost, this.duration, this.effect);
        retVal.remainingTurns = this.remainingTurns;
        return retVal;
    }

    public int getCost() {
        return cost;
    }


    public int getDuration() {
        return duration;
    }

    public int getRemainingTurns() {
        return remainingTurns;
    }

    public void setRemainingTurns(int remainingTurns) {
        this.remainingTurns = remainingTurns;
    }
}
