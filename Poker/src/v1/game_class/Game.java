package v1.game_class;

// A game is compose of 2 hands
public class Game {
	private Hand player1;
	private Hand player2;

	// Constructor
	public Game(Hand hand1, Hand hand2) {
		this.player1 = hand1;
		this.player2 = hand2;
	}

	// accesseur
	public Hand getPlayer1() {
		return player1;
	}

	public Hand getPlayer2() {
		return player2;
	}

	public String toString() {
		return player1.toString() + " et " + player2.toString();
	}

}
