package v1.game_class;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.rules_class.Combo;
import v1.game_engine.HandAnalyzer;

public class Hand {
	private String name;
	private ArrayList<Card> cardList = new ArrayList<Card>();
	private Optional<Combo> comboOfThePlayer;
	private HandAnalyzer handAnalyzerOfPlayer;

	public Hand(String name, ArrayList<Card> cardValue) {
		this.name = name;
		this.cardList = cardValue;
		handAnalyzerOfPlayer = new HandAnalyzer(cardList);
		comboOfThePlayer = handAnalyzerOfPlayer.getCombo();
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.name + " a les carte " + this.cardList.toString();
	}

	public ArrayList<Card> getCardList() {
		return cardList;
	}

	public Optional<Combo> getComboOfThePlayer() {
		return comboOfThePlayer;
	}
	

	public void setComboOfThePlayer(Optional<Combo> comboOfThePlayer) {
		this.comboOfThePlayer = comboOfThePlayer;
	}

	public HandAnalyzer getHandAnalyzerOfPlayer() {
		return handAnalyzerOfPlayer;
	}

	public ArrayList<Card> getNoUsedCards() {
		return this.handAnalyzerOfPlayer.getListOfNoUsedCards();
	}

}
