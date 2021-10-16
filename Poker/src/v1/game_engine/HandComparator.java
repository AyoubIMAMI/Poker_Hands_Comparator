package v1.game_engine;

import java.util.Optional;

import v1.game_class.Hand;
import v1.game_class.rules_class.Hauteur;

public class HandComparator {
	private Hand player1;
	private Hand player2;
	private final int hauteurIndex = 0;

	public HandComparator(Hand hand1, Hand hand2) {
		this.player1 = hand1;
		this.player2 = hand2;
	}

	public Optional<Hand> getWinner() {
		Optional<Hand> winner = checkHauteur();
		return winner;
	}

	private  Optional<Hand> checkHauteur() {
		Optional<Hand> winner = Optional.empty();
		Hauteur player1Hauteur = (Hauteur) player1.getComboOfThePlayer().get(hauteurIndex);
		Hauteur player2Hauteur = (Hauteur) player2.getComboOfThePlayer().get(hauteurIndex);

		if (player1Hauteur.getHauteur() > player2Hauteur.getHauteur()) {
			return winner.of(player1);
		} else if (player1Hauteur.getHauteur() == player2Hauteur.getHauteur()) {
			return winner.empty();
		}

		else {
			return winner.of(player2);
		}
	}

}