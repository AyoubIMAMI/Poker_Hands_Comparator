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
	public String win(Optional<Hand> winner) {
		String result;
		if (!(winner.isPresent())) {
			result = "Egalite";
			System.out.println(result);
			return result;
		} else {
			Hand realWinner = winner.get();// winner est un optional<Hand> et .get() renvoie une Hand si optional
											// contient une Hand
			if (realWinner.getComboOfThePlayer().isPresent()) {
				Combo realCombo = realWinner.getComboOfThePlayer().get();	
				String winningMethode = realCombo.getName();
				ArrayList<Card> winningCard = realCombo.getCardOfCombo();
				if (realCombo.getCardOfCombo().size() > 1)
					result = "Le joueur " + realWinner.getName() + " a gagne avec " + winningMethode + " et avec les cartes " + winningCard.toString();
				else
					result = "Le joueur " + realWinner.getName() + " a gagne avec " + winningMethode + " et avec la carte " + winningCard.get(0).toString();
				System.out.println(result);
				return result;
			}	
		}
		return printError();
	}

	private String printError() {
		
		return "Error no winner define";
	}

	// present the game, the two players and theirs cards
	public void start() {
		System.out.println(game);
	}

}
