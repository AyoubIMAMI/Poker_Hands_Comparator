package v1.game_class.rules_class;

import v1.game_class.Card;

import java.util.ArrayList;

public class Square extends Combo {

	public Square(ArrayList<Card> square) {
		this.name = "Square";
		this.priorityValue = 7;
		this.cardOfCombo = square;
		this.comboValue = square.get(0).getValue();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
