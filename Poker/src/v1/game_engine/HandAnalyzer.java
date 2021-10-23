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

	private int nbrCarte = 15;
	private int[] countCardArray = new int[nbrCarte];

	public HandAnalyzer(ArrayList<Card> cards) {
		this.listCards = cards;
		genTab();
		this.listOfNoUsedCards.addAll(listCards);
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

	private ArrayList<Card> findCards(int ValueofCard) {
		ArrayList<Card> cardsToReturn = new ArrayList<Card>();
		for (Card carte : listCards) {
			if (carte.getValue() == ValueofCard)
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

	public Optional<Combo> getCombo() {
		
		ArrayList<Combo> comboList = new ArrayList<Combo>();
		Optional<Combo> type2Combo;
		Optional<Combo> type3Combo;
        Optional<Combo> anyColor;

		//----- type 3
		type3Combo = findType3();
		if (type3Combo.isPresent())	return type3Combo;
		//-----type 1
		for (int i = countCardArray.length - 1; i > 0; i--) {
			Optional<Combo> combo = findType1(countCardArray[i], i);
			if (combo.isPresent()) comboList.add(combo.get());
		}
		//-----type 2
		type2Combo = findType2(comboList);
		if (type2Combo.isPresent())	return type2Combo;

		//-----type 1
		if (comboList.size() == 1) return Optional.of(comboList.get(0));

		//-----type color
        anyColor = findColor();
        if (anyColor.isPresent()) return anyColor;

		else
			return Optional.empty();
	}

	private Optional<Combo> findType1(int numberOfCards, int valueOfCard) {
        return switch (numberOfCards) {
            case 2 -> Optional.of(new Paire(removeFromNoUsedCards(findCards(valueOfCard))));
            case 3 -> Optional.of(new Brelan(removeFromNoUsedCards(findCards(valueOfCard))));
            case 4 -> Optional.of(new Square(removeFromNoUsedCards(findCards(valueOfCard))));
            default -> Optional.empty();
        };
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

	private Optional<Combo> findType3() {
		int index = 2;
		boolean potentialAsQuinte = true;
		if (countCardArray[countCardArray.length - 1] == 1) {
			for (int compteur = index; compteur < index + 4; compteur++) {
				if (countCardArray[compteur] != 1)
					potentialAsQuinte = false;
			}
			if (potentialAsQuinte)
				return Optional.of(new Quinte(this.listCards));
		}

		index = 0;
		while (countCardArray[index] != 1 && index < countCardArray.length - 5)
			index++;
		for (int compteur = index; compteur < index + 5; compteur++) {
			if (countCardArray[compteur] != 1)
				return Optional.empty();

		}
		return Optional.of(new Quinte(this.listCards));
	}

    public Optional<Combo> findColor() {
        String color = listCards.get(0).getColor();
        for (int i = 1; i < listCards.size(); i++ ) {
            if (!(listCards.get(i).getColor().equals(color))) return Optional.empty();
        }
        return Optional.of(new Flush(this.listCards));
    }

	public ArrayList<Card> getListOfNoUsedCards() {
		return listOfNoUsedCards;
	}
}
