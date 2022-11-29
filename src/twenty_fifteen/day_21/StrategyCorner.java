package twenty_fifteen.day_21;

public class StrategyCorner {

    public static boolean willHeroWin(GameCharacter hero, GameCharacter boss) {
        do {
            hero.attack(boss);
            if (boss.getHitPoints() <= 0) {
                return true;
            }
            boss.attack(hero);
            if (hero.getHitPoints() <= 0) {
                return false;
            }
        } while (true);
    }

    //Part 1
    public int minCostToWin() {
        int minCost = Integer.MAX_VALUE;
        String equipment = "";
        for (Weapon weapon : Weapon.values()) {
            for (Armor armor : Armor.values()) {
                for (Ring leftRing : Ring.values()) {
                    for (Ring rightRing : Ring.values()) {
                        if (leftRing.equals(rightRing)) {
                            continue;
                        }
                        GameCharacter hero = new MainHero(100, weapon, armor, leftRing, rightRing);
                        GameCharacter bossEnemy = new BossEnemy();
                        if (StrategyCorner.willHeroWin(hero, bossEnemy)) {
                            int cost = weapon.getCost() + armor.getCost() + leftRing.getCost() + rightRing.getCost();
                            if (cost < minCost) {
                                minCost = cost;
                                equipment = weapon.name() + " " + armor.name() + " " + leftRing.name() + " " + rightRing.name();
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The hero won with equipment " + equipment + " and spent " + minCost + " gold coins.");
        return minCost;
    }

    // Part 2
    public int maxCostToLose() {
        int maxValue = Integer.MIN_VALUE;
        String equipment = "";
        for (Weapon weapon : Weapon.values()) {
            for (Armor armor : Armor.values()) {
                for (Ring leftRing : Ring.values()) {
                    for (Ring rightRing : Ring.values()) {
                        if (leftRing.equals(rightRing)) {
                            continue;
                        }
                        GameCharacter hero = new MainHero(100, weapon, armor, leftRing, rightRing);
                        GameCharacter bossEnemy = new BossEnemy();
                        if (!StrategyCorner.willHeroWin(hero, bossEnemy)) {
                            int cost = weapon.getCost() + armor.getCost() + leftRing.getCost() + rightRing.getCost();
                            if (cost > maxValue) {
                                maxValue = cost;
                                equipment = weapon.name() + " " + armor.name() + " " + leftRing.name() + " " + rightRing.name();
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The hero lost with equipment " + equipment + " and spent " + maxValue + " gold coins.");
        return maxValue;
    }
}