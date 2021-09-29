package v1;

public class Hand {
	private String name;
	private Card card;
	
	public Hand(String name, Card aCard) {
		this.name = name;
		this.card = aCard;
	}

	public Card getCard() {
		return card;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString(){
		return this.name +" a la carte "+ this.card.toString();
	}
	
}
