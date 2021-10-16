package v1.game_class;
import java.util.ArrayList;

import v1.game_class.rules_class.Combo;
import v1.game_engine.HandAnalyzer;

public class Hand {
	private String name;
	private ArrayList<Card> cardList = new ArrayList<Card>();
	private ArrayList<Combo> comboOfThePlayer = new ArrayList<Combo>();
	private HandAnalyzer handAnalyzerOfPlayer = new HandAnalyzer();
	
	public Hand(String name, ArrayList<Card> cardValue) {
		this.name = name;
		this.cardList = cardValue;
		comboOfThePlayer = handAnalyzerOfPlayer.getCombo(cardList);
	}
	
	public String getName() {
		return name;
	}
	
	public String toString(){
		return this.name +" a les carte "+ this.cardList.toString();
	}

	public ArrayList<Card> getCardList() {
		return cardList;
	}

	public ArrayList<Combo> getComboOfThePlayer() {
		return comboOfThePlayer;
	}

	public HandAnalyzer getHandAnalyzerOfPlayer() {
		return handAnalyzerOfPlayer;
	}



}
