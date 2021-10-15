package v1.game_class;

public class Card implements Comparable<Card>{
	//card value
	private int value;
	//constructor
	public Card(int v) {
		this.value = v;
	}
	//return the value of the card
	public int getValue() {
		return value;
	}
	
	public String toString(){
		return String.valueOf(this.value);
		}

	@Override
	public int compareTo(Card card) {
	 //trions les cartes selon leur valeurs dans l'ordre croissant
	 //retourne un entier négative, zéro ou positive si l'age 
	 //de cet employé est moins que, égale à ou supérieur à l'objet comparé avec card
	       return (this.value - card.value);
	}
}

