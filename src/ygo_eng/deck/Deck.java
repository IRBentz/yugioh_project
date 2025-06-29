package ygo_eng.deck;

import java.util.ArrayList;

import ygo_eng.card.Card;
import ygo_eng.card.EffectTarget;

public class Deck implements EffectTarget {
	private ArrayList<Card> deck_list;
	public Deck() {
		this.deck_list = new ArrayList<>();
	}
	
	public Deck(ArrayList<Card> deck_list) {
		this.deck_list = deck_list;
	}
	
	public ArrayList<Card> getDeckList() {
		return this.deck_list;
	}

	@Override
	public Object getEffectObject() {
		return this;
	}

}
