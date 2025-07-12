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

enum GlobalEnums {
	Monster(0), Pendulum(1), Fusion(2), Synchro(3), Xyz(4), Link(5), Spell(6), Trap(7);
	public final int index;
	GlobalEnums(int index) {
		this.index = index;
	}
}