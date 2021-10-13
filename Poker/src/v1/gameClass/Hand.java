package v1.gameClass;
import java.util.ArrayList;

public class Hand {
	private String name;
	private ArrayList<Card> cardList = new ArrayList<Card>();
	
	public Hand(String name, ArrayList<Card> cardValue) {
		this.name = name;
		this.cardList = cardValue;
	}

	public ArrayList<Card> getCard() {
		return cardList;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString(){
		return this.name +" a les carte "+ this.cardList.toString();
	}
	
}
