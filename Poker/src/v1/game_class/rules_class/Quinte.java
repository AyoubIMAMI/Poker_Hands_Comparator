package v1.game_class.rules_class;

import v1.game_class.Card;

import java.util.ArrayList;

/**
 * A Quinte is composed of a sequence of 5 cards without having the same color.
 */

public class Quinte extends Combo {

    /**
     * Creates a Quinte.
     * @param quinte List of a sequence of 5 cards without having the same color.
     */
    public Quinte(ArrayList<Card> quinte) {
        this.name = "Quinte";
        this.priorityValue = 4;
        this.cardOfCombo = quinte;
        this.comboValue = quinte.get(quinte.size()-2).getValue();
        this.type = 3;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
	public boolean equals(Object o) {
    	Quinte other = (Quinte) o;

		if(this.comboColor == other.getComboColor()) {
			for(int i = 0 ; i < this.cardOfCombo.size() ;i++)
				if(!cardOfCombo.get(i).equals(other.getCardOfCombo().get(i))) return false;
			return true;
		}
		return false;
	}


}
