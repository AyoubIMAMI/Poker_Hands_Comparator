package v1.game_engine;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.Card;
import v1.game_class.Hand;
import v1.game_class.rules_class.Combo;
import v1.game_class.rules_class.Full;
import v1.game_class.rules_class.Hauteur;

public class HandComparator {
	private Hand player1;
	private Hand player2;
	private int winningComboIndex = 0;

	public HandComparator(Hand hand1, Hand hand2) {
		this.player1 = hand1;
		this.player2 = hand2;
	}

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

	private Optional<Hand> anyCombo(Hand mourad1, Hand ayoub2) {
		Optional<Combo> combo1 = mourad1.getComboOfThePlayer();
		Optional<Combo> combo2 = ayoub2.getComboOfThePlayer();

		if (combo1.isPresent() && combo2.isEmpty())
			return Optional.of(mourad1);
		else if (combo2.isPresent() && combo1.isEmpty())
			return Optional.of(ayoub2);
		else
			return Optional.empty();
	}

	private Optional<Hand> whoWhinByPriorityCombo(Combo combo1, Combo combo2) {
		int priorityOfComboP1 = combo1.getPriorityValue();
		int priorityOfComboP2 = combo2.getPriorityValue();

		if (priorityOfComboP1 > priorityOfComboP2) {
			winningComboIndex = 0;
			return Optional.of(player1);
		} else if (priorityOfComboP2 > priorityOfComboP1) {
			winningComboIndex = 0;
			return Optional.of(player2);
		} else if (priorityOfComboP1 == priorityOfComboP2) {
			int valueOfComboP1 = combo1.getComboValue();
			int valueOfComboP2 = combo2.getComboValue();
			 Optional<Hand> potentialWinner = whoWhinByValueCombo(valueOfComboP1, valueOfComboP2);
			 if (potentialWinner.isPresent())
					return potentialWinner;
			else if(combo1.getComboType()==2){
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

	private Optional<Hand> whoWhinByValueCombo(int valueOfComboP1, int valueOfComboP2) {
		if (valueOfComboP1 > valueOfComboP2) {
			winningComboIndex = 0;
			return Optional.of(player1);
		} else if (valueOfComboP2 > valueOfComboP1) {
			winningComboIndex = 0;
			return Optional.of(player2);
		} else
			return Optional.empty();//whoWhinByHauteur(player1, player2);
	}

	private Optional<Hand> whoWhinByHauteur(Hand p1, Hand p2) {
		ArrayList<Card> allNoUsedCardOfPlayer1 = p1.getNoUsedCards();
		ArrayList<Card> allNoUsedCardOfPlayer2 = p2.getNoUsedCards();
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

	private void equalizeSizeOfList(ArrayList<Card> listOne, ArrayList<Card> listeTwo) {
		if (listOne.size() > listeTwo.size()) {
			while (listOne.size() != listeTwo.size())
				listeTwo.add(new Card(0)); // card with value equal to 0 to compute the winner by hauteur next
		} else if (listeTwo.size() > listOne.size()) {
			while (listOne.size() != listeTwo.size())
				listOne.add(new Card(0));
		}
	}

	public int getWinningComboIndex() {
		return winningComboIndex;
	}
}