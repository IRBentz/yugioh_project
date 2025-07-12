package com.player;

import java.util.ArrayList;

import com.card.Card;

public class Banishment {
	private ArrayList<Card> banished;
	
	public Banishment() {
		this.banished = new ArrayList<>();
	}
	
	public Banishment(ArrayList<Card> banished) {
		this.banished = banished;
	}
	
	public void addCard(Card cardToAdd) {
		this.banished.add(cardToAdd);
	}
	
	public ArrayList<Card> getBanished() {
		return banished;
	}
}
