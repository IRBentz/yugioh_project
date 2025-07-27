package com.testing;

import static com.engine.Global.player;
import static com.card.component.ArchitypeComponent.RedEyes_A;
import static com.engine.Utils.findCard;
import static com.engine.Utils.execute_card_effect;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class EffectTester {
	public static void main(String args[]) {
		com.engine.Backend_v4.buildDB();
		findCard(88264978).setArchitype(new ArrayList<>(Arrays.asList(RedEyes_A)));
		player.getDeck().getMainDeckList().addAll(Arrays.asList(findCard(88264978), findCard(88264978)));
		execute_card_effect(findCard(93969023), 2);
	}
}
