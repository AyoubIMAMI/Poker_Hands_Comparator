package v1.gameEngine;

import java.util.ArrayList;
import java.util.Optional;

import v1.gameClass.Card;
import v1.gameClass.Game;
import v1.gameClass.Hand;

//the class that manage the output message
public class PrintPoker {
	private Game game;
	
	public PrintPoker(Game g) {
		this.game=g;
	}

	//print the winner
	//Affiche le Gagnant, comment il a gagné (exemple Hauteur) et avec quelle carte il a gagné (une seule ou plusieurs cartes)
	public String win(Optional<Hand> winner, String winningMethode,  ArrayList<Card> winningCard) {
		String result;
		if(!(winner.isPresent())) {
			result = "Egalite";
			System.out.println(result);
			return result;
		}
		else{
			Hand realWinner = winner.get();//winner est un optional<Hand> et .get() renvoie une Hand si optional contient une Hand
			if(winningCard.size() > 1)
				result="Le joueur "+ realWinner.getName()+ " a gagne avec "+winningMethode +" et avec les cartes "+ winningCard.toString();
			else
				result="Le joueur "+ realWinner.getName()+ " a gagne avec "+winningMethode +" et avec la carte "+ winningCard.get(0).toString();
			System.out.println(result);
			return result;
		}
	}
	// present the game, the two players and theirs cards
	public void start(){
		System.out.println(game);
	}
	
}


