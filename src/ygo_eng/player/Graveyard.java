package ygo_eng.player;

import java.util.ArrayList;

import ygo_eng.card.Card;

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
