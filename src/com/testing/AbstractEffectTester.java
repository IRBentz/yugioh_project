package com.testing;

import java.util.ArrayList;
import java.util.Arrays;

import com.card.component.ArchetypeComponent;
import com.engine.Backendv4;
import com.engine.Global;
import com.engine.Utils;

public abstract class AbstractEffectTester {
	public static void main(String[] args) {
		final int redEyesDarknessMetalDragon = 88264978;
		final int blackMetalDragon = 93969023;
		final int effectNumber = 2;
		Backendv4.buildDB();
		Utils.findCard(redEyesDarknessMetalDragon).setArchitype(new ArrayList<>(Arrays.asList(ArchetypeComponent.RED_EYES_A)));
		Global.getPlayer().getDeck().getMainDeckList().addAll(Arrays.asList(Utils.findCard(redEyesDarknessMetalDragon), Utils.findCard(redEyesDarknessMetalDragon)));
		Utils.executeCardEffect(Utils.findCard(blackMetalDragon), effectNumber);
	}
}
