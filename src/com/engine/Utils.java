package com.engine;

import static com.engine.ClassPathEnum.EffectDB;
import static com.engine.Global.card_db;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.card.Card;
import com.card.component.ArchitypeComponent;
import com.player.Deck;

public abstract class Utils {
	private static Scanner kb = new Scanner(System.in);

	public static String askUser(String text) {
		System.out.println(text);
		String input = kb.next();
		kb.nextLine();
		return input;
	}

	public static Card askUserSelection(Card[] selectionList) {
		String inputText = "";
		int i = 0;
		for (Card card : selectionList)
			inputText += "\t" + Integer.toString(++i) + " \"" + card.getName() + "\"\n";
		String slotNumber = "";
		boolean flag;
		do {
			flag = false;
			slotNumber = askUser("Select 1 of the following cards:\n" + inputText);
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
		String string = "";
		for (String s : list)
			string += s;
		return string;
	}

	public static void execute_card_effect(Card targetCard, int effect_num) {
		try {
			Class.forName(EffectDB.path + targetCard.getName().replaceAll(" ", "_"))
					.getMethod("execute_effect", int.class)
					.invoke(Class.forName(EffectDB.path + targetCard.getName().replaceAll(" ", "_")), effect_num);
			println("Successfully executed " + targetCard.getName() + "'s effect #" + effect_num);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public static Card findCard(int card_index) {
		for (Card card : card_db)
			if (card.getIndex() == card_index)
				return card;
		new RuntimeException("Could not find card matching: " + card_index).printStackTrace();
		return null;
	}

	@SuppressWarnings("unused")
	private static void println() {
		println("");
	}

	private static void println(String stringToPrint) {
		System.out.printf("Utils:\t\t%s", stringToPrint + "\n");
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

	public Card getRandomCardFromList(ArrayList<Card> list) {
		return list.get((int) (Math.random() * list.size()));
	}
}
