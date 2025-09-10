package com.player;

import java.util.ArrayList;
import java.util.List;

import com.card.Card;

public class Hand {
	private ArrayList<Card> cardsInZone;

	public Hand() {
		cardsInZone = new ArrayList<>();
	}

	public Hand(List<Card> cardsInZone) {
		this.cardsInZone = (ArrayList<Card>) cardsInZone;
	}

	public void addCard(Card cardToAdd) {
		cardsInZone.add(cardToAdd);
	}

	public List<Card> getHand() {
		return cardsInZone;
	}
}
