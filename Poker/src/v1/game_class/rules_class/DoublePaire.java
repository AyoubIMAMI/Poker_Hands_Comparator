package v1.game_class.rules_class;

import v1.game_class.Card;

import java.util.ArrayList;

/**
 * A Double pair is composed of 2 pairs.
 *
 * @author LE BIHAN Léo
 * @author IMAMI Ayoub
 * @author KARRAKCHOU Mourad
 */
public class DoublePaire extends Combo {

	/**
	 * Creates a double pair.
	 * @param paire1 The first pair.
	 * @param paire2 The second pair.
	 */
	public DoublePaire(Combo paire1, Combo paire2) {
		this.name = "DoublePaire";
		this.priorityValue = 2;
		this.cardOfCombo.addAll(paire1.getCardOfCombo());
		this.cardOfCombo.addAll(paire2.getCardOfCombo());

		// prend la valeur de la plus grande Paire qui est mise en position 0
		this.comboValue = paire1.getComboValue();
		this.additionalcombovalue = paire2.getComboValue();
		this.type = 2;
	}
	@Override
	public boolean equals(Object o) {
		DoublePaire otherDoublePaire = (DoublePaire) o;
		if (this.comboValue == otherDoublePaire.getComboValue() && this.additionalcombovalue == otherDoublePaire.getAdditionalcombovalue()) return true;
		return false;
	}


	@Override
	public String toString() {
		return null;
	}
}
