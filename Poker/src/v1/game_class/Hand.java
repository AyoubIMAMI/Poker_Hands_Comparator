package v1.game_class;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.rules_class.Combo;
import v1.game_engine.HandAnalyzer;

/**
 * A Hand is compose of 5 cards
 * 
 * @author KARRAKCHOU Mourad
 * @author IMAMI Ayoub
 * @author LE BIHAN  Leo
 */
public class Hand {
	private String name;
	private ArrayList<Card> cardList = new ArrayList<Card>();
	private Optional<Combo> comboOfThePlayer;
	private HandAnalyzer handAnalyzerOfPlayer;

	
	/**
	 * Create a Hand with a name and a list of cards
	 * @param name
	 * @param listOfCard
	 */
	public Hand(String name, ArrayList<Card> listOfCard) {
		this.name = name;
		this.cardList = listOfCard;
		handAnalyzerOfPlayer = new HandAnalyzer(cardList);
		comboOfThePlayer = handAnalyzerOfPlayer.getCombo();
	}

	/**
	 * @return The name of the Hand.
	 */
	public String getName() {
		return name; 
	}

	/**
	 * @return The list of cards of the Hand.
	 */
	public ArrayList<Card> getCardList() {
		return cardList;
	}

	/**
	 * @return The Optional Combo of the Hand.
	 */
	public Optional<Combo> getComboOfThePlayer() {
		return comboOfThePlayer;
	}
	
	/**
	 * @return The HandAnalyzer of the Hand.
	 */
	public HandAnalyzer getHandAnalyzerOfPlayer() {
		return handAnalyzerOfPlayer;
	}

	/**
	 * @return The no used cards of the Hand.
	 */
	public ArrayList<Card> getNoUsedCards() {
		return this.handAnalyzerOfPlayer.getListOfNoUsedCards();
	}
	
	/** 
	 * Set the Optional Combo of the Hand.
	 * @param comboOfThePlayer
	 */
	public void setComboOfThePlayer(Optional<Combo> comboOfThePlayer) {
		this.comboOfThePlayer = comboOfThePlayer;
	}
	
	/**
	 * @return The string representation of a Game
	 */
	public String toString() {
		return this.name + " a les carte " + this.cardList.toString();
	}

	/**
	 * Check if two Hand are equals
	 *@param Object obj
	 *@return True if the two Hand are equals
	 */
	@Override
	public boolean equals(Object obj) {
		Hand otherHand = (Hand) obj;
		for(int i = 0 ; i < this.cardList.size() ;i++) {
			if(!cardList.get(i).equals(otherHand.getCardList().get(i))) return false;
		}
		return true;
	}
}
