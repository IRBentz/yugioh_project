package com.db.effect_db;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.engine.Global;
import com.engine.Utils;

/*
 * Black Metal Dragon
 * 93969023
 * You can target 1 "Red-Eyes" monster you control; equip this monster from your hand or field to that target. It gains 600 ATK.
 * If this card is sent from the field to the GY: You can add 1 "Red-Eyes" card from your Deck to your hand.
 * DARK DRAGON EFFECT ; 1 600 600
 */
public class Black0Metal0Dragon implements Effect_Interface {
	private static final Logger LOGGER = Logger.getLogger(Black0Metal0Dragon.class.getName());
	@Override
	public boolean[] check_conditions() {
		return new boolean[] {};
	}

	private void effect1() {
		// Yet to be implemented.
	}

	private void effect2() {
		Global.getPlayer().getHand().addCard(Utils.searchByName(Global.getPlayer().getDeck(), "Red-Eyes"));
	}

	@Override
	public void execute_effect(int num) {
		switch (num) {
		case 1:
			effect1();
			break;
		case 2:
			effect2();
			break;
		default:
		}
		StringBuilder outputString = new StringBuilder("Effect ");
		outputString.append(num);
		outputString.append(" Executed.");
		LOGGER.log(Level.INFO, outputString::toString);
	}

	@Override
	public int get_num_effect() {
		return Black0Metal0Dragon.class.getMethods().length
				- Black0Metal0Dragon.class.getSuperclass().getMethods().length - 1;
	}
}
