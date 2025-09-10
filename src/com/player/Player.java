package com.player;

public class Player {
	private Banishment banished;
	private Deck deck;
	private Graveyard gy;
	private Hand hand;

	public Player() {
		hand = new Hand();
		deck = new Deck();
		gy = new Graveyard();
		banished = new Banishment();
	}

	public Banishment getBanished() {
		return banished;
	}

	public Deck getDeck() {
		return deck;
	}

	public Graveyard getGY() {
		return gy;
	}

	public Hand getHand() {
		return hand;
	}
}
