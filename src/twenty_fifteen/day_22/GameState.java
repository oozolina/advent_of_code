package twenty_fifteen.day_22;

import java.util.ArrayList;

public class GameState {
    public BossEnemy boss;
    public Wizard wizard;
    public int totalManaSpent = 0;

    @Override
    public GameState clone() {
        GameState gameState = new GameState();

        gameState.boss = new BossEnemy(this.boss.getDamageScore(), this.boss.getArmorScore(), this.boss.getHitPoints());

        ArrayList<Spell> spells = new ArrayList<>();
        for (Spell spell: wizard.getSpellsArsenal()) {
            spells.add(spell.clone());

        }
        gameState.wizard = new Wizard(this.wizard.getHitPoints(), this.wizard.getMana(), spells);
        gameState.totalManaSpent = this.totalManaSpent;

        return gameState;
    }

}