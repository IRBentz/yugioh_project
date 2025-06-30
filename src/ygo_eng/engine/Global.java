package ygo_eng.engine;

import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;

import ygo_eng.card.Architype;
import ygo_eng.card.Card;
import ygo_eng.deck.Deck;
import ygo_eng.player.Player;

public abstract class Global {
	public static int back_ver;
	public static ArrayList<Card> card_db = new ArrayList<>();
	public static ArrayList<int[]> fal_list = new ArrayList<>();
	public static Player player = new Player();
	public static final String EFFECT_CLASS_HEADER = "ygo_eng.db.effect_db.";
	
	public static Card search(Deck deck, Architype filter) {
		ArrayList<Card> matchedCards = new ArrayList<>();
		for(Card potentialCard : deck.getDeckList())
			for(Architype architype : potentialCard.getArchitype())
				if(architype.equals(filter))
					matchedCards.add(potentialCard);
		
		return Backend.askUserSelection(matchedCards);
	}
	
	public static Card search(Deck deck, String name) {
		ArrayList<Card> matchedCards = new ArrayList<>();
		for(Card potentialCard : deck.getDeckList())
			if(potentialCard.getName().contains(name))
				matchedCards.add(potentialCard);
		new Error("Could not find cards containing: " + name).printStackTrace();
		return null;
	}
	
	public static void execute_card_effect(Card targetCard, int effect_num) {
		try {
			Class.forName(EFFECT_CLASS_HEADER + targetCard.getName().replaceAll(" ", "_")).getMethod("execute_effect", int.class).invoke(Object.class, effect_num);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
