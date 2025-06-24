package ygo_eng.engine;

import java.util.ArrayList;
import java.util.Scanner;

import ygo_eng.card.CardType;
import ygo_eng.card.Icon;
import ygo_eng.card.LinkArrow;
import ygo_eng.card.MonAttribute;
import ygo_eng.card.MonType;
import ygo_eng.card.Type;

public abstract class Utils {
	public static String filterFilePath(String input) {
		if (input.contains("src//ygo_eng//"))
			input = input.replace("src//ygo_eng//", "");
		if (input.contains("card//")) {
			input = input.replace("card//", "");
			if (input.contains("card_png//")) {
				input = input.replace("card_png//", "");
				if (input.contains("link_arrows//"))
					input = input.replace("link_arrows//", "");
				if (input.contains("other//"))
					input = input.replace("other//", "");
				if (input.contains("pend//"))
					input = input.replace("pend//", "pend ");
			}
		}
		if (input.contains("data//"))
			input = input.replace("data//", "");
		if (input.contains("ui//"))
			input = input.replace("ui//", "");
		return input;
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
		ArrayList<LinkArrow> linkArrow_list = new ArrayList<>();
		String nextString = target_scanner.next();
		while (!nextString.equals(delimiter)) {
			linkArrow_list.add((LinkArrow) stringConvert(nextString));
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
		ArrayList<Type> types_list = new ArrayList<>();
		String nextString = target_scanner.next();
		while (!nextString.equals(delimiter)) {
			types_list.add((Type) stringConvert(nextString));
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

	private static Object unfoundEnum(String inputString) {
		new Error("Enum for \"" + inputString + "\" could not be found.").printStackTrace();
		System.exit(1);
		return null;
	}
}
