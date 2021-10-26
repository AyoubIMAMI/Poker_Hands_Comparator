package game_engine;

import java.util.ArrayList;
import java.util.Optional;

import game_class.Card;
import game_class.rules_class.*;

/**
 * This class analyze a hand.
 *
 * @author LE BIHAN Léo
 * @author IMAMI Ayoub
 * @author KARRAKCHOU Mourad
 */
public class HandAnalyzer {
	private ArrayList<Card> listCards;
	private ArrayList<Card> listOfNoUsedCards = new ArrayList<Card>();

	private int nbrCarte = 15;
	private int[] countCardArray = new int[nbrCarte];

	/**
	 * Creates HandAnalyzer with a list of cards
	 * 
	 * @param cards
	 */
	public HandAnalyzer(ArrayList<Card> cards) {
		this.listCards = cards;
		genTab();
		this.listOfNoUsedCards.addAll(listCards);
	}

	/**
	 * Generates the tab linked to the list of cards: <br>
	 * When we get a 2co we add one at index 2; <br>
	 * When we get a 7pi we add one at index 7; <br>
	 * When we get a Aca we add one at index 14; <br>
	 * At the end we increment the value of the array at the index that match with the value of our cards. <br>
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
	 * @return A tab of int filled only with 0
	 */
	private int[] fillTabWith0(int[] tab) {
		for (int i = 0; i < tab.length; i++)
			tab[i] = 0;
		return tab;
	}

	/**
	 * Check if the card with the wanted value is present in the list of cards of the HandAnalyser
	 * and returns the list of all cards that have the wanted value.
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
	 * This method updates the list of no used cards, when we use some cards
	 * we need to remove them from this list.
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
	 * A hand can have 0, 1 or two combos.
	 * Pair, Three of a Kind, Straight etc. are all Combo.
	 * We separate all the combos inside 3 categories: type 1, type 2, type 3 <br>
	 * Type 1: Pair / Brelant / Square <br>
	 * Type 2: Full / Double Pair <br>
	 * Type 3: Quinte <br>
	 * In addition, we have separated Highest and QuinteFlush from other because they are special. <br>
	 * The method uses the type and the array that counts cards, to determine all the combos that the hand has. <br>
	 * @return The list of combos that the hand has.
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
	 * Search for type 1 combo in the cards list
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
	 * Search for type 3 combo in the cards list
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
	 * Check all the cards, and if all the cards has the same color (ca / co / pi / tr) return a Flush
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
	 * @return all the cards never used.
	 */
	public ArrayList<Card> getListOfNoUsedCards() {
		return listOfNoUsedCards;
	}
}
