package com.player;

import java.util.ArrayList;
import java.util.List;

import com.card.Card;

public class Banishment {
	private ArrayList<Card> banished;
	
	public Banishment() {
		this.banished = new ArrayList<>();
	}
	
	public Banishment(List<Card> banished) {
		this.banished = (ArrayList<Card>) banished;
	}
	
	public void addCard(Card cardToAdd) {
		this.banished.add(cardToAdd);
	}
	
	public List<Card> getBanished() {
		return banished;
	}
}
