package v1.game_class.rules_class;

import java.util.ArrayList;
import v1.game_class.Card;

/**
 * A Combo is compose of a list of card, a priority value, a type and eventually a color and a additional value  
 * 
 * @author KARRAKCHOU Mourad
 * @author IMAMI Ayoub
 * @author LE BIHAN  Leo
 */
public abstract class Combo {
	String name;
	String comboColor;
	int priorityValue;
	int comboValue;
	int type;
	int additionalcombovalue;
	ArrayList<Card> cardOfCombo = new ArrayList<Card>();

	
	/**
	 * @return The all cards of the Combo.
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
	 * @return The all cards of the Combo.
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
	 * Check if two Combo are equals
	 *@param Object obj
	 */
	@Override
	public abstract boolean equals(Object o);
}
