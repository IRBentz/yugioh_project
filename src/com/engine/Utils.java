package com.engine;

import static com.engine.Global.EFFECT_CLASS_HEADER;
import static com.engine.Global.card_db;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

import com.card.enums.Architype;
import com.card.Card;
import com.card.component.ArchitypeComponent;
import com.card.component.CardComponent;
import com.card.component.CardComponentInterface;
import com.card.component.CardSubcomponentInterface;
import com.card.component.LinkArrowComponent;
import com.card.component.TypeComponent;
import com.card.enums.CardType;
import com.card.enums.Icon;
import com.card.enums.LinkArrow;
import com.card.enums.MonAttribute;
import com.card.enums.MonType;
import com.card.enums.Type;
import com.player.Deck;

public abstract class Utils {
	public static Card askUserSelection(ArrayList<Card> selectionList) {
		String inputText = "";
		int i = 0;
		for(Card card : selectionList)
			inputText += "\t" + Integer.toString(i++) + " " + card.getName() + "\n";
		Character slotNumber = ' ';
		while(!Character.isDigit(slotNumber))
			slotNumber = askUser("Select 1 of the following cards:\n" + inputText);
		println("Card selected: " + Integer.parseInt(slotNumber.toString()) + " " + selectionList.get(Integer.parseInt(slotNumber.toString())).getName());
		return selectionList.get(Integer.parseInt(slotNumber.toString()));
	}
	
	public static Character askUser(String text) {
		Scanner kb = new Scanner(System.in);
		System.out.println(text);
		String input = kb.next();
		kb.close();
		
		return input.charAt(0);
	}

	public static void execute_card_effect(Card targetCard, int effect_num) {
		try {
			Class.forName(EFFECT_CLASS_HEADER + targetCard.getName().replaceAll(" ", "_")).getMethod("execute_effect", int.class).invoke(Object.class, effect_num);
			println("Successfully executed " + targetCard.getName() + "'s effect #" + effect_num);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Card findCard(int card_index) {
		for(Card card : card_db)
			if (card.getIndex() == card_index)
				return card;
		new Error("Could not find card matching: " + card_index).printStackTrace();
		return null;
	}

	private static void println(String stringToPrint) {
		System.out.printf("Utils:\t\t%s", stringToPrint + "\n");
	}

	public static Object[] pullBaseStats(Scanner target_scanner) {
		return new Object[] { target_scanner.nextLine(), Integer.parseInt(target_scanner.nextLine()), };
	}

	public static Object[] pullBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullNextTextBlock(target_scanner, delimiter), target_scanner.nextInt(),
				pullNextTextBlock(target_scanner, delimiter) };
	}

	public static Object[] pullMonBaseStats(Scanner target_scanner) {
		return new Object[] { pullBaseStats(target_scanner), Utils.stringToMonAttribute(target_scanner.nextLine()),
				Utils.stringToMonType(target_scanner.nextLine()), Utils.pullNextTypeBlock(target_scanner) };
	}

