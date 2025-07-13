package com.player;

public class Player {
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
	
	public Graveyard getGY() {
		return this.gy;
	}
	
	public Hand getHand() {
		return this.hand;
	}
}
