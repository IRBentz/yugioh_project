package com.player;

import java.util.ArrayList;
import java.util.List;

import com.card.Card;

public class Deck {
	private ArrayList<Card> extraDeckList;
	private ArrayList<Card> mainDeckList;
	private ArrayList<Card> sideDeckList;
	public Deck() {
		this.mainDeckList = new ArrayList<>();
		this.extraDeckList = new ArrayList<>();
		this.sideDeckList = new ArrayList<>();
	}
	
	public Deck(List<Card> mainDeckList) {
		this.mainDeckList = (ArrayList<Card>) mainDeckList;
		this.extraDeckList = new ArrayList<>();
		this.sideDeckList = new ArrayList<>();
	}
	
	public Deck(List<Card> main, List<Card> extra) {	
		this.mainDeckList = (ArrayList<Card>) main;
		this.extraDeckList = (ArrayList<Card>) extra;
		this.sideDeckList = new ArrayList<>();
	}
	
	public Deck(List<Card> main, List<Card> extra, List<Card> side) {
		this.mainDeckList = (ArrayList<Card>) main;
		this.extraDeckList = (ArrayList<Card>) extra;
		this.sideDeckList = (ArrayList<Card>) side;
	}
	
	public List<Card> getExtraDeckList() {
		return this.extraDeckList;
	}
	
	public List<Card> getMainDeckList() {
		return this.mainDeckList;
	}

	public List<Card> getSideDeckList() {
		return this.sideDeckList;
	}

}
