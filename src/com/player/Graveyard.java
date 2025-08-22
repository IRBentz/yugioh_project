package com.player;

import java.util.ArrayList;
import java.util.List;

import com.card.Card;

public class Graveyard {
	private ArrayList<Card> gy;
	
	public Graveyard() {
		this.gy = new ArrayList<>();
	}
	
	public Graveyard(List<Card> gy) {
		this.gy = (ArrayList<Card>) gy;
	}
	
	public void addCard(Card cardToAdd) {
		this.gy.add(cardToAdd);
	}
	
	public List<Card> getGy() {
		return gy;
	}
}
