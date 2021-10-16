package v1;

import v1.game_class.Card;
import v1.game_class.Hand;

import v1.game_engine.Controller;
import v1.game_engine.HandComparator;

import java.util.ArrayList;


//main class
public class Main {

	public static void main(String[] args) {
		Controller c = new Controller();
		c.initGame();
		c.startGame();
		/*Card carte1=new Card(4);
		Card carte2=new Card(6);
		Card carte3=new Card(3);
		Card carte4=new Card(3);
		ArrayList<Card> tabcarte1= new ArrayList<>();
		ArrayList<Card> tabcarte2= new ArrayList<>();
		tabcarte1.add(carte1);
		tabcarte1.add(carte2);
		tabcarte2.add(carte3);
		tabcarte2.add(carte4);
		Hand hand1= new Hand("Player1",tabcarte1);
		Hand hand2= new Hand("Player2",tabcarte2);
		HandComparator compare=new HandComparator(hand1,hand2);*/

	}
}
