package game_class.rules_class;

import game_class.Card;

/**
 * The High consists in considering the highest card value of the hand.
 *
 * @author LE BIHAN Léo
 * @author IMAMI Ayoub
 * @author KARRAKCHOU Mourad
 */
public class Hauteur extends Combo {

	/**
	 * Creates a High.
	 * @param hightestCard The highest card value of the hand.
	 */
	public Hauteur(Card hightestCard) {
		this.name = "La Hauteur";
		this.priorityValue = 0;
		this.cardOfCombo.add(hightestCard);
		this.comboValue = hightestCard.getValue();
		this.type = 0;
	}


	@Override
	public boolean equals(Object o) {
		Hauteur otherHauteur = (Hauteur) o;
		if (this.comboValue == otherHauteur.getComboValue()) return true;
		return false;
	}

}
