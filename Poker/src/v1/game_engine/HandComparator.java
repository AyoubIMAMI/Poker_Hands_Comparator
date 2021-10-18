package v1.game_engine;

import java.util.ArrayList;
import java.util.Optional;

import v1.game_class.Card;
import v1.game_class.Hand;
import v1.game_class.rules_class.Combo;
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
		ArrayList<Combo> listComboP1 = player1.getComboOfThePlayer();
		ArrayList<Combo> listComboP2 = player2.getComboOfThePlayer();
		for (int i = 0; i < listComboP1.size() - 1; i++) {
			int priorityOfComboP1 = listComboP1.get(i).getPriorityValue();
			int priorityOfComboP2 = listComboP2.get(i).getPriorityValue();

			if (priorityOfComboP1 > priorityOfComboP2) {
				winningComboIndex = i;
				return Optional.of(player1);
			} else if (priorityOfComboP2 > priorityOfComboP1) {
				winningComboIndex = i;
				return Optional.of(player2);
			} else if (priorityOfComboP1 == priorityOfComboP2) {
				int valueOfComboP1 = listComboP1.get(i).getComboValue();
				int valueOfComboP2 = listComboP2.get(i).getComboValue();

				if (valueOfComboP1 > valueOfComboP2) {
					winningComboIndex = i;
					return Optional.of(player1);
				} else if (valueOfComboP2 > valueOfComboP1) {
					winningComboIndex = i;
					return Optional.of(player2);
				} else
					return whoWhinByHauteur(player1, player2);
			}
		}
		return whoWhinByHauteur(player1, player2);
	}

	private Optional<Hand> whoWhinByHauteur(Hand player1, Hand player2) {
		ArrayList<Card> allNoUsedCardOfPlayer1 = player1.getNoUsedCards();
		ArrayList<Card> allNoUsedCardOfPlayer2 = player2.getNoUsedCards();
		equalizeSizeOfList(allNoUsedCardOfPlayer1, allNoUsedCardOfPlayer2); // equalize the size of the two list
		int sizeOfList = allNoUsedCardOfPlayer1.size();

		for (int i = sizeOfList - 1; i >= 0; i--) {
			int valueCardPlayer1 = allNoUsedCardOfPlayer1.get(i).getValue();
			int valueCardPlayer2 = allNoUsedCardOfPlayer2.get(i).getValue();

			if (valueCardPlayer1 > valueCardPlayer2) {
				player1.getComboOfThePlayer().set(0, new Hauteur(allNoUsedCardOfPlayer1.get(i)));
				return Optional.of(player1);
			} else if (valueCardPlayer1 < valueCardPlayer2) {
				player2.getComboOfThePlayer().set(0, new Hauteur(allNoUsedCardOfPlayer2.get(i)));
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