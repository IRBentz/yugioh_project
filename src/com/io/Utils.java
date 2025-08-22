package com.io;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.card.Card;
import com.card.component.ArchetypeComponent;
import com.engine.Global;
import com.engine.PathAndNameEnums.ClassPath;
import com.player.Deck;

public class Utils {
	private static Scanner kb = new Scanner(System.in);
	private static Logger logger = Logger.getLogger(Utils.class.getName());
	
	protected Utils() {}
	
	public static String askUser(String text) {
		System.out.println(text);
		System.out.print("User: ");
		String input = kb.next();
		kb.nextLine();
		return input;
	}

	public static Card askUserSelection(Card[] selectionList) {
		int i = 0;
		for (Card card : selectionList)
			System.out.println(Integer.toString(++i) + " \"" + card.getName() + "\"");
		String slotNumber = "";
		boolean flag;
		do {
			flag = false;
			slotNumber = askUser("Select 1 of the above cards.");
			for (char character : slotNumber.replaceAll("\\s", "").toCharArray()) {
				if (!Character.isDigit(character))
					flag = true;
			}
			if (!flag && !(Integer.parseInt(slotNumber) <= i && Integer.parseInt(slotNumber) > 0))
				flag = true;
			if (flag)
				System.out.println("Please selected a vailid option.");
		} while (flag);
		System.out.println("Card selected: " + Integer.parseInt(slotNumber) + " \""
				+ selectionList[Integer.parseInt(slotNumber) - 1].getName() + "\"");
		return selectionList[Integer.parseInt(slotNumber) - 1];
	}

	public static void executeCardEffect(Card targetCard, int effectNum) {
		try {
			targetCard.getBoundClass().getMethod("execute_effect", int.class)
					.invoke(Class.forName(ClassPath.EFFECT_DB.path + targetCard.getName().replace(" ", "0")).getConstructor()
							.newInstance(), effectNum);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException | IllegalArgumentException | InstantiationException e) {
			logger.log(Level.SEVERE, "An exception occured.", e);
		}
	}

	public static Card findCard(int cardIndex) {
		for (Card card : Global.getCardDb())
			if (card.getIndex() == cardIndex)
				return card;
		new RuntimeException("Could not find card matching: " + cardIndex).printStackTrace();
		return null;
	}

	public static Card searchByArchetype(Deck deck, ArchetypeComponent filter) {
		ArrayList<Card> matchedCards = new ArrayList<>();
		deck.getMainDeckList()
				.forEach(potentialCard -> Arrays.asList(potentialCard.getArchitype()).forEach(architype -> {
					if (architype == filter)
						matchedCards.add(potentialCard);
				}));

		return askUserSelection(matchedCards.toArray(Card[]::new));
	}

	public static Card searchByName(Deck deck, String filter) {
		ArrayList<Card> matchedCards = new ArrayList<>();
		deck.getMainDeckList().forEach(potentialCard -> Arrays.asList(potentialCard.getName()).forEach(name -> {
			if (name.contains(filter))
				matchedCards.add(potentialCard);
		}));

		return askUserSelection(matchedCards.toArray(Card[]::new));
	}
}
