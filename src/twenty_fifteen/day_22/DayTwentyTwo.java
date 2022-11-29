package twenty_fifteen.day_22;

import java.util.ArrayList;

public class DayTwentyTwo {
    public static void main(String[] args) {
        //        Run using test data
//        ArrayList<Spell> spells = new ArrayList<>();
//        spells.add(Spell.POISON());
//        spells.add(Spell.MAGIC_MISSILE());
//        int mana = StrategyCorner.minManaToWin(new Wizard(10, 250, spells), new BossEnemy(8, 0, 13));
//        int mana = StrategyCorner.minManaToWin(new Wizard(10, 250, spells), new BossEnemy(8, 0, 14));

        ArrayList<Spell> spells = new ArrayList<>();
        spells.add(Spell.POISON());
        spells.add(Spell.MAGIC_MISSILE());
        spells.add(Spell.RECHARGE());
        spells.add(Spell.SHIELD());
        spells.add(Spell.DRAIN());
        //Hit Points: 71
        //Damage: 10
        int mana = StrategyCorner.minManaToWin(new Wizard(50, 500, spells), new BossEnemy(10, 0, 71));
        System.out.println("Least amount of mana you can spend and still win the fight: " + mana);
    }
}
