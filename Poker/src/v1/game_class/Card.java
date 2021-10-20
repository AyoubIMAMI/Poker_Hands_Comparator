package v1.game_class;

public class Card implements Comparable<Card> {
	private final int value;
	private final String color; // Tr Ca Co Pi

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

	public String getColor() {
		return color;
	}

	public String toString() {
		String headStringValue;
		if((headStringValue=isHead()).equals("-1"))
			return String.valueOf(this.value) + " " + this.color;
		else
			return headStringValue + " " + this.color;
	}

	
	private String isHead() {
		switch (this.value) {
		case 11:
			return "V";
		case 12:
			return "D";
		case 13:
			return "R";
		case 14:
			return "A";
		default:
			return "-1";
		}
	}
	
	@Override
	public int compareTo(Card card) {
		// trions les cartes selon leur valeurs dans l'ordre croissant
		// retourne un entier négative, zéro ou positive si l'age
		// de cet employé est moins que, égale à ou supérieur à l'objet comparé avec
		// card
		return (this.value - card.value);
	}
}
