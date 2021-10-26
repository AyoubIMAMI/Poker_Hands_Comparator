package game_engine;

import java.util.ArrayList;
import java.util.Optional;

import game_class.Card;
import game_class.Game;
import game_class.Hand;
import game_class.rules_class.Combo;

/**
 * This class manages the output messages
 *
 * @author LE BIHAN L�o
 * @author IMAMI Ayoub
 * @author KARRAKCHOU Mourad
 */
public class PrintPoker {

	public PrintPoker() {}

	
	/**
	 * @param winner
	 * @return String, print a text that describes who win and how
	 * 
	 */
	public String win(Optional<Hand> winner) {
		String result;
		if (!(winner.isPresent())) {
			result = "Egalite";
			System.out.println(result);
			return result;
		} else {
			Hand realWinner = winner.get();
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

	/**
	 * @return String, prints and returns an error message when the winner has not been define
	 */
	private String printError() {
		String errorMsg = "Error no winner define";
		System.out.println(errorMsg);
		return errorMsg;
	}

	/**
	 * @return void, introduce the game, the two players and their cards
	 */
	public void start(Game game) {
		System.out.println(game);
	}

	/**
	 * @return void, introduce the rules
	 */
	public void printRules() {
		System.out.println(
				"Pour les valeurs au dessus de 10 (les tetes), on utilise: Valet = V, Dame = D, Rois = R et As = A");
		System.out.println("Pour les couleurs on utilise: ca = carreau, co = coeur, pi = pique, tr = tr�fle");
		System.out.println("Par exemple: 2ca 10ca Aca 2pi 5co");
	}
	
	/**
	 * @return void, print an error message when the user fails to add cards
	 */
	public void printErrorInput() {
		System.out.println(
				"Attention, la valeur d'une carte est comprise entre 1 et 13, deux cartes identiques ne peuvent �tre pr�sentes dans une main, et les couleurs disponibles sont ca = carreau, co = coeur, pi = pique, tr = tr�fle!");
	}

}