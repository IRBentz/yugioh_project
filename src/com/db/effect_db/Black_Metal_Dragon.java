package com.db.effect_db;

import static com.engine.Global.player;
import static com.engine.Utils.search;

/*
 * Black Metal Dragon
 * 93969023
 * You can target 1 "Red-Eyes" monster you control; equip this monster from your hand or field to that target. It gains 600 ATK.
 * If this card is sent from the field to the GY: You can add 1 "Red-Eyes" card from your Deck to your hand.
 * DARK DRAGON EFFECT ; 1 600 600
 */
public abstract class Black_Metal_Dragon {

	public static boolean check_conditions(int num) {
		return false;
	}

	private static void effect_1() {

	}
	
	private static void effect_2() {
		player.getHand().addCard(search(player.getDeck(), "Red-Eyes"));
	}
	
	public static void execute_effect(int num) {
		switch (num) {
		case 0:
			return;
		case 1:
			effect_1();
		case 2:
			effect_2();
		}
	}
	
	public static int get_num_effect() {
		return 2;
	}
}

