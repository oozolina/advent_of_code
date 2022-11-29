package twenty_fifteen.day_22;

public class StrategyCorner {

    public static int minManaToWin(Wizard wizard, BossEnemy boss){
        GameState game = new GameState();
        game.wizard = wizard;
        game.boss = boss;

        StrategyNode root = new StrategyNode(game);
        return root.getMinManaToWin();
    }
}