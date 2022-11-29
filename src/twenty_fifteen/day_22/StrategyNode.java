package twenty_fifteen.day_22;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StrategyNode {
    private int minManaToWin = Integer.MAX_VALUE;

    public StrategyNode(GameState gameState){
        createChildNodes(this, gameState);
    }

    private StrategyNode(StrategyNode rootNode, GameState currentGameState, String spellName) {

        var wizard = currentGameState.wizard;
        var boss = currentGameState.boss;
        Spell thatSpell = wizard.getSpellsArsenal().stream().filter(x-> x.getName()==spellName).collect(Collectors.toList()).get(0);

        //Part 2
        wizard.setHitPoints(wizard.getHitPoints()-1);
        if(wizard.getHitPoints()<=0){
            return;
        }

        wizard.applyEffects(boss);
        if (bossIsDead(rootNode, currentGameState, boss)) return;
        if(thatSpell.canCast(wizard.getMana())){
            wizard.castSpell(thatSpell);
            currentGameState.totalManaSpent += thatSpell.getCost();
            if(currentGameState.totalManaSpent >= rootNode.getMinManaToWin()){
                return;
            }
        } else{
            return;
        }

        wizard.applyEffects(boss);
        if (bossIsDead(rootNode, currentGameState, boss)) return;

        boss.attack(wizard);
        if(wizard.getHitPoints()<=0){
            return;
        }

        createChildNodes(rootNode, currentGameState);
    }

    private boolean bossIsDead(StrategyNode rootNode, GameState currentGameState, BossEnemy boss) {
        if(boss.getHitPoints()<=0){
            if(rootNode.minManaToWin > currentGameState.totalManaSpent){
                rootNode.minManaToWin = currentGameState.totalManaSpent;
                return true;
            }
        }
        return false;
    }

    private void createChildNodes(StrategyNode rootNode, GameState currentGameState) {
        ArrayList<Spell> currentAccessibleSpells = currentGameState.wizard.getSpellsArsenal();
        for (Spell spell: currentAccessibleSpells) {
            StrategyNode node = new StrategyNode(rootNode, currentGameState.clone(), spell.getName());
        }
    }

    public int getMinManaToWin() {
        return minManaToWin;
    }
}
