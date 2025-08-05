package com.engine;

import static com.engine.PathAndNameEnums.ClassPathEnum.EffectDB;
import static com.io.ConsolePrintHandling.print;
import static com.io.ConsolePrintHandling.println;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.card.Card;
import com.card.component.ArchitypeComponent;
import com.player.Deck;

public abstract class Utils {
	private static Scanner kb = new Scanner(System.in);
	
	private Utils() {}
	
	public static String askUser(String text) {
		println(text);
		print("User: ");
		String input = kb.next();
		kb.nextLine();
		return input;
	}

	public static Card askUserSelection(Card[] selectionList) {
		int i = 0;
		for (Card card : selectionList)
			println(Integer.toString(++i) + " \"" + card.getName() + "\"");
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
				println("Please selected a vailid option.");
		} while (flag);
		println("Card selected: " + Integer.parseInt(slotNumber) + " \""
				+ selectionList[Integer.parseInt(slotNumber) - 1].getName() + "\"");
		return selectionList[Integer.parseInt(slotNumber) - 1];
	}

	public static String concatStringArray(List<String> list) {
		StringBuilder string = new StringBuilder();
		for (String s : list)
			string.append(s);
		return string.toString();
	}

	public static void executeCardEffect(Card targetCard, int effectNum) {
		try {
			targetCard.getBoundClass().getMethod("execute_effect", int.class)
					.invoke(Class.forName(EffectDB.path + targetCard.getName().replace(" ", "0")).getConstructor()
							.newInstance(), effectNum);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException | IllegalArgumentException | InstantiationException e) {
			e.printStackTrace();
		}
	}

	public static Card findCard(int cardIndex) {
		for (Card card : Global.getCardDb())
			if (card.getIndex() == cardIndex)
				return card;
		new RuntimeException("Could not find card matching: " + cardIndex).printStackTrace();
		return null;
	}

	public static Card searchByArchitype(Deck deck, ArchitypeComponent filter) {
		ArrayList<Card> matchedCards = new ArrayList<>();
		deck.getMainDeckList()
				.forEach(potentialCard -> Arrays.asList(potentialCard.getArchitype()).forEach(architype -> {
					if (architype.equals(filter))
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
	
	public static String configurePathToClassName(Path pathToConfigure) {
		return pathToConfigure.toString().replace(".java", "");
	}
}
