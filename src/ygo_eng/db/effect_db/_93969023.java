package ygo_eng.db.effect_db;

import ygo_eng.card.Architype;
import ygo_eng.engine.Global;

/*
 * Black Metal Dragon
 * 93969023
 * You can target 1 "Red-Eyes" monster you control; equip this monster from your hand or field to that target. It gains 600 ATK.
 * If this card is sent from the field to the GY: You can add 1 "Red-Eyes" card from your Deck to your hand.
 * DARK DRAGON EFFECT ; 1 600 600
 */
public abstract class _93969023 implements Effect_Interface {

	@Override
	public boolean check_conditions(int num) {
		return false;
	}

	@Override
	public void execute_effect(int num) {
		switch (num) {
		case 0:
			return;
		case 1:
			effect_1();
		case 2:
			effect_2();
		}
	}
	
	@Override
	public int get_num_effect() {
		return 2;
	}
	
	private void effect_1() {
		
	}
	
	private void effect_2() {
		Global.player.getHand().addCard(Global.searchCard(Global.player.getDeck(), Architype.RED_EYES));
	}
}

