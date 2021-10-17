package v1.game_class;

public class Card implements Comparable<Card>{
	private final int value;
	private final String color; //Tr Ca Co Pi
	
	public Card(int newValue, String newColor) {
		this.value = newValue;
		this.color = newColor;
	}

	public Card(int v) {
		this.value = v;
		this.color = "";
	}

	public int getValue() {
		return value;
	}

	public String getColor() {return color;}
	
	public String toString(){
		return String.valueOf(this.value) + " " + this.color;
		}

	@Override
	public int compareTo(Card card) {
	 //trions les cartes selon leur valeurs dans l'ordre croissant
	 //retourne un entier négative, zéro ou positive si l'age 
	 //de cet employé est moins que, égale à ou supérieur à l'objet comparé avec card
	       return (this.value - card.value);
	}
}

