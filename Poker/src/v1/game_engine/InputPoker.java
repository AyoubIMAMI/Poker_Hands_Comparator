package v1.game_engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
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
		printRules();
		Hand hand1 = new Hand("player1", promptCard());
		Hand hand2 = new Hand("player2", promptCard());
		return new Game(hand1, hand2);
	}

	// catch a user input to create a card
	// accept only numbers between 1 and 13 and only numbers no strings
	@SuppressWarnings("resource")
	public ArrayList<Card> promptCardV1(int nbrCarte) {

		ArrayList<Card> allCard = new ArrayList<Card>();
		Scanner myObj = new Scanner(System.in);

		System.out.println(
				"Entrer la valeur (de 2 à 14) puis la couleur des cartes (ca = carreau, co = coeur, pi = pique, tr = trèfle) du joueurs (exemple: 5 pi):");

		for (int i = 0; i < nbrCarte; i++) {
			int cardValue = 0;
			String cardColor = "";

			while (!(cardValue > 1 && cardValue < 15) || !(cardColor.equals("ca") || cardColor.equals("co")
					|| cardColor.equals("pi") || cardColor.equals("tr"))) {
				String[] promptValue;
				String onlyDigit = "-?\\d+";
				System.out.print("write a card: ");

				promptValue = myObj.nextLine().split(" ");
				boolean integerOrNot1 = promptValue[0].matches(onlyDigit); // check si c'est une chaine de caractère

				if ((cardValue = isHead(promptValue[0])) != -1) {

				}
				if (integerOrNot1) {
					cardValue = Integer.valueOf(promptValue[0]);
					if (cardValue > 1 && cardValue < 15 && promptValue.length > 1) {
						cardColor = promptValue[1];
						if (!(cardColor.equals("ca") || cardColor.equals("co") || cardColor.equals("pi")
								|| cardColor.equals("tr")))
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

	public ArrayList<Card> promptCard() {
		System.out.println("");
		boolean listOfCardIsValid = false;
		ArrayList<Card> listCard = new ArrayList<Card>();
		Optional<ArrayList<Card>> OptionalListCard;
		
		while (listOfCardIsValid != true) {
			listOfCardIsValid = true;
			OptionalListCard = genListCard(prompt());
			if (OptionalListCard.isPresent())
				listCard = OptionalListCard.get();
			else
				listOfCardIsValid = false;
		}
		return listCard;
	}

	private Optional<ArrayList<Card>> genListCard(String line) {
		ArrayList<Card> allCard = new ArrayList<Card>();

		// contient la ligne ou l'on a décrit les cartes
		String[] promptValue = line.split(" ");
		for (int i = 0; i < promptValue.length; i++) {
			Optional<Card> potentialCard = initCard(promptValue[i]);
			if (potentialCard.isPresent())
				allCard.add(potentialCard.get());
		}
		if (allCard.size() != 5 || twoSameCardPresent(allCard)) {
			printError();
			return Optional.empty();
		}
		return Optional.of(allCard);
	}

	@SuppressWarnings("resource")
	private String prompt() {
		Scanner myObj = new Scanner(System.in);
		System.out.print("write a card: ");
		return myObj.nextLine();
	}

	private boolean twoSameCardPresent(ArrayList<Card> allCard) {
		for (int i = 0; i < allCard.size(); i++) {
			Card card1 = allCard.get(i);
			for (int j = i + 1; j < allCard.size(); j++) {
				Card card2 = allCard.get(j);
				if (card1.getValue() == card2.getValue())
					if (card1.getColor().equals(card2.getColor()))
						return true;
			}
		}
		return false;
	}

	private Optional<Card> initCard(String cardDescription) {
		String value;
		String color;
		int valueOfCard = -1;
		boolean integerOrNot1;
		if (cardDescription.length() == 4) {// only one option is value = 10ca for exemple
			value = cardDescription.substring(0, 2); // value 10
			color = cardDescription.substring(2); // color ca
		} else if (cardDescription.length() == 3) { // 7ca for exemple
			value = cardDescription.substring(0, 1); // value 7
			color = cardDescription.substring(1); // color ca
		} else
			return Optional.empty();

		integerOrNot1 = value.matches("-?\\d+"); // check si c'est une chaine de caractère

		if (integerOrNot1 || (valueOfCard = isHead(value)) != -1) {
			if (valueOfCard == -1)
				valueOfCard = Integer.valueOf(value);
			if (color.equals("ca") || color.equals("co") || color.equals("pi") || color.equals("tr"))
				return Optional.of(new Card(valueOfCard, color));
		}

		return Optional.empty();

	}

	private int isHead(String textCardValue) {
		switch (textCardValue) {
		case "V":
			return 11;
		case "D":
			return 12;
		case "R":
			return 13;
		case "A":
			return 14;
		default:
			return -1;
		}
	}

	private void printError() {
		System.out.println(
				"Attention, la valeur d'une carte est comprise entre 1 et 13, deux cartes identiques ne peuvent être présentes dans une main, et les couleurs disponibles sont ca = carreau, co = coeur, pi = pique, tr = trèfle!");
	}

	private void printRules() {
		System.out.println(
				"Pour les valeurs au dessus de 10 (les tetes), on utilise: Valet = V, Dame = D, Rois = R et As = A");
		System.out.println("Pour les couleurs on utilise: ca = carreau, co = coeur, pi = pique, tr = trèfle");
		System.out.println("Par exemple: 2ca 10ca Aca 2pi 5co");
	}
}
