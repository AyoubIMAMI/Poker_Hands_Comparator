package v1.game_engine;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.Card;
import v1.game_class.rules_class.Brelan;
import v1.game_class.rules_class.Combo;
import v1.game_class.rules_class.Hauteur;
import v1.game_class.rules_class.Paire;

public class HandAnalyzer {
	private ArrayList<Card> listCards;
	private int nbrCarte = 14;
	private int[] countCardArray  = new int[nbrCarte];

	
	public HandAnalyzer() {}
	
	
	private void genTab(){
		countCardArray= fillTabWith0(countCardArray);
		for(Card aCard : listCards) {
			int indiceValueOfCard = aCard.getValue();
			this.countCardArray[indiceValueOfCard]++;
		}
	}
	
	public ArrayList<Combo> getCombo(ArrayList<Card> cards) {
		this.listCards=cards;
		ArrayList<Combo> allCombo = new ArrayList<Combo>();
		genTab();


		//boucle qui cherche les combo, inactive car seul l hauteur a pour l'instant été implémenté
		//for(int i = 0 ; i < countCardArray.length-1 ; i++) {}

		Optional<ArrayList<Card>> brelan=findBrelanValueOfCards();
		if (brelan.isPresent()){
			Brelan theBrelan = new Brelan(brelan.get());
			allCombo.add (theBrelan);}

		Optional<ArrayList<Card>> paire=findPaireValueOfCards();
		if (paire.isPresent()){
		Paire thePaire = new Paire(paire.get());
		allCombo.add (thePaire);}
		Optional<Card> hauteur=findHightValueOfCards();
		if (hauteur.isPresent()){
		Hauteur theHauteur = new Hauteur(findHightValueOfCards().get());
		allCombo.add(theHauteur);}
		return allCombo;
	}

	//------------------------------------------------------------
	private int[] fillTabWith0(int [] tab) {
		for(int i = 0 ; i < tab.length ; i++ )
			tab[i]=0;
		return tab;
	}

	private String printIntTab(int[] tab) {
		String tabString= "[";
		int sizeOfTab = tab.length;
		for(int i = 0 ; i < tab.length-1 ; i++)
			tabString+=tab[i]+", ";
		tabString+= tab[sizeOfTab-1]+" ]";
		return tabString;
	}


	private ArrayList<Card> findCards(int numberOfCard) {
		ArrayList<Card> cardsToReturn = new ArrayList<Card>();
		for(Card carte : listCards){
			if (carte.getValue() == numberOfCard) cardsToReturn.add(carte);
		}
		return cardsToReturn;
	}




	private Optional<Card> findHightValueOfCards() {
		Optional <Card> hightestCard=Optional.empty();
		if (listCards.size()>0) {
			hightestCard = Optional.of(this.listCards.get(this.listCards.size() - 1));// because the cards are sort
		}
		return hightestCard;
	}
	//Cherche si il y a une Pair
	private Optional <ArrayList<Card>> findPaireValueOfCards() {

		for (int i = countCardArray.length - 1; i != 0; i--) {
			if (countCardArray[i] == 2) {
				return Optional.of(findCards(i));
			}
		}
		return Optional.empty();
	}

	//Cherche si il y a une Paire puis la retire
	/*
	private Optional <ArrayList<Card>> findPaireValueOfCards(){
		Optional <ArrayList<Card>> paire=Optional.empty();
		for (int i=0;i<listCards.size()-1;i++){
			if (listCards.get(i).getValue()==listCards.get(i+1).getValue()){
				ArrayList<Card> laPaire= new ArrayList<>();
				laPaire.add(listCards.get(i));
				laPaire.add(listCards.get(i+1));
				paire=Optional.of(laPaire);
				listCards.remove(i+1);
				listCards.remove(i);
				return(paire);
			}
		}
		return(paire);
	}
	 */

	private Optional <ArrayList<Card>> findBrelanValueOfCards() {

		for (int i = countCardArray.length - 1; i != 0; i--) {
			if (countCardArray[i] == 3) {
				return Optional.of(findCards(i));
			}
		}
		return Optional.empty();
	}


	/*private Card findHightValueOfCardsV2() {
	Card hightestCard = this.listCards.get(0);
	for(int i = 0 ; i < this.listCards.size() ; i++) {
		Card currentLoopCard = this.listCards.get(i);
		if(currentLoopCard.getValue() > hightestCard.getValue()) hightestCard = this.listCards.get(i);
	}
	return hightestCard;
}*/
	//------------------------------------------------------------


	//loop on a arrayList of cards, compare i and i++, with i in 0 between size(list)-1
	//private void checkColor() {}


	@Override
	public String toString() {
		return "HandAnalyzer [listCards=" + listCards + ", countCardArray=" + printIntTab(countCardArray) + "]";
	}



}
	/*
	private Hand firstHand;
	private Hand secondHand;
	private ArrayList<Card> winningCard;
	private String winningMethod;

	
	public HandAnalyzer(Hand newHand1, Hand newHand2){
		this.firstHand = newHand1;
		this.secondHand = newHand2;
		winningCard = new ArrayList<Card>();
	}
	
	//rules
	//Check if the two player card and determine which card is better
	//Optional<Hand> because the two player are able to make a draw game when the two card are equal(egality)
	public Optional<Hand> hauteur(){
		ArrayList<Card> scoreP1 = firstHand.getCard();
		ArrayList<Card> scoreP2 = secondHand.getCard();
		int i=0;
		int len=(firstHand.getCard()).size();
		while (i<len) {
			if (scoreP1.get(len-i-1).getValue() > scoreP2.get(len-i-1).getValue()){
				this.winningCard.add(scoreP1.get(len-i-1));
				this.winningMethod="la Hauteur";
				return Optional.of(firstHand);
				}
			else if (scoreP2.get(len-i-1).getValue() > scoreP1.get(len-i-1).getValue()){
				this.winningCard.add(scoreP2.get(len-i-1));
				this.winningMethod="la Hauteur";
				return Optional.of(secondHand);
				}
			i++;
			}
		
		return Optional.empty();
		}
	
	public ArrayList<Card> getWinningCard() {
		return winningCard;
	}

	public String getWinningMethod() {
		return winningMethod;
	}
	
	

}*/
