package v1.game_class;

/**
 * A Game is composed of 2 hands
 *
 * @author LE BIHAN Léo
 * @author IMAMI Ayoub
 * @author KARRAKCHOU Mourad
 */
public class Game {
	private Hand hand1;
	private Hand hand2;

	/**
	 * Creates a Game
	 * @param hand1
	 * @param hand2
	 */
	public Game(Hand hand1, Hand hand2) {
		this.hand1 = hand1;
		this.hand2 = hand2;
	}

	/**
	 * @return The first Hand of the Game.
	 */
	public Hand getHand1() {
		return hand1;
	}

	/**
	 * @return The second Hand of the Game.
	 */
	public Hand getHand2() {
		return hand2;
	}
	
	/**
	 * @return The string representation of a Game
	 */
	public String toString() {
		return hand1.toString() + " et " + hand2.toString();
	}

	/**
	 * Check if two Game are equals
	 *@param \Object obj
	 *@return True if the two Game are equal
	 */
	@Override
	public boolean equals(Object obj) {
		Game otherGame = (Game) obj;
		boolean sameGame1 = otherGame.getHand1().equals(this.getHand1());
		boolean sameGame2 = otherGame.getHand2().equals(this.getHand2());
		if(sameGame1 && sameGame2) return true;
		return false;
	}
	
	

}
