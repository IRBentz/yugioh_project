package com.testing;

import static com.engine.Global.back_ver;
import static com.engine.Global.player;
import static com.card.component.ArchitypeComponent.RedEyes;
import static com.engine.Backend.start;
import static com.engine.Utils.findCard;
import static com.engine.Utils.execute_card_effect;

import java.util.ArrayList;
import java.util.Arrays;



public abstract class EffectTester {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		back_ver = 3;
		start("src//com//");
		findCard(88264978).setArchitype(new ArrayList<>(Arrays.asList(RedEyes)));
		player.getDeck().getMainDeckList().addAll(Arrays.asList(findCard(88264978), findCard(88264978)));
		execute_card_effect(findCard(93969023), 2);
	}
}
