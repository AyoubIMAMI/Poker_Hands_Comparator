package v1.game_class.rules_class;

import v1.game_class.Card;

import java.util.ArrayList;

public class Flush extends Combo {

    public Flush(ArrayList<Card> flush) {
        this.name = "Flush";
        this.priorityValue = 5;
        this.cardOfCombo = flush;
        this.comboColor = flush.get(0).getColor();
        this.type = 4;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}
