package v1.game_class;

import java.util.Objects;

// A game is compose of 2 hands
public class Game {
	private Hand hand1;
	private Hand hand2;

	// Constructor
	public Game(Hand hand1, Hand hand2) {
		this.hand1 = hand1;
		this.hand2 = hand2;
	}

	// accesseur
	public Hand getHand1() {
		return hand1;
	}

	public Hand getHand2() {
		return hand2;
	}

	public String toString() {
		return hand1.toString() + " et " + hand2.toString();
	}

	@Override
	public boolean equals(Object obj) {
		Game otherGame = (Game) obj;
		boolean sameGame1 = otherGame.getHand1().equals(this.getHand1());
		boolean sameGame2 = otherGame.getHand2().equals(this.getHand2());
		if(sameGame1 && sameGame2) return true;
		return false;
	}
	
	

}
