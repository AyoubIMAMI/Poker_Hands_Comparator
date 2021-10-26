package main;


import java.util.ArrayList;

import game_class.Card;
import game_class.Hand;
import game_engine.Controller;
import game_engine.HandComparator;

/**
 * Main class
 *
 * @author LE BIHAN Léo
 * @author IMAMI Ayoub
 * @author KARRAKCHOU Mourad
 */
public class Main {

	public static void main(String[] args) {
		Controller c = new Controller();
		c.launchGame();
		c.startGame();
	}
}
