package game_class.rules_class;

import java.util.ArrayList;

import game_class.Card;

/**
 * A Square is composed of 4 cards having the same value.
 *
 * @author LE BIHAN L�o
 * @author IMAMI Ayoub
 * @author KARRAKCHOU Mourad
 */
public class Square extends Combo {

	/**
	 * Creates a Square.
	 * @param square List of 4 cards having the same value.
	 */
	public Square(ArrayList<Card> square) {
		this.name = "Square";
		this.priorityValue = 7;
		this.cardOfCombo = square;
		this.comboValue = square.get(0).getValue();
		this.type = 1;
	}


	@Override
	public boolean equals(Object o) {
		Square other = (Square) o;
        if(this.comboValue == other.getComboValue()) return true;
        return false;
	}

}