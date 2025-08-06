package com.testing;

import java.util.ArrayList;
import java.util.Arrays;

import com.card.component.ArchitypeComponent;
import com.engine.Backendv4;
import com.engine.Global;
import com.engine.Utils;

public abstract class EffectTester {
	public static void main(String[] args) {
		Backendv4.buildDB();
		Utils.findCard(88264978).setArchitype(new ArrayList<>(Arrays.asList(ArchitypeComponent.RED_EYES_A)));
		Global.getPlayer().getDeck().getMainDeckList().addAll(Arrays.asList(Utils.findCard(88264978), Utils.findCard(88264978)));
		Utils.executeCardEffect(Utils.findCard(93969023), 2);
	}
}
