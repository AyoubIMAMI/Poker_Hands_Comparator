package v1.game_class.rules_class;

import v1.game_class.Card;
import v1.game_class.Hand;

import java.util.ArrayList;

/**
 * A Flush is composed of 5 cards having the same color without sequence.
 *
 * @author LE BIHAN Léo
 * @author IMAMI Ayoub
 * @author KARRAKCHOU Mourad
 */
public class Flush extends Combo {

    /**
     * Creates a Flush.
     * @param flush List of 5 cards having the same color without sequence.
     */
    public Flush(ArrayList<Card> flush) {
        this.name = "Flush";
        this.priorityValue = 5;
        this.cardOfCombo = flush;
        this.comboColor = flush.get(0).getColor();
        this.type = 4; //pas utile
    }

    @Override
	public boolean equals(Object obj) {
    	Flush other = (Flush) obj;
		for(int i = 0 ; i < this.cardOfCombo.size() ;i++) {
			if(!this.cardOfCombo.get(i).equals(other.getCardOfCombo().get(i))) return false;
		}
		return true;
	}
}
