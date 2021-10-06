package v1;

import java.util.ArrayList;
import java.util.Scanner;

//this class manage the input of cards and init the game
public class InputPoker {
	public InputPoker(){}
	
	//create a game
	public Game init() {
		//add a comment
		int nbrCarte= 2;
		Hand hand1 = new Hand("player1", promptCard(nbrCarte));
		Hand hand2 = new Hand("player2", promptCard(nbrCarte));
		return new Game(hand1, hand2);
	}
	
	//catch a user input to create a card
	public ArrayList<Card> promptCard(int nbrCarte){
		Scanner myObj = new Scanner(System.in);
		ArrayList<Card> allCard = new ArrayList<Card>();
		
		for(int i = 0 ; i < nbrCarte ; i++) {
			int cardValue= 0;
		    while(!(cardValue >0 && cardValue <14)) {
		    	System.out.println("Entrer la valeur de la carte:"); 
		    	cardValue = Integer.parseInt(myObj.nextLine());
		    	if(!(cardValue >0 && cardValue <14))
		    		System.out.println("Mauvaise valeur entree, la valeur d'une carte est comprise entre 1 et 13!");
		    }
		    allCard.add(new Card(cardValue));
		}
	    
	    
	    return allCard;
	}
}
