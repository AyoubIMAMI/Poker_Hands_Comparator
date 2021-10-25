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

	/**
	 * Create HandAnalyser with a list of card
	 * 
	 * @param cards
	 */
	public HandAnalyzer(ArrayList<Card> cards) {
		this.listCards = cards;
		genTab();
		this.listOfNoUsedCards.addAll(listCards);
	}

	/**
	 * Generate the tab linked to list of cards: <br>
	 * When we got a 2co we add one at index 2; <br>
	 * When we got a 7pi we add one at index 7; <br>
	 * When we got a Aca we add one at index 14; <br>
	 * At the end we increment value of the array at index that match with the value of our cards. <br>
	 * For example : 3ca 3ca 7ca 2pi Aco, with this list of cards we got the tab: <br>
	 * Value: | 0 | 0 | 1 | 2 | 0 | 0 | 0 | 1 | 0 | 0 |  0 |  0 |  0 |  0 |  1 |<br>
	 * Index: | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 |<br>
	 */
	private void genTab() {
		countCardArray = fillTabWith0(countCardArray);
		for (Card aCard : listCards) {
			int indiceValueOfCard = aCard.getValue();
			this.countCardArray[indiceValueOfCard]++;
		}
	}

	/**
	 * @param tab
	 * @return A tab of int fill only with 0
	 */
	private int[] fillTabWith0(int[] tab) {
		for (int i = 0; i < tab.length; i++)
			tab[i] = 0;
		return tab;
	}

	/**
	 * Check in the list of cards of the HandAnalyser if the card with the wanted
	 * value is present and return a list of all cards that has the wanted value.
	 * 
	 * @param ValueofCard
	 * @return A List of cards that match with the wanted card.
	 */
	private ArrayList<Card> findCards(int ValueofCard) {
		ArrayList<Card> cardsToReturn = new ArrayList<Card>();
		for (Card carte : listCards) {
			if (carte.getValue() == ValueofCard)
				cardsToReturn.add(carte);
		}
		return cardsToReturn;
	}

	/**
	 * This method remove update the list of no used card, when we use some cards
	 * we need the remove her from this list.
	 * @param cards
	 * @return Cards that we put in parameter
	 */
	private ArrayList<Card> removeFromNoUsedCards(ArrayList<Card> cards) {
		for (Card aCard : cards) {
			listOfNoUsedCards.remove(aCard);
		}
		return cards;
	}

	
	/**
	 * A hand could have 0, 1 or two combo.
	 * Pair, Three of a Kind, Straight etc. are all Combo.
	 * We separate all the combo inside 3 category: type 1, type 2, type 3 <br>
	 * Type 1: Pair / Brelant / Square <br>
	 * Type 2: Full / Double Pair <br>
	 * Type 3: Quinte <br>
	 * In addition, we have separated Highest and QuinteFlush from other because they are special. <br>
	 * The method use type and the array that count cards, to determine all the combo that the hand has. <br>
	 * @return The list of combo that has the hand.
	 */
	public Optional<Combo> getCombo() {

		ArrayList<Combo> comboList = new ArrayList<Combo>();
		Optional<Combo> type2Combo;
		Optional<Combo> type3Combo;
		Optional<Combo> anyColor;

		// ----- type 3
		type3Combo = findType3();
		if (type3Combo.isPresent()) {
			anyColor = findColor();
			if (anyColor.isPresent())
				return Optional.of(new QuinteFlush(listCards));
			;
			return type3Combo;
		}
		// -----type 1
		for (int i = countCardArray.length - 1; i > 0; i--) {
			Optional<Combo> combo = findType1(countCardArray[i], i);
			if (combo.isPresent())
				comboList.add(combo.get());
		}
		// -----type 2
		type2Combo = findType2(comboList);
		if (type2Combo.isPresent())
			return type2Combo;

		// -----type 1
		if (comboList.size() == 1)
			return Optional.of(comboList.get(0));

		// -----type color
		anyColor = findColor();
		if (anyColor.isPresent())
			return anyColor;

		else
			return Optional.empty();
	}

	/**
	 * Search for type 1 combo in the list of cards
	 * @param numberOfCards
	 * @param valueOfCard
	 * @return A combo with Paire / Brelan / Square or nothing.
	 */
	private Optional<Combo> findType1(int numberOfCards, int valueOfCard) {
		return switch (numberOfCards) {
		case 2 -> Optional.of(new Paire(removeFromNoUsedCards(findCards(valueOfCard))));
		case 3 -> Optional.of(new Brelan(removeFromNoUsedCards(findCards(valueOfCard))));
		case 4 -> Optional.of(new Square(removeFromNoUsedCards(findCards(valueOfCard))));
		default -> Optional.empty();
		};
	}

	
	/**
	 * Search for type 2 combo in the list of type 1 combo
	 * @param listeComboOfType1
	 * @return A combo with Full / DoublePaire or nothing.
	 */
	private Optional<Combo> findType2(ArrayList<Combo> listeComboOfType1) {
		if (listeComboOfType1.size() == 2) {
			if (listeComboOfType1.get(0).getName().equals("Brelan")) {
				return (Optional.of(new Full(listeComboOfType1.get(0), listeComboOfType1.get(1))));
			} else if (listeComboOfType1.get(1).getName().equals("Brelan")) {
				return (Optional.of(new Full(listeComboOfType1.get(1), listeComboOfType1.get(0))));
			} else {
				if (listeComboOfType1.get(0).getComboValue() > listeComboOfType1.get(1).getComboValue()) {
					return (Optional.of(new DoublePaire(listeComboOfType1.get(0), listeComboOfType1.get(1))));
				} else {
					return (Optional.of(new DoublePaire(listeComboOfType1.get(1), listeComboOfType1.get(0))));
				}
			}
		}
		return (Optional.empty());
	}

	
	/**
	 * Search for type 3 combo in the list of cards
	 * @return A combo with a Quinte or nothing
	 */
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

		index = 2;
		while (countCardArray[index] != 1 && index < countCardArray.length - 5)
			index++;
		for (int compteur = index; compteur < index + 5; compteur++) {
			if (countCardArray[compteur] != 1)
				return Optional.empty();

		}
		return Optional.of(new Quinte(this.listCards));
	}

	/**
	 * Check all the card, and if all the cards has the same color (ca / co / pi / tr) return a Flush 
	 * @return a Flush or nothing
	 */
	private Optional<Combo> findColor() {
		String color = listCards.get(0).getColor();
		for (int i = 1; i < listCards.size(); i++) {
			if (!(listCards.get(i).getColor().equals(color)))
				return Optional.empty();
		}
		return Optional.of(new Flush(this.listCards));
	}

	/**
	 * @return the all the cards never used.
	 */
	public ArrayList<Card> getListOfNoUsedCards() {
		return listOfNoUsedCards;
	}
}
