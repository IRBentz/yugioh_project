package ygo_eng.engine;

import java.util.ArrayList;

import ygo_eng.card.Architype;
import ygo_eng.card.Card;
import ygo_eng.deck.Deck;
import ygo_eng.player.Player;

public abstract class Global {
	public static int back_ver;
	public static ArrayList<Card> card_db = new ArrayList<>();
	public static ArrayList<int[]> fal_list = new ArrayList<>();
	public static Player player = new Player();
	
	public static Card searchCard(Deck deck, Architype filter) {
		ArrayList<Card> matchedCards = new ArrayList<>();
		for(Card potentialCard : deck.getDeckList())
			for(Architype architype : potentialCard.getArchitype())
				if(architype.equals(filter))
					matchedCards.add(potentialCard);
		
		return Backend.askUserSelection(matchedCards);
	}
}
