package v1.game_class.rules_class;

import v1.game_class.Card;

import java.util.ArrayList;

public class Paire extends Combo{

    public Paire(ArrayList<Card> paire) {
        this.name = "La Paire";
        this.priorityValue = 1;
        this.cardOfCombo=paire;
        this.comboValue = paire.get(0).getValue();
    }



    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
}
