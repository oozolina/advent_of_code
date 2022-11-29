package twenty_fifteen.day_22;

import java.util.ArrayList;

public class Wizard extends GameCharacter {
    private ArrayList<Spell> spellsArsenal;
    private int mana;

    protected Wizard(int hitPoints, int mana, ArrayList<Spell> spells) {
        super(0, 0, hitPoints);
        this.mana = mana;
        this.spellsArsenal = spells;
    }

    public void castSpell(Spell thatSpell){
        this.mana -= thatSpell.getCost();
        thatSpell.setRemainingTurns(thatSpell.getDuration());
    }

    public void applyEffects(BossEnemy boss){
        this.setArmorScore(0);
        for (Spell spell: spellsArsenal) {
            spell.applyEffect(this, boss);
        }
    }

    public int getMana() {
        return mana;
    }

    public ArrayList<Spell> getSpellsArsenal() {
        return spellsArsenal;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
