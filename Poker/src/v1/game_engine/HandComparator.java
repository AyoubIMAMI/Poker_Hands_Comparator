package v1.game_engine;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.Card;
import v1.game_class.Hand;
import v1.game_class.rules_class.Combo;
import v1.game_class.rules_class.Hauteur;

/**
 * @author leolb
 *
 */
public class HandComparator {
	private Hand player1;
	private Hand player2;

	/**
	 * @param hand1
	 * @param hand2
	 */
	public HandComparator(Hand hand1, Hand hand2) {
		this.player1 = hand1;
		this.player2 = hand2;
	}

	/**
	 * @return The winner of the game or nothing if it's a draw game.
	 */
	public Optional<Hand> getWinner() {
		Optional<Combo> combo1 = player1.getComboOfThePlayer();
		Optional<Combo> combo2 = player2.getComboOfThePlayer();
		Optional<Hand> potentialWinner;

		if (combo1.isPresent() && combo2.isPresent()) {
			potentialWinner = whoWhinByPriorityCombo(combo1.get(), combo2.get());
			if (potentialWinner.isPresent())
				return potentialWinner;
			return whoWhinByHauteur(player1, player2);
		}
		potentialWinner = anyCombo(player2, player1);
		if (potentialWinner.isPresent())
			return potentialWinner;
		else
			return whoWhinByHauteur(player1, player2);

	}

	/**
	 * As a parameter, we pass 2 hands and at least one of them has no combo. So the
	 * method determines which hand has no combo
	 * 
	 * @param firstHand
	 * @param secondHand
	 * @return The Hand which has a combo or nothing.
	 */
	private Optional<Hand> anyCombo(Hand firstHand, Hand secondHand) {
		Optional<Combo> combo1 = firstHand.getComboOfThePlayer();
		Optional<Combo> combo2 = secondHand.getComboOfThePlayer();

		if (combo1.isPresent() && combo2.isEmpty())
			return Optional.of(firstHand);
		else if (combo2.isPresent() && combo1.isEmpty())
			return Optional.of(secondHand);
		else
			return Optional.empty();
	}

	/**
	 * A combo has a priotity value that we use to determine which combo is the most
	 * powerful.
	 * 
	 * @param combo1
	 * @param combo2
	 * @return The hand we win with the most powerful combo
	 */
	private Optional<Hand> whoWhinByPriorityCombo(Combo combo1, Combo combo2) {
		int priorityOfComboP1 = combo1.getPriorityValue();
		int priorityOfComboP2 = combo2.getPriorityValue();

		if (priorityOfComboP1 > priorityOfComboP2) {
			return Optional.of(player1);
		} else if (priorityOfComboP2 > priorityOfComboP1) {
			return Optional.of(player2);
		} else if (priorityOfComboP1 == priorityOfComboP2) {
			int valueOfComboP1 = combo1.getComboValue();
			int valueOfComboP2 = combo2.getComboValue();
			Optional<Hand> potentialWinner = whoWhinByValueCombo(valueOfComboP1, valueOfComboP2);
			if (potentialWinner.isPresent())
				return potentialWinner;
			else if (combo1.getComboType() == 2) {
				valueOfComboP1 = combo1.getAdditionalcombovalue();
				valueOfComboP2 = combo2.getAdditionalcombovalue();
				potentialWinner = whoWhinByValueCombo(valueOfComboP1, valueOfComboP2);
				if (potentialWinner.isPresent())
					return potentialWinner;
			}
			return whoWhinByHauteur(player2, player1);
		}
		return Optional.empty();
	}

	/**
	 * Two same combo like (two Pair) can be distinguish with he value of the combo.
	 * For example, one Pair of 2 versus an other Pair of 4, it's the Pair of 4
	 * which win
	 * 
	 * @param valueOfComboP1
	 * @param valueOfComboP2
	 * @return The hand which win against the other with only the value of the combo
	 */
	private Optional<Hand> whoWhinByValueCombo(int valueOfComboP1, int valueOfComboP2) {
		if (valueOfComboP1 > valueOfComboP2) {
			return Optional.of(player1);
		} else if (valueOfComboP2 > valueOfComboP1) {
			return Optional.of(player2);
		} else
			return Optional.empty();
	}

	/**
	 * When two player has the same combo with the same value, we can choose the
	 * winner by compare their no used cards and the winner is the hand with the
	 * highest card.
	 * 
	 * @param hand2
	 * @param hand1
	 * @return The hand which win against the other with only their the highest card.
	 */
	private Optional<Hand> whoWhinByHauteur(Hand hand1, Hand hand2) {
		ArrayList<Card> allNoUsedCardOfPlayer1 = hand1.getNoUsedCards();
		ArrayList<Card> allNoUsedCardOfPlayer2 = hand2.getNoUsedCards();
		equalizeSizeOfList(allNoUsedCardOfPlayer1, allNoUsedCardOfPlayer2); // equalize the size of the two list
		int sizeOfList = allNoUsedCardOfPlayer1.size();

		// if(sizeOfList > 0)
		for (int i = sizeOfList - 1; i >= 0; i--) {
			int valueCardPlayer1 = allNoUsedCardOfPlayer1.get(i).getValue();
			int valueCardPlayer2 = allNoUsedCardOfPlayer2.get(i).getValue();

			if (valueCardPlayer1 > valueCardPlayer2) {
				player1.setComboOfThePlayer(Optional.of(new Hauteur(allNoUsedCardOfPlayer1.get(i))));
				return Optional.of(player1);
			} else if (valueCardPlayer1 < valueCardPlayer2) {
				player2.setComboOfThePlayer(Optional.of(new Hauteur(allNoUsedCardOfPlayer2.get(i))));
				return Optional.of(player2);
			}
		}
		return Optional.empty();
	}

	/**
	 * This method take two list of cards and add card with value 0 in order to
	 * equalize the size of the two list.
	 * 
	 * @param listOne
	 * @param listeTwo
	 */
	private void equalizeSizeOfList(ArrayList<Card> listOne, ArrayList<Card> listeTwo) {
		if (listOne.size() > listeTwo.size()) {
			while (listOne.size() != listeTwo.size())
				listeTwo.add(new Card(0)); // card with value equal to 0 to compute the winner by hauteur next
		} else if (listeTwo.size() > listOne.size()) {
			while (listOne.size() != listeTwo.size())
				listOne.add(new Card(0));
		}
	}
}