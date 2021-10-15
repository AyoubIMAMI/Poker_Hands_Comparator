package v1.game_class;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.rules_class.Combo;
import v1.game_engine.HandAnalyzer;
// A game is compose of 2 hands
public class Game {
	private Hand player1;
	private Hand player2;
	private HandAnalyzer handAnalyzer = new HandAnalyzer();
	

	//Constructor
	public Game(Hand hand1, Hand hand2){
		this.player1 = hand1;
		this.player2 = hand2;
		//handAnalyzer= new HandAnalyzer(this.player1, this.player2);
	}
	
	//Check all rules to determine who is the winner
	//Optional<Hand> because the two player are able to make a draw game (egality)
	/*public Optional<Hand> whoWin(){
		return handAnalyzer.hauteur(); 
	}*/
	 
	private ArrayList<Combo> getComboPlayer(Hand player) {
		return handAnalyzer.getCombo(player.getCards());
	}
	
	public ArrayList<Combo> getAllComboPlayer1() {
		return getComboPlayer(this.player1);
	}
	
	public ArrayList<Combo> getAllComboPlayer2() {
		return getComboPlayer(this.player2);
	}
	
	//accesseur
	public Hand getPlayer1() {
		return player1;
	}

	public Hand getPlayer2() {
		return player2;
	}

	/*public ArrayList<Card> getWinningCard() {
		return handAnalyzer.getWinningCard();
	}

	public String getWinningMethod() {
		return handAnalyzer.getWinningMethod();
	}*/
	
	public HandAnalyzer getHandAnalyzer() {
		return handAnalyzer;
	}
	
	public String toString(){
		return player1.toString()+" et "+ player2.toString();
	}
	
	
}
