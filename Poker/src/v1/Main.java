package v1;

import v1.game_engine.Controller;

//main class
public class Main {

	public static void main(String[] args) {
		Controller c = new Controller();
		c.initGame();
		c.startGame();
	}
}
