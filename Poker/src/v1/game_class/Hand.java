package v1.game_class;
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

	//Renvoit une Arraylist avec le nombre de x dans la main (avec x le numero de la carte).
	public ArrayList<Integer> createList(){
		int value;
		ArrayList<Integer> tab=new ArrayList<Integer>();
		for (int i=0;i<15;i++)
			{tab.add(i,0);}
		for (int k=0;k<cardList.size();k++)
			{value=cardList.get(k).getValue();
			tab.set(value,tab.get(value)+1);
			}
		return tab;
	}
	public String getName() {
		return name;
	}
	
	public String toString(){
		return this.name +" a les carte "+ this.cardList.toString();
	}

}
