
package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import v1.game_class.Card;
import v1.game_class.Game;
import v1.game_class.Hand;
import v1.game_class.rules_class.Brelan;
import v1.game_engine.PrintPoker;

class PrintPokerTest {
	
	//variables
	ArrayList<Card> listCard1;
	Hand handBrelan;
	PrintPoker printer;
	Game myGame;

	@BeforeEach
	void init() {		
		//Init PrintPoker
		//------------------------------------------------
		//Hand With brelan (we don't need a real brelan to test print)
		listCard1 = new ArrayList<Card>();
		listCard1.add(new Card(5,"Tr"));
		Hand handBrelan= new Hand("P1",listCard1);
		Brelan comboBrelan= new Brelan(listCard1);
		handBrelan.setComboOfThePlayer(Optional.of(comboBrelan));

	}
	//Optional<Hand> bad;
 
	
	@Test
	void winTestRealHand() {
		//Initialisation d'une main
		//------------------------------------------------
		ArrayList<Card> listCard = new ArrayList<Card>();
		listCard.add(new Card(5));
		listCard.add(new Card(2));
		listCard.add(new Card(8));
		Hand myHand = new Hand("player", listCard);
		
		//Initialisation d'une Optional<Hand> qui contient myHand
		Optional<Hand> realHand = Optional.of(myHand);
		
		//victory information
		String winningMethod = "la Hauteur";
		ArrayList<Card> winningCards = new ArrayList<Card>();
		winningCards.add(new Card(8));

		
		//------------------------------------------------

		//Test, textWinner contient le resultat qu'est censé renvoyé le PrintPoker
		String textWinner = "Le joueur "+ myHand.getName()+ " a gagne avec "+ winningMethod +" et avec la carte "+ winningCards.get(0).getValue();
		assertEquals(printer.win(realHand, winningMethod, winningCards), textWinner);
	}
	
	@Test
	void winTestRealHandTwoCards() {
		//Initialisation d'une main
		//------------------------------------------------
		ArrayList<Card> listCard = new ArrayList<Card>();
		listCard.add(new Card(5));
		listCard.add(new Card(2));
		listCard.add(new Card(8));

		Hand myHand = new Hand("player", listCard);
		
		//Initialisation d'une Optional<Hand> qui contient myHand
		Optional<Hand> realHand = Optional.of(myHand);
		
		//victory information
		String winningMethod = "la Hauteur";
		ArrayList<Card> winningCards = new ArrayList<Card>();
		winningCards.add(new Card(8));
		winningCards.add(new Card(5));


		
		//------------------------------------------------

		//Test, textWinner contient le resultat qu'est censé renvoyé le PrintPoker
		String textWinner = "Le joueur "+ myHand.getName()+ " a gagne avec "+ winningMethod +" et avec les cartes "+ winningCards.toString();
		assertEquals(printer.win(realHand, winningMethod, winningCards), textWinner);
	}
	
	@Test
	void winTestEgality() {
		
		
		//Initialisation d'une Optional<Hand> qui contient myHand
		Optional<Hand> realHand = Optional.empty();
		String winningMethod = null;
		ArrayList<Card> winningCards = new ArrayList<Card>();
		
		
		//------------------------------------------------

		//Test, textWinner contient le resultat qu'est censé renvoyé le PrintPoker
		String textWinner = "Egalite";
		assertEquals(printer.win(realHand, winningMethod, winningCards), textWinner);
	}
	
	@Test
	void startTest(){
		//String printValue ="";
	}

}
