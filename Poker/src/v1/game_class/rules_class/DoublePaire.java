package v1.game_class.rules_class;

import v1.game_class.Card;

import java.util.ArrayList;

public class DoublePaire extends Combo {
	int additionalcombovalue;

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
	public String toString() {
		return null;
	}
}
