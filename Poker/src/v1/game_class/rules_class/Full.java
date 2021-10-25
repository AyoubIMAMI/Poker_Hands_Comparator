package v1.game_class.rules_class;

/**
 * A Full is composed of a Brelan and a Pair.
 */
public class Full extends Combo {

	/**
	 * Creates a Full.
	 * @param brelan The Brelan.
	 * @param paire The Pair.
	 */
	public Full(Combo brelan, Combo paire) {
		this.name = "Full";
		this.priorityValue = 6;
		this.cardOfCombo.addAll(brelan.getCardOfCombo());
		this.cardOfCombo.addAll(paire.getCardOfCombo());
		this.comboValue = brelan.getComboValue();
		this.additionalcombovalue = paire.getComboValue();
		this.type = 2;
	}
	
	public int getAdditionalcombovalue() {
		return additionalcombovalue;
	}


	@Override
	public boolean equals(Object o) {
		Full otherFull = (Full) o;
		if (this.comboValue == otherFull.getComboValue() && this.additionalcombovalue == otherFull.getAdditionalcombovalue()) return true;
		return false;
	}
}
