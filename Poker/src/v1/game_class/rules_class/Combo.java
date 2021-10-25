package v1.game_class.rules_class;

import java.util.ArrayList;
import java.util.Objects;

import v1.game_class.Card;

public abstract class Combo {
	String name;
	String comboColor;
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

	public String getComboColor() { return comboColor;}

	public int getComboType() {
		return type;
	}
	
	public int getAdditionalcombovalue() {
		return additionalcombovalue;
	}

	@Override
	public abstract boolean equals(Object o);
}
