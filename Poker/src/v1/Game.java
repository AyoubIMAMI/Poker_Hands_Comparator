package v1;

import java.util.Scanner;

public class Game {
	private Hand player1;
	private Hand player2;
	
	public Game(Hand hand1, Hand hand2){
		this.player1 = hand1;
		this.player2 = hand2;
	}
	
	public Hand whoWin(){
		return hauteur();
	}
	
	//regle
	public Hand hauteur(){
		if(player1.getCard().getValue()>player2.getCard().getValue())return player1;
		else
			return player2;
	}
	 
	

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
