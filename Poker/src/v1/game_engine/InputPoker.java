package v1.game_engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import v1.game_class.Card;
import v1.game_class.Game;
import v1.game_class.Hand;

//this class manage the input of cards and init the game
public class InputPoker {

	public InputPoker(){}

	//create a game
	public Game init() {
		int nbrCarte= 3;
		Hand hand1 = new Hand("player1", promptCard(nbrCarte));
		Hand hand2 = new Hand("player2", promptCard(nbrCarte));
		return new Game(hand1, hand2);
	}
	
	//catch a user input to create a card
	// accept only numbers between 1 and 13 and only numbers no strings
	@SuppressWarnings("resource")
	public ArrayList<Card> promptCard(int nbrCarte){

		ArrayList<Card> allCard = new ArrayList<Card>();
		Scanner myObj = new Scanner(System.in);
		Scanner myObjC = new Scanner(System.in);

    	System.out.println("Entrer la valeur puis la coulaur des cartes du joueurs:");

		for(int i = 0 ; i < nbrCarte ; i++) {
			int cardValue= 0;
		    while(!(cardValue >0 && cardValue <14)) {

		    	System.out.print("card value: ");

		    	if(!(myObj.hasNextInt())){
		    		printErrorValue();
		    		myObj.next();
		    	}

		    	else {
		    		cardValue = myObj.nextInt();
		    		if(!(cardValue >0 && cardValue <14)) {
			    		printErrorValue();
			    	}
		    	}
	    	}

			System.out.println("Card color:");
			while(!(myObjC.hasNext("Pi") || myObjC.hasNext("Ca") ||myObjC.hasNext("Co") ||myObjC.hasNext("Tr"))){
				printErrorColor();
				System.out.println("Card color:");
				myObjC.next();

			}
			String cardColor = myObjC.next();

			allCard.add(new Card(cardValue, cardColor));
		}
    	System.out.println(""); // \n
		Collections.sort(allCard);
	    return allCard;
	}
	
	private void printErrorValue() {
		System.out.println("");
		System.out.println("Mauvaise valeur entree, la valeur d'une carte est comprise entre 1 et 13!");
	}

	private void printErrorColor() {
		System.out.println("");
		System.out.println("Mauvaise couleur entree, elle doit etre l'une des suivantes : Pi, Ca, Co, Tr");
	}
}
