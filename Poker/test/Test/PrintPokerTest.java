
package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game_class.Card;
import game_class.Game;
import game_class.Hand;
import game_class.rules_class.Brelan;
import game_class.rules_class.Hauteur;
import game_engine.PrintPoker;

class PrintPokerTest {
	
	//variables
	ArrayList<Card> listCardBrelan;
	Card cardHauteur;
	Hand handBrelan;
	Hand handHauteur;
	PrintPoker printer;

	@BeforeEach
	void init() {		
		//Init PrintPoker
		printer= new PrintPoker();
		//------------------------------------------------
		//Hand With brelan
		listCardBrelan = new ArrayList<Card>();
		ArrayList<Card> listCard2 = new ArrayList<>();
		listCardBrelan.add(new Card(5, "tr"));
		listCardBrelan.add(new Card(5,"ca"));
		listCardBrelan.add(new Card(5,"ca"));
		listCard2.add(new Card(8,"ca"));
		listCard2.add(new Card(2,"ca"));
		listCard2.addAll(listCardBrelan);
		handBrelan=new Hand("player",listCard2);
		Brelan comboBrelan= new Brelan(listCardBrelan);
		handBrelan.setComboOfThePlayer(Optional.of(comboBrelan));
		//Hand with Hauteur
		listCard2 = new ArrayList<>();
		listCard2.add(new Card(2, "tr"));
		listCard2.add(new Card(4,"ca"));
		listCard2.add(new Card(6,"ca"));
		listCard2.add(new Card(8,"ca"));
		cardHauteur = new Card(10,"ca");
		listCard2.add(cardHauteur);
		handHauteur=new Hand("player",listCard2);
		Hauteur comboHauteur= new Hauteur(cardHauteur);
		handHauteur.setComboOfThePlayer(Optional.of(comboHauteur));
	}
	//Optional<Hand> bad;
 
	
	@Test
	//Test with a combo with a number of card>1
	void winTest1() {
		//victory information
		String winningMethod = "Brelan";
		ArrayList<Card> winningCards = new ArrayList<>();
		winningCards.addAll(listCardBrelan);
		
		//------------------------------------------------

		//Test, textWinner contient le resultat qu'est censé renvoyé le PrintPoker
		String textWinner = "Le joueur "+ handBrelan.getName()+ " a gagne avec "+ winningMethod +" et avec les cartes "+ winningCards;
		assertEquals(printer.win(Optional.of(handBrelan)), textWinner);
	}



	@Test
		//Test with a combo with a number of card=1
	void winTest2() {
		//victory information
		String winningMethod = "La Hauteur";
		Card winningCards = cardHauteur;

		//------------------------------------------------

		//Test, textWinner contient le resultat qu'est censé renvoyé le PrintPoker
		String textWinner = "Le joueur "+ handHauteur.getName()+ " a gagne avec "+ winningMethod +" et avec la carte "+ winningCards;
		assertEquals(printer.win(Optional.of(handHauteur)), textWinner);
	}
	@Test
	void winTestEgality() {
		
		
		//Initialisation d'une Optional<Hand> qui est vide
		Optional<Hand> realHand = Optional.empty();
		//------------------------------------------------
		//Test, textWinner contient le resultat qu'est censé renvoyé le PrintPoker
		String textWinner = "Egalite";
		assertEquals(printer.win(realHand), textWinner);
	}
	
	@Test
	void startTest(){
		//String printValue ="";
	}

}