	public static Object[] pullMonBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullBaseStats(target_scanner, delimiter), stringConvert(target_scanner.next()),
				stringConvert(target_scanner.next()), pullNextTypeBlock(target_scanner, ";"), target_scanner.nextInt(),
				target_scanner.nextInt(), target_scanner.nextInt() };
	}
	public static LinkArrow[] pullNextLinkArrowBlock(Scanner target_scanner) {
		String[] input = target_scanner.nextLine().split(" ");
		ArrayList<LinkArrow> linkArrow_list = new ArrayList<>();
		for (String in : input) {
			linkArrow_list.add(stringToLinkArrow(in));
		}
		return linkArrow_list.toArray(LinkArrow[]::new);
	}

	public static LinkArrow[] pullNextLinkArrowBlock(Scanner target_scanner, String delimiter) {
		ArrayList<LinkArrowComponent> linkArrow_list = new ArrayList<>();
		String nextString = target_scanner.next();
		while (!nextString.equals(delimiter)) {
			linkArrow_list.add((LinkArrowComponent) stringConvert(nextString));
			nextString = target_scanner.next();
		}

		return linkArrow_list.toArray(LinkArrow[]::new);
	}

	public static String pullNextTextBlock(Scanner target_scanner, String delimiter) {
		String nextString = target_scanner.next();
		String return_string = "";
		while (!nextString.equals(delimiter)) {
			return_string += nextString + " ";
			nextString = target_scanner.next();
		}

		return return_string.substring(0, return_string.length() - 1);
	}

	public static Type[] pullNextTypeBlock(Scanner target_scanner) {
		String[] input = target_scanner.nextLine().split(" ");
		ArrayList<Type> types_list = new ArrayList<>();
		for (String in : input) {
			types_list.add(stringToType(in));
		}
		return types_list.toArray(Type[]::new);
	}

	public static Type[] pullNextTypeBlock(Scanner target_scanner, String delimiter) {
		ArrayList<TypeComponent> types_list = new ArrayList<>();
		String nextString = target_scanner.next();
		while (!nextString.equals(delimiter)) {
			types_list.add((TypeComponent) stringConvert(nextString));
			nextString = target_scanner.next();
		}

		return types_list.toArray(Type[]::new);
	}

	public static Object[] pullSTBaseStats(Scanner target_scanner) {
		return new Object[] { pullBaseStats(target_scanner), target_scanner.nextLine(),
				Utils.stringToIcon(target_scanner.nextLine()) };
	}

	public static Object[] pullSTBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullBaseStats(target_scanner, delimiter), stringConvert(target_scanner.next()) };
	}

	public static Card search(Deck deck, ArchitypeComponent filter) {
		ArrayList<Card> matchedCards = new ArrayList<>();
		for(Card potentialCard : deck.getMainDeckList())
			for(ArchitypeComponent architype : potentialCard.getArchitype())
				if(architype.equals(filter))
					matchedCards.add(potentialCard);
		
		return askUserSelection(matchedCards);
	}

	public static Card search(Deck deck, String name) {
		ArrayList<Card> matchedCards = new ArrayList<>();
		for(Card potentialCard : deck.getMainDeckList())
			if(potentialCard.getName().contains(name))
				matchedCards.add(potentialCard);
		return askUserSelection(matchedCards);
	}
	
	
	public static CardComponentInterface stringConvert(String inputString) {
		try {
		for(CardComponent component : CardComponent.class.getEnumConstants())
			for (CardSubcomponentInterface subcomponent : (CardSubcomponentInterface[]) Class.forName("com.card.component." + component.name() + "Component").getEnumConstants())
				if (subcomponent.match(inputString) != null)
					return subcomponent.match(inputString);
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (CardComponentInterface) unfoundEnum(inputString);
	}
	
	/*
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
	*/

	public static CardType stringToCardType(String inputString) {
		for (CardType target_enum : CardType.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (CardType) unfoundEnum(inputString);
	}

	public static Icon stringToIcon(String inputString) {
		for (Icon target_enum : Icon.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (Icon) unfoundEnum(inputString);
	}

	public static LinkArrow stringToLinkArrow(String inputString) {
		for (LinkArrow target_enum : LinkArrow.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (LinkArrow) unfoundEnum(inputString);
	}
	
	public static LinkArrowComponent[] stringToLinkArrowArray(String target_string) {
		String[] target_strings = target_string.split(" ");
		ArrayList<LinkArrowComponent> types_list = new ArrayList<>();
		for (String in : target_strings) {
			types_list.add((LinkArrowComponent) stringConvert(in));
		}
		return types_list.toArray(LinkArrowComponent[]::new);
	}
	
	public static MonAttribute stringToMonAttribute(String inputString) {
		for (MonAttribute target_enum : MonAttribute.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (MonAttribute) unfoundEnum(inputString);
	}
	
	public static MonType stringToMonType(String inputString) {
		for (MonType target_enum : MonType.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (MonType) unfoundEnum(inputString);
	}
	
	public static Type stringToType(String inputString) {
		for (Type target_enum : Type.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;
		return (Type) unfoundEnum(inputString);
	}
	
	public static TypeComponent[] stringToTypeArray(String target_string) {
		String[] target_strings = target_string.split(" ");
		ArrayList<TypeComponent> types_list = new ArrayList<>();
		for (String in : target_strings) {
			types_list.add((TypeComponent) stringConvert(in));
		}
		return types_list.toArray(TypeComponent[]::new);
	}
	
	private static Object unfoundEnum(String inputString) {
		new Error("Enum for \"" + inputString + "\" could not be found.").printStackTrace();
		System.exit(1);
		return null;
	}
	
	public Card getRandomCard(ArrayList<Card> list) {
		return list.get((int) (Math.random() * list.size()));
	}
}
