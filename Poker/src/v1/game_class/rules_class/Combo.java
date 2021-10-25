package v1.game_class.rules_class;

import java.util.ArrayList;
import v1.game_class.Card;

/**
 * A Combo is composed of a list of cards, a priority value, a type and eventually a color and an additional value
 *
 * @author LE BIHAN Léo
 * @author IMAMI Ayoub
 * @author KARRAKCHOU Mourad
 */
public abstract class Combo {
	String name;
	String comboColor;
	int priorityValue;
	int comboValue;
	int type;
	int additionalcombovalue;
	ArrayList<Card> cardOfCombo = new ArrayList<Card>();

	public abstract String toString();// a enlever
	
	/**
	 * @return all the cards of the Combo.
	 */
	public ArrayList<Card> getCardOfCombo() {
		return cardOfCombo;
	}

	/**
	 * @return The name of the Combo.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return The priority of the Combo.
	 */
	public int getPriorityValue() {
		return priorityValue;
	}

	/**
	 * @return The value of the Combo.
	 */
	public int getComboValue() {
		return comboValue;
	}

	/**
	 * @return The color of the Combo.
	 */
	public String getComboColor() {
		return comboColor;
	}

	/**
	 * @return all the cards of the Combo.
	 */
	public int getComboType() {
		return type;
	}
	
	/**
	 * @return The additional value of the Combo.
	 */
	public int getAdditionalcombovalue() {
		return additionalcombovalue;
	}

	/**
	 * Checks if two Combo are equal
	 *@param \Object obj
	 */
	@Override
	public abstract boolean equals(Object o);
}
