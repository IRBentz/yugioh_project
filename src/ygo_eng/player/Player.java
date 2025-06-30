package ygo_eng.player;

import ygo_eng.card.EffectTarget;

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
