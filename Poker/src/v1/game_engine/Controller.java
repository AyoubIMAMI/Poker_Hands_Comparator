package v1.game_engine;

import v1.game_class.Game;

public class Controller {

	private Game pGame;
	private PrintPoker printP;
	private InputPoker inputP;

	public Controller() {
	}

	public Game initGame() {
		inputP = new InputPoker();
		printP = new PrintPoker();
		printP.printRules();
		pGame = inputP.init(inputP.promptCard(), inputP.promptCard());
		printP.start(pGame);
		return pGame;
	}
 
	public void startGame() {
		HandComparator handComp = new HandComparator(this.pGame.getHand1(), this.pGame.getHand2());
		printP.win(handComp.getWinner(), handComp.getWinningComboIndex());

	}

}
