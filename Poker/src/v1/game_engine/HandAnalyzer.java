package v1.game_engine;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.Card;
import v1.game_class.Hand;
import v1.game_class.rules_class.Combo;
import v1.game_class.rules_class.Hauteur;

class HandAnalyzer {
	private Hand firstHand;
	private ArrayList<Integer> tab;
	private ArrayList<Hauteur> combo;
	
	public HandAnalyzer(Hand newHand1){
		this.firstHand = newHand1;
		this.tab=firstHand.createList();
		this.combo=new ArrayList<>();
	}
	
	//rules
	//Trouve la carte la plus haute de la main
	//Optional<Hand> parceque si la main est déjà vide elle doit pouvoir renvoyer empty.
	private Optional<Hauteur> hauteur(){
		int i=0,len=15,plushaute=-1;

		while (i<len) {
			//On verifie qu'il y a une carte de valeur i
			if (tab.get(i)>0){
				plushaute=i;
				}
			i++;
			}
		if (plushaute>0){
		tab.set(plushaute,tab.get(plushaute)-1);
		Hauteur hauteur =new Hauteur(plushaute);
		return(Optional.of(hauteur));}
		return Optional.empty();
		}

	void analyze(){
		int i=0;
		Optional<Hauteur> loi=hauteur();
		while (loi.isPresent()){
			combo.add(i,loi.get());
			loi=hauteur();
			i++;
		}
	}

	public ArrayList<Hauteur> getCombo() {
		return combo;
	}
}
