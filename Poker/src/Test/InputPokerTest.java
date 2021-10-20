package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import v1.game_class.Card;
import v1.game_class.Game;
import v1.game_class.Hand;
import v1.game_engine.InputPoker;


class InputPokerTest {
	
	
	/*ArrayList<Card> listHand1 = new ArrayList<Card>();
		ArrayList<Card> listHand2 = new ArrayList<Card>();
		
		listHand1.add(new Card(2, "ca"));
		listHand1.add(new Card(2, "co"));
		listHand1.add(new Card(4, "pi"));
		listHand1.add(new Card(5, "tr"));
		listHand1.add(new Card(6, "ca"));
		
		listHand2.add(new Card(2, "ca"));
		listHand2.add(new Card(2, "co"));
		listHand2.add(new Card(4, "pi"));
		listHand2.add(new Card(5, "tr"));
		listHand2.add(new Card(6, "ca"));
		
		Hand hand1 = new Hand("player1", listHand1);
		Hand hand2 = new Hand("player2", listHand2);
		
		Game game1 = new Game(hand1, hand2);*/

	@Test
	void genListCardTest() {
		InputPoker inputPok = new InputPoker();

		
		String line = "2ca 10ca Aca 2pi 5co";
		Optional<ArrayList<Card>> OptionalListOfCard = inputPok.genListCard(line );
		
		assertEquals();
	}

}
