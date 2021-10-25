package v1.game_class.rules_class;

import v1.game_class.Card;

import java.util.ArrayList;

/**
 * A Pair is composed of 2 cards having the same value.
 */
public class Paire extends Combo {

	/**
	 * Creates a Pair.
	 * @param paire List of 2 cards having the same value.
	 */
	public Paire(ArrayList<Card> paire) {
		this.name = "La Paire";
		this.priorityValue = 1;
		this.cardOfCombo = paire;
		this.comboValue = paire.get(0).getValue();
		this.type = 1;
	}


	@Override
	public boolean equals(Object o) {
		Paire otherPaire = (Paire) o;
		if (this.comboValue == otherPaire.getComboValue()) return true;
		return false;
	}
}
