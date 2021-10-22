package v1.game_engine;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.Card;
import v1.game_class.Game;
import v1.game_class.Hand;
import v1.game_class.rules_class.Combo;

//the class that manage the output message
public class PrintPoker {

	public PrintPoker() {}

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
	public void start(Game game) {
		System.out.println(game);
	}

	public void printRules() {
		System.out.println(
				"Pour les valeurs au dessus de 10 (les tetes), on utilise: Valet = V, Dame = D, Rois = R et As = A");
		System.out.println("Pour les couleurs on utilise: ca = carreau, co = coeur, pi = pique, tr = trèfle");
		System.out.println("Par exemple: 2ca 10ca Aca 2pi 5co");
	}
	
	public void printErrorInput() {
		System.out.println(
				"Attention, la valeur d'une carte est comprise entre 1 et 13, deux cartes identiques ne peuvent être présentes dans une main, et les couleurs disponibles sont ca = carreau, co = coeur, pi = pique, tr = trèfle!");
	}

}
