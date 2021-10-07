package v1;

//main class
public class Main {

	public static void main(String[] args) {
		InputPoker inputP = new InputPoker();
		Game pGame = inputP.init();
		PrintPoker printP = new PrintPoker(pGame);

		printP.start();
		printP.win(pGame.whoWin(),pGame.getWinningMethod(), pGame.getWinningCard());
	}
}
