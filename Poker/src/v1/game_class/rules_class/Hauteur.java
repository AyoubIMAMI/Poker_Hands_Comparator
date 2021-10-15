package v1.game_class.rules_class;

import java.util.ArrayList;

import v1.game_class.Card;

public class Hauteur extends Combo{
	int hauteurValue;

	public Hauteur(Card hightestCard) {
		this.name = "La Hauteur";
		this.priorityValue = 1;
		this.cardOfCombo.add(hightestCard);
		hauteurValue = hightestCard.getValue();
	}
	
	public int getHauteur() {
		return hauteurValue;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
