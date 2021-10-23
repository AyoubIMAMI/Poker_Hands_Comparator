package v1.game_engine;

import java.util.ArrayList;

import v1.game_class.Card;
import v1.game_class.Game;
import v1.game_class.Hand;

public class Controller {

	private Game pGame;
	private PrintPoker printP;
	private InputPoker inputP;
	private HandComparator handComp;

	public Controller() {
		inputP = new InputPoker();
		printP = new PrintPoker();
	}

	public Game launchGame() {
		printP.printRules();
		pGame = createGame(inputP.promptCard(), inputP.promptCard());
		printP.start(pGame);
		return pGame;
	}

	public void startGame() {
		handComp = new HandComparator(this.pGame.getHand1(), this.pGame.getHand2());
		printP.win(handComp.getWinner());

	}

	
	public Game createGame(ArrayList<Card> listCards1, ArrayList<Card> listCards2) {
		Hand hand1 = new Hand("player1", listCards1);
		Hand hand2 = new Hand("player2", listCards2);
		return new Game(hand1, hand2);
	}
}
