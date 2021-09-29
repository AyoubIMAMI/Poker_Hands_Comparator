package v1;

import java.util.Scanner;

public class InputPoker {
	public InputPoker(){}
	
	
	public Game init() {
		Hand hand1 = new Hand("player1", promptCard());
		Hand hand2 = new Hand("player2", promptCard());
		return new Game(hand1, hand2);
	}
	
	public Card promptCard(){
		Scanner myObj = new Scanner(System.in);
	    int cardValue= 0;
	    
	    while(!(cardValue >0 && cardValue <14)) {
	    	System.out.println("Entrer la valeur de la carte:"); 
	    	cardValue = Integer.parseInt(myObj.nextLine());
	    	if(!(cardValue >0 && cardValue <14))
	    		System.out.println("Mauvaise valeur entree, la valeur d'une carte est comprise entre 1 et 13!");
	    }	    
	    return new Card(cardValue);
	}
}
