package v1;

import java.util.ArrayList;

import v1.game_class.Game;
import v1.game_class.rules_class.Combo;
import v1.game_engine.HandAnalyzer;
import v1.game_engine.HandComparator;
import v1.game_engine.InputPoker;
import v1.game_engine.PrintPoker;

//main class
public class Main {

	public static void main(String[] args) {
		InputPoker inputP = new InputPoker();
		Game pGame = inputP.init();
		PrintPoker printP = new PrintPoker(pGame);
		HandComparator handComp = new HandComparator(pGame.getPlayer1(), pGame.getPlayer2(), pGame.getAllComboPlayer1(), pGame.getAllComboPlayer2());
		
		printP.start();
		
		printP.win(handComp.getWinner(), handComp.getWinnerCombo());
				
	}
}
