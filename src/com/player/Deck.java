package com.player;

import java.util.ArrayList;

import com.card.Card;
import com.card.EffectTarget;

public class Deck implements EffectTarget {
	private ArrayList<Card> extra_deck_list;
	private ArrayList<Card> main_deck_list;
	private ArrayList<Card> side_deck_list;
	public Deck() {
		this.main_deck_list = new ArrayList<>();
		this.extra_deck_list = new ArrayList<>();
		this.side_deck_list = new ArrayList<>();
	}
	
	public Deck(ArrayList<Card> main_deck_list) {
		this.main_deck_list = main_deck_list;
		this.extra_deck_list = new ArrayList<>();
		this.side_deck_list = new ArrayList<>();
	}
	
	public Deck(ArrayList<Card> main, ArrayList<Card> extra) {	
		this.main_deck_list = main;
		this.extra_deck_list = extra;
		this.side_deck_list = new ArrayList<>();
	}
	
	public Deck(ArrayList<Card> main, ArrayList<Card> extra, ArrayList<Card> side) {
		this.main_deck_list = main;
		this.extra_deck_list = extra;
		this.side_deck_list = side;
	}
	
	@Override
	public Object getEffectObject() {
		return this;
	}
	
	public ArrayList<Card> getExtraDeckList() {
		return this.extra_deck_list;
	}
	
	public ArrayList<Card> getMainDeckList() {
		return this.main_deck_list;
	}

	public ArrayList<Card> getSideDeckList() {
		return this.side_deck_list;
	}

}
