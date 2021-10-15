package v1.game_engine;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.Card;
import v1.game_class.Hand;
import v1.game_class.rules_class.Combo;
import v1.game_class.rules_class.Hauteur;

public class HandComparator {
	private Hand firstHand;
	private Hand secondHand;
	
	private ArrayList<Combo> comboPlayer1;
	private ArrayList<Combo> comboPlayer2;
	
	private int playerWhoWin=0;

	
	public HandComparator(Hand hand1, Hand hand2, ArrayList<Combo> newComboPlayer1, ArrayList<Combo> newComboPlayer2) {
		this.firstHand = hand1;
		this.secondHand = hand2;
		this.comboPlayer1 = newComboPlayer1;
		this.comboPlayer2 = newComboPlayer2;
	}
	
	public Optional<Hand> getWinner() {
			Optional<Hand> winner = null;
			Hauteur player1Hauteur = (Hauteur) comboPlayer1.get(0);
			Hauteur player2Hauteur = (Hauteur) comboPlayer2.get(0);

			if(player1Hauteur.getHauteur() > player2Hauteur.getHauteur()) {
				playerWhoWin=1;
				return winner.of(firstHand);
			} 
			else if(player1Hauteur.getHauteur() == player2Hauteur.getHauteur()) {
				return winner.empty();
			}
			
			else {
				playerWhoWin=2;
				return winner.of(firstHand);
			}
	}

	public Optional<ArrayList<Combo>> getWinnerCombo() {
		Optional<ArrayList<Combo>> winnerCombo = null;
		if(playerWhoWin == 1 )return winnerCombo.of(comboPlayer1);
		else if(playerWhoWin == 0) return  winnerCombo.empty();
		else return winnerCombo.of(comboPlayer2);
	}
}
