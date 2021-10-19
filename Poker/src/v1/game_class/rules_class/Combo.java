package v1.game_class.rules_class;

import java.util.ArrayList;

import v1.game_class.Card;

public abstract class Combo {
	String name;
	int priorityValue;
	int comboValue;
	int type;
	int additionalcombovalue;



	ArrayList<Card> cardOfCombo = new ArrayList<Card>();

	public abstract String toString();

	public ArrayList<Card> getCardOfCombo() {
		return cardOfCombo;
	}

	public String getName() {
		return name;
	}

	public int getPriorityValue() {
		return priorityValue;
	}

	public int getComboValue() {
		return comboValue;
	}

	public int getComboType() {
		return type;
	}
	
	public int getAdditionalcombovalue() {
		return additionalcombovalue;
	}
}
