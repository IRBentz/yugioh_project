package com.player;

import java.util.ArrayList;
import java.util.List;

import com.card.Card;

public class Deck {
	private ArrayList<Card> extraDeckList;
	private ArrayList<Card> mainDeckList;
	private ArrayList<Card> sideDeckList;

	public Deck() {
		mainDeckList = new ArrayList<>();
		extraDeckList = new ArrayList<>();
		sideDeckList = new ArrayList<>();
	}

	public Deck(List<Card> mainDeckList) {
		this.mainDeckList = (ArrayList<Card>) mainDeckList;
		extraDeckList = new ArrayList<>();
		sideDeckList = new ArrayList<>();
	}

	public Deck(List<Card> main, List<Card> extra) {
		mainDeckList = (ArrayList<Card>) main;
		extraDeckList = (ArrayList<Card>) extra;
		sideDeckList = new ArrayList<>();
	}

	public Deck(List<Card> main, List<Card> extra, List<Card> side) {
		mainDeckList = (ArrayList<Card>) main;
		extraDeckList = (ArrayList<Card>) extra;
		sideDeckList = (ArrayList<Card>) side;
	}

	public List<Card> getExtraDeckList() {
		return extraDeckList;
	}

	public List<Card> getMainDeckList() {
		return mainDeckList;
	}

	public List<Card> getSideDeckList() {
		return sideDeckList;
	}

}
