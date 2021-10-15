package v1.game_class;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_engine.HandComparator;

// A game is compose of 2 hands
public class Game {
	private Hand player1;
	private Hand player2;
	private HandComparator handComparator;
	

	//Constructor
	public Game(Hand hand1, Hand hand2){
		this.player1 = hand1;
		this.player2 = hand2;
		handComparator= new HandComparator(this.player1, this.player2);}
	
	//Check all rules to determine who is the winner
	//Optional<Hand> because the two player are able to make a draw game (egality)
	public Optional<String> whoWin(){
		handComparator.setWinner();
		return(handComparator.getWinner());
	}
	  

	//accesseur
	public Hand getPlayer1() {
		return player1;
	}

	public Hand getPlayer2() {
		return player2;
	}

	public ArrayList<Card> getWinningCard() {
		return handComparator.getWinningCard();
	}

	public String getWinningMethod() {
		return handComparator.getWinningMethod();
	}
	
	
	public String toString(){
		return player1.toString()+" et "+ player2.toString();
	}
	
	
}
