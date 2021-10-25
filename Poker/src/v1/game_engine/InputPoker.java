package v1.game_engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;

import v1.game_class.Card;


/**
 * This class manage the input of cards
 */
public class InputPoker {
	int valueOfTheCard = 0;
	int colorOfTheCard = 1;
	PrintPoker printer = new PrintPoker();

	/**
	 * Constructor of InputPoker
	 */
	public InputPoker() {
	}

	/**
	 * @return ArrayList<Card>
	 * Return a sorted list of card
	 */
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
		Collections.sort(listCard);
		return listCard;
	}

	/**
	 * The line contain a description of the list of card, example : 2ca 10ca
	 *              Aca 2pi 5co. <br>
	 * The method check if the line contain only 5 cards well written.
	 * @param line
	 * @return A optional list of card base on the description of the list of cards 
	 */
	public Optional<ArrayList<Card>> genListCard(String line) {
		ArrayList<Card> allCard = new ArrayList<Card>();
		String[] promptValue = line.split(" ");
		
		for (int i = 0; i < promptValue.length; i++) {
			Optional<Card> potentialCard = initCard(promptValue[i]);
			if (potentialCard.isPresent())
				allCard.add(potentialCard.get());
		}
		if (allCard.size() != 5 || twoSameCardPresent(allCard)) {
			printer.printErrorInput();
			return Optional.empty();
		}
		return Optional.of(allCard);
	}

	/**
	 * Use a scanner to catch what the user type
	 * @return a line write by the user
	 */
	@SuppressWarnings("resource")
	private String prompt() {
		Scanner myObj = new Scanner(System.in);
		System.out.print("write a list of cards: ");
		return myObj.nextLine();
	}

	/**
	 * @param allCard, List of cards
	 * @return True if the list of cards contain 2 same cards
	 */
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

	/**
	 * If the card is well written return the card otherwise
	 *         return a Optional.empty(). It's here too that we transform String
	 *         value of Head into their int value.
	 * @param cardDescription, The description of a card like: "5ca" or "Rtr"
	 * @return	A optional card
	 */
	private Optional<Card> initCard(String cardDescription) {
		String value;
		String color;
		int valueOfCard = -1;
		boolean integerOrNot1;
		if (cardDescription.length() == 4) {
			value = cardDescription.substring(0, 2);
			color = cardDescription.substring(2);
		} else if (cardDescription.length() == 3) {
			value = cardDescription.substring(0, 1); 
			color = cardDescription.substring(1);
		} else
			return Optional.empty();

		integerOrNot1 = value.matches("-?\\d+"); 

		if (integerOrNot1 || (valueOfCard = isHead(value)) != -1) {
			if (valueOfCard == -1)
				valueOfCard = Integer.valueOf(value);
			if (color.equals("ca") || color.equals("co") || color.equals("pi") || color.equals("tr"))
				return Optional.of(new Card(valueOfCard, color));
		}

		return Optional.empty();

	}

	/**
	 * Return the int value associated with the heads
	 * @param textCardValue, it's the String value of the card
	 * @return The int value of head
	 */
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

}
