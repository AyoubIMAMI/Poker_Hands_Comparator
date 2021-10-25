package v1.game_class.rules_class;

import v1.game_class.Card;

import java.util.ArrayList;

/**
 * A Brelan is composed of 3 cards having the same value.
 */

public class Brelan extends Combo {

	/**
	 * Creates a Brelan.
	 * @param brelan List of 3 cards having the same value.
	 */
	public Brelan(ArrayList<Card> brelan) {
		this.name = "Brelan";
		this.priorityValue = 3;
		this.cardOfCombo = brelan;
		this.comboValue = brelan.get(0).getValue();
		this.type = 1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		Brelan otherBrelan = (Brelan) o;
		if (this.comboValue == otherBrelan.getComboValue()) return true;
		return false;
	}
}
