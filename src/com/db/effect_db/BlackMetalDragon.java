package com.db.effect_db;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.engine.Global;
import com.io.Utils;

/*
 * Black Metal Dragon
 * 93969023
 * You can target 1 "Red-Eyes" monster you control; equip this monster from your hand or field to that target. It gains 600 ATK.
 * If this card is sent from the field to the GY: You can add 1 "Red-Eyes" card from your Deck to your hand.
 * DARK DRAGON EFFECT ; 1 600 600
 */
public class BlackMetalDragon implements EffectInterface {
	private static final Logger LOGGER = Logger.getLogger(BlackMetalDragon.class.getName());

	private static void effect1() {
		// Yet to be implemented.
	}

	private static void effect2() {
		Global.getPlayer().getHand().addCard(Utils.searchByName(Global.getPlayer().getDeck(), "Red-Eyes"));
	}

	@Override
	public boolean[] checkConditions() {
		return new boolean[] {};
	}

	@Override
	public void executeEffect(int num) {
		switch (num) {
		case 1:
			effect1();
			break;
		case 2:
			effect2();
			break;
		default:
		}
		var outputString = new StringBuilder("Effect ");
		outputString.append(num);
		outputString.append(" Executed.");
		LOGGER.log(Level.INFO, outputString::toString);
	}

	/**
	 *
	 * @return <int> number of effects
	 */
	@Override
	public int getNumEffect() {
		return BlackMetalDragon.class.getMethods().length - BlackMetalDragon.class.getSuperclass().getMethods().length
				- 1;
	}
}
