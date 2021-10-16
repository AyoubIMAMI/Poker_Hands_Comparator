package v1.game_engine;

import v1.game_class.Game;

public class Controller {
	
	private Game pGame;
	private PrintPoker printP;
	private InputPoker inputP;
	
	public Controller(){}
	
	
	public void initGame() {
		inputP = new InputPoker();
		pGame = inputP.init();
		printP = new PrintPoker(pGame);

	}
	
	public void startGame() {
		HandComparator handComp = new HandComparator(this.pGame.getPlayer1(), this.pGame.getPlayer2());
		printP.win(handComp.getWinner(),handComp.getWinningComboIndex());

	}
	
}
