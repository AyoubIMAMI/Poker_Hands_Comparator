package v1.game_engine;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.Card;
import v1.game_class.rules_class.*;
import v1.game_class.rules_class.Combo;
import v1.game_class.rules_class.Hauteur;
import v1.game_class.rules_class.Paire;
import v1.game_class.rules_class.Brelan;
import v1.game_class.rules_class.Square;

public class HandAnalyzer {
	private ArrayList<Card> listCards;
	private ArrayList<Card> listOfNoUsedCards = new ArrayList<Card>();

	private int nbrCarte = 14;
	private int[] countCardArray = new int[nbrCarte];

	public HandAnalyzer() {
	}

	private void genTab() {
		countCardArray = fillTabWith0(countCardArray);
		for (Card aCard : listCards) {
			int indiceValueOfCard = aCard.getValue();
			this.countCardArray[indiceValueOfCard]++;
		}
	}

	private int[] fillTabWith0(int[] tab) {
		for (int i = 0; i < tab.length; i++)
			tab[i] = 0;
		return tab;
	}

	private ArrayList<Card> findCards(int numberOfCard) {
		ArrayList<Card> cardsToReturn = new ArrayList<Card>();
		for (Card carte : listCards) {
			if (carte.getValue() == numberOfCard)
				cardsToReturn.add(carte);
		}
		return cardsToReturn;
	}

	private ArrayList<Card> removeFromNoUsedCards(ArrayList<Card> cards) {
		for (Card aCard : cards) {
			listOfNoUsedCards.remove(aCard);
		}
		return cards;
	}

	public ArrayList<Combo> getCombo(ArrayList<Card> cards) {
		this.listCards = cards;
		genTab();
		this.listOfNoUsedCards.addAll(listCards);

		ArrayList<Combo> comboList = new ArrayList<Combo>();
		for (int i = countCardArray.length - 1; i > 0; i--) {
			Optional<Combo> combo = findType1(countCardArray[i], i);
			if (combo.isPresent())
				comboList.add(combo.get());
		}
		Optional<Combo> Type2 = findType2(comboList);
		if (Type2.isPresent()) {
			comboList.remove(0);
			comboList.remove(0);
			comboList.add(Type2.get());
		}
		comboList.add(new Hauteur(new Card(0)));
		return comboList;
	}

	private Optional<Combo> findType1(int numberOfaCard, int valueOfCard) {
		switch (numberOfaCard) {
		case 2:
			return Optional.of(new Paire(removeFromNoUsedCards(findCards(valueOfCard))));

		case 3:
			return Optional.of(new Brelan(removeFromNoUsedCards(findCards(valueOfCard))));

		case 4:
			return Optional.of(new Square(removeFromNoUsedCards(findCards(valueOfCard))));

		default:
			return Optional.empty();
		}
	}

	private Optional<Combo> findType2(ArrayList<Combo> listeCombo) {
		if (listeCombo.size() == 2) {
			if (listeCombo.get(0).getName() == "Brelan") {
				return (Optional.of(new Full(listeCombo.get(0), listeCombo.get(1))));
			} else if (listeCombo.get(1).getName() == "Brelan") {
				return (Optional.of(new Full(listeCombo.get(1), listeCombo.get(0))));
			} else {
				if (listeCombo.get(1).getComboValue() > listeCombo.get(1).getComboValue()) {
					return (Optional.of(new DoublePaire(listeCombo.get(1), listeCombo.get(0))));
				} else {
					return (Optional.of(new DoublePaire(listeCombo.get(1), listeCombo.get(0))));
				}
			}
		}
		return (Optional.empty());
	}

	public ArrayList<Card> getListOfNoUsedCards() {
		return listOfNoUsedCards;
	}
	
}
