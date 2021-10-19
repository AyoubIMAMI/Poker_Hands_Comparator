package v1.game_engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import v1.game_class.Card;
import v1.game_class.Game;
import v1.game_class.Hand;

//this class manage the input of cards and init the game
public class InputPoker {
	int valueOfTheCard = 0;
	int colorOfTheCard = 1;

	public InputPoker() {
	}

	// create a game
	public Game init() {
		int nbrCarte = 5;
		Hand hand1 = new Hand("player1", promptCard(nbrCarte));
		Hand hand2 = new Hand("player2", promptCard(nbrCarte));
		return new Game(hand1, hand2);
	}

	// catch a user input to create a card
	// accept only numbers between 1 and 13 and only numbers no strings
	@SuppressWarnings("resource")
	public ArrayList<Card> promptCard(int nbrCarte) {

		ArrayList<Card> allCard = new ArrayList<Card>();
		Scanner myObj = new Scanner(System.in);

		System.out.println(
				"Entrer la valeur (de 2 à 14) puis la couleur des cartes (ca = carreau, co = coeur, pi = pique, tr = trèfle) du joueurs (exemple: 5 pi):");

		for (int i = 0; i < nbrCarte; i++) {
			int cardValue = 0;
			String cardColor = "";

			while (!(cardValue > 1 && cardValue < 15) || !(cardColor.equals("ca") || cardColor.equals("co") || cardColor.equals("pi") || cardColor.equals("tr"))) {
				System.out.print("write a card: ");
				String[] promptValue;
				String onlyDigit = "-?\\d+";
				promptValue = myObj.nextLine().split(" ");
				boolean integerOrNot1 = promptValue[0].matches(onlyDigit); // check si c'est une chaine de caractère

				if (integerOrNot1) {
					cardValue = Integer.valueOf(promptValue[0]);
					if (cardValue > 1 && cardValue < 15 && promptValue.length > 1) {
						cardColor = promptValue[1];
						if (!(cardColor.equals("ca") || cardColor.equals("co") || cardColor.equals("pi") || cardColor.equals("tr")))
							printError();
					} else
						printError();
				} else
					printError();

			}

			allCard.add(new Card(cardValue, cardColor));
		}
		System.out.println(""); // \n
		Collections.sort(allCard);
		return allCard;
	}

	private void printError() {
		System.out.println(
				"Attention, la valeur d'une carte est comprise entre 1 et 13 et les couleurs disponibles sont ca = carreau, co = coeur, pi = pique, tr = trèfle!");
	}

	private void printErrorSameCard() {
		System.out.println("Attention, cette carte est déjà dans la main, veuillez saisir une carte différente");
	}

	private boolean checkSameCard(ArrayList<Card> allCard, Card cardToCheck) {
		for (int i = 0; i < allCard.size(); i++) {
			if (allCard.get(i) == cardToCheck) {
				printErrorSameCard();
				return false;
			}
		}
		return true;
	}

}
