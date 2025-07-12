package com.player;

import com.card.EffectTarget;

public class Player implements EffectTarget {
	private Banishment banished;
	private Deck deck;
	private Graveyard gy;
	private Hand hand;
	
	public Player() {
		this.hand = new Hand();
		this.deck = new Deck();
		this.gy = new Graveyard();
		this.banished = new Banishment();
	}

	public Banishment getBanished() {
		return this.banished;
	}

	public Deck getDeck() {
		return this.deck;
	}
	
	@Override
	public Object getEffectObject() {
		return this;
	}
	
	public Graveyard getGY() {
		return this.gy;
	}
	
	public Hand getHand() {
		return this.hand;
	}
}
