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
import com.card.component.LinkArrowComponent;
import com.card.component.TypeComponent;
import com.player.Deck;

import dep.card.enums.CardType;
import dep.card.enums.Icon;
import dep.card.enums.LinkArrow;
import dep.card.enums.MonAttribute;
import dep.card.enums.MonType;
import dep.card.enums.Type;

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
		for(Card card : selectionList)
			inputText += "\t" + Integer.toString(++i) + " \"" + card.getName() + "\"\n";
		String slotNumber = "";
		boolean flag;
		do {
			flag = false;
			slotNumber = askUser("Select 1 of the following cards:\n" + inputText);
			for (char character : slotNumber.toCharArray()) {
				if(!Character.isDigit(character))
					flag = true;
			}
			if(!flag && !(Integer.parseInt(slotNumber) <= i && Integer.parseInt(slotNumber) > 0))
				flag = true;
			if(flag)
				println("Please selected a vailid option.");
		} while (flag);
		println("Card selected: " + Integer.parseInt(slotNumber) + " \"" + selectionList[Integer.parseInt(slotNumber) - 1].getName() + "\"");
		return selectionList[Integer.parseInt(slotNumber) - 1];
	}
	
	public static String concatStringArray(List<String> list) {
		String string = "";
		for(String s : list)
			string += s;
		return string;
	}

	public static void execute_card_effect(Card targetCard, int effect_num) {
		try {
			Class.forName(EffectDB.path + targetCard.getName().replaceAll(" ", "_"))
			.getMethod("execute_effect", int.class)
			.invoke(Class.forName(EffectDB.path + targetCard.getName().replaceAll(" ", "_")), effect_num);
			println("Successfully executed " + targetCard.getName() + "'s effect #" + effect_num);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public static Card findCard(int card_index) {
		for(Card card : card_db)
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

	@Deprecated
	public static Object[] pullBaseStats(Scanner target_scanner) {
		return new Object[] { target_scanner.nextLine(), Integer.parseInt(target_scanner.nextLine())};
	}

	@Deprecated
	public static Object[] pullBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullNextTextBlock(target_scanner, delimiter), target_scanner.nextInt(),
				pullNextTextBlock(target_scanner, delimiter) };
	}
	
	@Deprecated
	public static Object[] pullMonBaseStats(Scanner target_scanner) {
		return new Object[] { pullBaseStats(target_scanner), Utils.stringToMonAttribute(target_scanner.nextLine()),
				Utils.stringToMonType(target_scanner.nextLine()), Utils.pullNextTypeBlock(target_scanner) };
	}
	
	@Deprecated
	public static Object[] pullMonBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullBaseStats(target_scanner, delimiter), stringConvert(target_scanner.next()),
				stringConvert(target_scanner.next()), pullNextTypeBlock(target_scanner, ";"), target_scanner.nextInt(),
				target_scanner.nextInt(), target_scanner.nextInt() };
	}
	
	@Deprecated
	public static LinkArrow[] pullNextLinkArrowBlock(Scanner target_scanner) {
		String[] input = target_scanner.nextLine().split(" ");
		ArrayList<LinkArrow> linkArrow_list = new ArrayList<>();
		for (String in : input) {
			linkArrow_list.add(stringToLinkArrow(in));
		}
		return linkArrow_list.toArray(LinkArrow[]::new);
	}
	
	@Deprecated
	public static LinkArrow[] pullNextLinkArrowBlock(Scanner target_scanner, String delimiter) {
		ArrayList<LinkArrowComponent> linkArrow_list = new ArrayList<>();
		String nextString = target_scanner.next();
		while (!nextString.equals(delimiter)) {
			linkArrow_list.add((LinkArrowComponent) stringConvert(nextString));
			nextString = target_scanner.next();
		}

		return linkArrow_list.toArray(LinkArrow[]::new);
	}
	
	@Deprecated
	public static String pullNextTextBlock(Scanner target_scanner, String delimiter) {
		String nextString = target_scanner.next();
		String return_string = "";
		while (!nextString.equals(delimiter)) {
			return_string += nextString + " ";
			nextString = target_scanner.next();
		}

		return return_string.substring(0, return_string.length() - 1);
	}
	
	@Deprecated
	public static Type[] pullNextTypeBlock(Scanner target_scanner) {
		String[] input = target_scanner.nextLine().split(" ");
		ArrayList<Type> types_list = new ArrayList<>();
		for (String in : input) {
			types_list.add(stringToType(in));
		}
		return types_list.toArray(Type[]::new);
	}

	@Deprecated
	public static Type[] pullNextTypeBlock(Scanner target_scanner, String delimiter) {
		ArrayList<TypeComponent> types_list = new ArrayList<>();
		String nextString = target_scanner.next();
		while (!nextString.equals(delimiter)) {
			types_list.add((TypeComponent) stringConvert(nextString));
			nextString = target_scanner.next();
		}

		return types_list.toArray(Type[]::new);
	}
	
	@Deprecated
	public static Object[] pullSTBaseStats(Scanner target_scanner) {
		return new Object[] { pullBaseStats(target_scanner), target_scanner.nextLine(),
				Utils.stringToIcon(target_scanner.nextLine()) };
	}
	
	@Deprecated
	public static Object[] pullSTBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullBaseStats(target_scanner, delimiter), stringConvert(target_scanner.next()) };
	}
	
	public static Card searchByArchitype(Deck deck, ArchitypeComponent filter) {
		ArrayList<Card> matchedCards = new ArrayList<>();
		deck.getMainDeckList().forEach(potentialCard -> Arrays.asList(potentialCard.getArchitype()).forEach(architype -> {
				if(architype.equals(filter)) 
					matchedCards.add(potentialCard);
				}));
		
		return askUserSelection(matchedCards.toArray(Card[]::new));
	}
	
	public static Card searchByName(Deck deck, String filter) {
		ArrayList<Card> matchedCards = new ArrayList<>();
		deck.getMainDeckList().forEach(potentialCard -> Arrays.asList(potentialCard.getName()).forEach(name -> {
			if(name.contains(filter)) 
				matchedCards.add(potentialCard);
			}));
		
		return askUserSelection(matchedCards.toArray(Card[]::new));
	}
	
	@Deprecated
	public static Object stringConvert(String inputString) {
		for (MonAttribute target_enum : MonAttribute.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		for (MonType target_enum : MonType.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		for (Type target_enum : Type.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		for (CardType target_enum : CardType.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		for (Icon target_enum : Icon.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		for (LinkArrow target_enum : LinkArrow.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		return unfoundEnum(inputString);
	}
	
	@Deprecated
	public static CardType stringToCardType(String inputString) {
		for (CardType target_enum : CardType.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (CardType) unfoundEnum(inputString);
	}

	@Deprecated
	public static Icon stringToIcon(String inputString) {
		for (Icon target_enum : Icon.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (Icon) unfoundEnum(inputString);
	}

	@Deprecated
	public static LinkArrow stringToLinkArrow(String inputString) {
		for (LinkArrow target_enum : LinkArrow.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (LinkArrow) unfoundEnum(inputString);
	}

	@Deprecated
	public static MonAttribute stringToMonAttribute(String inputString) {
		for (MonAttribute target_enum : MonAttribute.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (MonAttribute) unfoundEnum(inputString);
	}
	
	@Deprecated
	public static MonType stringToMonType(String inputString) {
		for (MonType target_enum : MonType.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (MonType) unfoundEnum(inputString);
	}
	
	@Deprecated
	public static Type stringToType(String inputString) {
		for (Type target_enum : Type.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (Type) unfoundEnum(inputString);
	}
	
	@Deprecated
	private static Object unfoundEnum(String inputString) {
		new Error("Enum for \"" + inputString + "\" could not be found.").printStackTrace();
		System.exit(1);
		return null;
	}
	
	public Card getRandomCard(ArrayList<Card> list) {
		return list.get((int) (Math.random() * list.size()));
	}
}
