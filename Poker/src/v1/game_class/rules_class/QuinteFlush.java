package v1.game_class.rules_class;

import v1.game_class.Card;

import java.util.ArrayList;

public class QuinteFlush extends Combo {

    public QuinteFlush(ArrayList<Card> quinteFlush) {
        this.name = "Quinte Flush";
        this.priorityValue = 8;
        this.cardOfCombo = quinteFlush;
        this.comboValue = quinteFlush.get(quinteFlush.size()-2).getValue();
        this.type = 4; //pas utile
        this.comboColor = quinteFlush.get(0).getColor();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
	public boolean equals(Object o) {
    	QuinteFlush other = (QuinteFlush) o;
		if(this.comboColor == other.getComboColor()) {
			Quinte currentQuinte = new Quinte(cardOfCombo);
			Quinte otherQuinte = new Quinte(other.getCardOfCombo());
			return currentQuinte.equals(otherQuinte);

		}
		return false;		
	}
}
