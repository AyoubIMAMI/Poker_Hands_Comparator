package v1.game_class;

/**
 * A Card has a value and a color.
 * 
 * @author KARRAKCHOU Mourad
 * @author IMAMI Ayoub
 * @author LE BIHAN  Leo
 */
public class Card implements Comparable<Card> {
	private final int value;
	private final String color; // Tr Ca Co Pi

	/**
	 * Create a Card
	 * @param newValue
	 * @param newColor
	 */
	public Card(int newValue, String newColor) {
		this.value = newValue;
		this.color = newColor;
	}
	
	
	/**
	 * @return The value of the card;
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return The color of the card;
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return The string representation of a Card
	 */
	public String toString() {
		String headStringValue;
		if((headStringValue=isHead()).equals("-1"))
			return String.valueOf(this.value) + " " + this.color;
		else
			return headStringValue + " " + this.color;
	}

	/**
	 * @return The string representation of a Head
	 */
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
	
	
	/**
	 * Check if two Card are equals
	 *@param Object obj
	 *@return True if the two card are equals
	 */
	@Override
	public boolean equals(Object obj) {
		Card c = (Card) obj;
		if(c.getValue()==this.getValue() && this.getColor().equals(c.getColor()))return true;
		return false;
	}

	/**
	 * Compare the value of two cards, use this method to sort a ArrayList of cards
	 * @param Object obj
	 * @return A value negative, null or positif
	 */
	@Override
	public int compareTo(Card card) {
		// trions les cartes selon leur valeurs dans l'ordre croissant
		// retourne un entier négative, zéro ou positive si l'age
		// de cet employé est moins que, égale à ou supérieur à l'objet comparé avec
		// card
		return (this.value - card.value);
	}
}
