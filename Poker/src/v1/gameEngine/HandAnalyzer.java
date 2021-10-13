package v1.gameEngine;

import java.util.ArrayList;
import java.util.Optional;

import v1.gameClass.Card;
import v1.gameClass.Hand;

public class HandAnalyzer {
	private Hand firstHand;
	private Hand secondHand;
	private ArrayList<Card> winningCard;
	private String winningMethod;

	
	public HandAnalyzer(Hand newHand1, Hand newHand2){
		this.firstHand = newHand1;
		this.secondHand = newHand2;
		winningCard = new ArrayList<Card>();
	}
	
	//rules
	//Check if the two player card and determine which card is better
	//Optional<Hand> because the two player are able to make a draw game when the two card are equal(egality)
	public Optional<Hand> hauteur(){
		ArrayList<Card> scoreP1 = firstHand.getCard();
		ArrayList<Card> scoreP2 = secondHand.getCard();
		int i=0;
		int len=(firstHand.getCard()).size();
		while (i<len) {
			if (scoreP1.get(len-i-1).getValue() > scoreP2.get(len-i-1).getValue()){
				this.winningCard.add(scoreP1.get(len-i-1));
				this.winningMethod="la Hauteur";
				return Optional.of(firstHand);
				}
			else if (scoreP2.get(len-i-1).getValue() > scoreP1.get(len-i-1).getValue()){
				this.winningCard.add(scoreP2.get(len-i-1));
				this.winningMethod="la Hauteur";
				return Optional.of(secondHand);
				}
			i++;
			}
		
		return Optional.empty();
		}
	
	public ArrayList<Card> getWinningCard() {
		return winningCard;
	}

	public String getWinningMethod() {
		return winningMethod;
	}
	
	

}
