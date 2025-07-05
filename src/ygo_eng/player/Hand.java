package ygo_eng.player;

import java.util.ArrayList;
import ygo_eng.card.Card;


public class Hand {
	private ArrayList<Card> hand;
	
	public Hand() {
		this.hand = new ArrayList<>();
	}
	
	public Hand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public void addCard(Card cardToAdd) {
		this.hand.add(cardToAdd);
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
}
