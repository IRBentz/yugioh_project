package com.player;

import java.util.ArrayList;

import com.card.Card;

public class Graveyard {
	private ArrayList<Card> gy;
	
	public Graveyard() {
		this.gy = new ArrayList<>();
	}
	
	public Graveyard(ArrayList<Card> gy) {
		this.gy = gy;
	}
	
	public void addCard(Card cardToAdd) {
		this.gy.add(cardToAdd);
	}
	
	public ArrayList<Card> getGy() {
		return gy;
	}
}
