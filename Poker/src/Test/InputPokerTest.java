package Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import v1.game_class.Card;
import v1.game_class.Game;
import v1.game_class.Hand;
import v1.game_engine.InputPoker;

class InputPokerTest {

	ArrayList<Card> listHand1 = new ArrayList<Card>();
	ArrayList<Card> listHand2 = new ArrayList<Card>();
	InputPoker inputPok;

	@BeforeEach
	void init() {
		listHand1.add(new Card(2, "ca"));
		listHand1.add(new Card(2, "co"));
		listHand1.add(new Card(4, "pi"));
		listHand1.add(new Card(10, "tr"));
		listHand1.add(new Card(12, "ca"));

		listHand2.add(new Card(2, "ca"));
		listHand2.add(new Card(2, "co"));
		listHand2.add(new Card(4, "pi"));
		listHand2.add(new Card(10, "tr"));
		listHand2.add(new Card(12, "ca"));

		Hand hand1 = new Hand("player1", listHand1);
		Hand hand2 = new Hand("player2", listHand2);

		Game game1 = new Game(hand1, hand2);
		inputPok = new InputPoker();

	}

	@Test
	void genListCardTest() {
		String line = "2ca 2co 4pi 10tr 12ca";
		Optional<ArrayList<Card>> OptionalListOfCard = inputPok.genListCard(line);
		assertTrue(OptionalListOfCard.isPresent());
		ArrayList<Card> resListCard = OptionalListOfCard.get();
		for (int i = 0; i < resListCard.size(); i++)
			assertTrue(resListCard.get(i).equals(listHand1.get(i)));}
	
	@Test
	void genListCardBadListTesy() {
		String line = "2ca 2co 4pi 10tr 12ca 6co";
		Optional<ArrayList<Card>> OptionalListOfCard = inputPok.genListCard(line);
		assertTrue(!OptionalListOfCard.isPresent());
		
		line = "2ca 2co 4pi 10tr";
		OptionalListOfCard = inputPok.genListCard(line);
		assertTrue(!OptionalListOfCard.isPresent());
		
		line = "2ca 2co 4pi 10tr 415ca";
		OptionalListOfCard = inputPok.genListCard(line);
		assertTrue(!OptionalListOfCard.isPresent());
		
		line = "2ca 2co 4pi 10tr chevalca";
		OptionalListOfCard = inputPok.genListCard(line);
		assertTrue(!OptionalListOfCard.isPresent());
		
		line = "2ca 2co 4pi 10tr 4couleurs";
		OptionalListOfCard = inputPok.genListCard(line);
		assertTrue(!OptionalListOfCard.isPresent());
	}
	

	@Test
	void initTest() {
		Game aGame = new Game(new Hand("player1", listHand1), new Hand("player2", listHand2));
		assertEquals(inputPok.init(listHand1, listHand2), aGame);
	}

}
