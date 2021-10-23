package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import v1.game_class.Card;
import v1.game_class.Game;
import v1.game_class.Hand;
import v1.game_engine.Controller;
import v1.game_engine.InputPoker;

public class ControllerTest {

	ArrayList<Card> listHand1 = new ArrayList<Card>();
	ArrayList<Card> listHand2 = new ArrayList<Card>();
	Game game1;
	Hand hand1;
	Hand hand2;
	InputPoker inputPok;
	Controller control;

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

		hand1 = new Hand("player1", listHand1);
		hand2 = new Hand("player2", listHand2);
		game1 = new Game(hand1, hand2);
		inputPok = new InputPoker();
		control = new Controller();

	}
	
	@Test
	void initGameTest() {
		assertEquals(game1, control.createGame(listHand1, listHand2));
	}
	

	
}
