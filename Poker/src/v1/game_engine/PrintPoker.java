package v1.game_engine;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.Card;
import v1.game_class.Game;
import v1.game_class.Hand;
import v1.game_class.rules_class.Combo;

//the class that manage the output message
public class PrintPoker {
	private Game game;

	public PrintPoker(Game g) {
		this.game = g;
	}

	// print the winner
	// Affiche le Gagnant, comment il a gagné (exemple Hauteur) et avec quelle carte
	// il a gagné (une seule ou plusieurs cartes)
	public String win(Optional<Hand> winner, int winningComboIndex) {
		String result;
		if (!(winner.isPresent())) {
			result = "Egalite";
			System.out.println(result);
			return result;
		} else {
			Hand realWinner = winner.get();// winner est un optional<Hand> et .get() renvoie une Hand si optional
											// contient une Hand
			ArrayList<Combo> realCombo = realWinner.getComboOfThePlayer();
			String winningMethode = realCombo.get(winningComboIndex).getName();
			ArrayList<Card> winningCard = realCombo.get(winningComboIndex).getCardOfCombo();
			if (realCombo.get(winningComboIndex).getCardOfCombo().size() > 1)
				result = "Le joueur " + realWinner.getName() + " a gagne avec " + winningMethode + " et avec les cartes " + winningCard.toString();
			else
				result = "Le joueur " + realWinner.getName() + " a gagne avec " + winningMethode + " et avec la carte " + winningCard.get(0).toString();
			System.out.println(result);
			return result;
		}
	}

	// present the game, the two players and theirs cards
	public void start() {
		System.out.println(game);
	}

}
