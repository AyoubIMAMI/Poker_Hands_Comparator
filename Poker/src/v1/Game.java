package v1;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
// A game is compose of 2 hands
public class Game {
	private Hand player1;
	private Hand player2;
	private Card whatWin;
	private String howWin;

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
		ArrayList<Card> scoreP1 = player1.getCard();
		ArrayList<Card> scoreP2 = player2.getCard();
		int i=0;
		int len=(player1.getCard()).size();
		while (i<len) {
			if (scoreP1.get(len-i-1).getValue() > scoreP2.get(len-i-1).getValue()){
				this.whatWin=scoreP1.get(len-i-1);
				this.howWin="la Hauteur";
				return Optional.of(player1);
				}
			else if (scoreP2.get(len-i-1).getValue() > scoreP1.get(len-i-1).getValue()){
				this.whatWin=scoreP2.get(len-i-1);
				this.howWin="la Hauteur";
				return Optional.of(player2);
				}
			i++;}
		return Optional.empty();
		}

	 
	
	//accesseur
	public Hand getPlayer1() {
		return player1;
	}

	public Hand getPlayer2() {
		return player2;
	}

	public Card getwhatWin() {
		return whatWin;
	}

	public String gethowWin() {
		return howWin;
	}
	
	
	public String toString(){
		return player1.toString()+" et "+ player2.toString();
	}
	
	
}
