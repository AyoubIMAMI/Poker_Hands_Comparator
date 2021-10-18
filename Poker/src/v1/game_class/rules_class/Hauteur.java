package v1.game_class.rules_class;

import v1.game_class.Card;

public class Hauteur extends Combo{

	public Hauteur(Card hightestCard) {
		this.name = "La Hauteur";
		this.priorityValue = 0;
		this.cardOfCombo.add(hightestCard);
		this.comboValue = hightestCard.getValue();
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
