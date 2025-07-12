package com.engine;

import java.util.ArrayList;

import com.card.Card;
import com.player.Player;

public abstract class Global {
	public static int back_ver;
	public static ArrayList<Card> card_db = new ArrayList<>();
	public static final String EFFECT_CLASS_HEADER = "ygo_eng.db.effect_db.";
	public static ArrayList<int[]> fal_list = new ArrayList<>();
	public static Player opponent = new Player();
	public static Player player = new Player();
}