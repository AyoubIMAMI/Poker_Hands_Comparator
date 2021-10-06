package v1;

import java.util.Optional;
import java.util.Scanner;
// A game is compose of 2 hands
public class Game {
	private Hand player1;
	private Hand player2;
	private Card whatwin;
	private String howwin;

	//Constructor
	public Game(Hand hand1, Hand hand2){
		this.player1 = hand1;
		this.player2 = hand2;
	}
	
	//Check all rules to determine who is the winner
	//Optional<Hand> because the two player are able to make a draw game (egality)
	public Optional<Hand> whoWin(){
		return hauteur();
	}
	
	//rules
	//Check if the two player card and determine which card is better
	//Optional<Hand> because the two player are able to make a draw game when the two card are equal(egality)
	public Optional<Hand> hauteur(){
		int scoreP1 = player1.getCard();
		int scoreP2 = player2.getCard();
		for (int i=0,while i<(player1.getCard()).length,i++)
			if (scoreP1[i].getvalue > scoreP2[i].getvalue){
				this.whatwin=scoreP1[i];
				this.howwin="la Hauteur";
				return Optional.of(player1);
				}
			else if (scoreP2[i] > scoreP1[i]){
				this.whatwin=scoreP2[i];
				this.howwin="la Hauteur";
				return Optional.of(player2);
				}

			else return Optional.empty();
	}
	 
	
	//accesseur
	public Hand getPlayer1() {
		return player1;
	}

	public Hand getPlayer2() {
		return player2;
	}
	
	
	public String toString(){
		return player1.toString()+" et "+ player2.toString();
	}
	
	
}
