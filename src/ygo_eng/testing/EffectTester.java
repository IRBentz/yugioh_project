package ygo_eng.testing;

import java.util.ArrayList;
import java.util.Arrays;

import ygo_eng.card.Architype;
import ygo_eng.engine.Backend;
import ygo_eng.engine.Global;
import ygo_eng.engine.Utils;

public abstract class EffectTester {
	public static void main(String args[]) {
		Global.back_ver = 3;
		Backend.start("src//ygo_eng//");
		Utils.findCard(88264978).setArchitype(new ArrayList<>(Arrays.asList(Architype.RED_EYES)));
		Global.player.getDeck().getMainDeckList().addAll(Arrays.asList(Utils.findCard(88264978), Utils.findCard(88264978)));
		Utils.execute_card_effect(Utils.findCard(93969023), 2);
	}
}
