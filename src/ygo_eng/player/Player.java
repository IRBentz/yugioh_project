package ygo_eng.player;

import ygo_eng.card.EffectTarget;
import ygo_eng.deck.Deck;

public class Player implements EffectTarget {
	private Hand hand;
	private Deck deck;
	public Player() {
		this.hand = new Hand();
		this.deck = new Deck();
	}

	@Override
	public Object getEffectObject() {
		return this;
	}

	public Hand getHand() {
		return this.hand;
	}
	
	public Deck getDeck() {
		return this.deck;
	}
}
