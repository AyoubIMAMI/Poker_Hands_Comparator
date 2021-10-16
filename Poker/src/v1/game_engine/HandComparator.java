package v1.game_engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import v1.game_class.Hand;
import v1.game_class.rules_class.Combo;
import v1.game_class.rules_class.Hauteur;
import v1.game_class.rules_class.Paire;

public class HandComparator {
	private Hand player1;
	private Hand player2;
	private int winningComboIndex;
	//permet de connaitre l'Index des Paires (-1 => il n'y a pas de paire)

	public HandComparator(Hand hand1, Hand hand2) {
		this.player1 = hand1;
		this.player2 = hand2;
	}

	public Optional<Hand> getWinner() {
		ArrayList<Combo> tabComboP1=player1.getComboOfThePlayer();
		ArrayList<Combo> tabComboP2=player2.getComboOfThePlayer();
		int i=0;
		Optional<Hand> winner=Optional.empty();
		while (i<tabComboP1.size()) {
			int comboP1 = tabComboP1.get(i).getPriorityValue();
			int comboP2 = tabComboP2.get(i).getPriorityValue();
			if (comboP1 == comboP2) {
				if (comboP1 == 1) {
					winner = checkPaire(i);
					winningComboIndex = i;
				} else if (comboP1 == 2) {
					winner = checkHauteur(i);
					winningComboIndex = i;
				}
			} else if (comboP1 < comboP2) {
				winner=Optional.of(player1);
				winningComboIndex = i;
			} else {
				winner=Optional.of(player2);
				winningComboIndex = i;
			}
			if (winner.isPresent()){
				i=tabComboP1.size();
			}
			i++;
		}
		return(winner);
	}

	private  Optional<Hand> checkHauteur(int hauteurIndex) {
		Optional<Hand> winner = Optional.empty();
		Hauteur player1Hauteur = (Hauteur) player1.getComboOfThePlayer().get(hauteurIndex);
		Hauteur player2Hauteur = (Hauteur) player2.getComboOfThePlayer().get(hauteurIndex);
		return(checkCombo(player1Hauteur.getComboValue(),player2Hauteur.getComboValue()));
	}
	private Optional<Hand> checkPaire(int PaireIndex){
		Optional<Hand> winner = Optional.empty();
		Paire player1Paire=(Paire) player1.getComboOfThePlayer().get(PaireIndex);
		Paire player2Paire=(Paire) player2.getComboOfThePlayer().get(PaireIndex);
		return(checkCombo(player1Paire.getComboValue(),player2Paire.getComboValue()));
	}

	private Optional<Hand> checkCombo(int p1ComboValue,int p2ComboValue){
		Optional<Hand> winner = Optional.empty();
		if (p1ComboValue > p2ComboValue) {
			return winner.of(player1);
		} else if (p1ComboValue == p2ComboValue) {
			return winner.empty();
		}
		else {
			return winner.of(player2);
		}
	}

	public int getWinningComboIndex() {
		return winningComboIndex;
	}
}