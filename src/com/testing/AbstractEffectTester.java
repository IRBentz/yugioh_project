package com.testing;

import java.util.ArrayList;
import java.util.Arrays;

import com.card.component.ArchetypeComponent;
import com.engine.Backendv4;
import com.engine.Global;
import com.io.Utils;

public abstract class AbstractEffectTester {
	public static void main(String[] args) {
		final var redEyesDarknessMetalDragon = 88264978;
		final var blackMetalDragon = 93969023;
		final var effectNumber = 2;
		Backendv4.buildDB();
		Utils.findCard(redEyesDarknessMetalDragon)
				.setArchitype(new ArrayList<>(Arrays.asList(ArchetypeComponent.RED_EYES_A)));
		Global.getPlayer().getDeck().getMainDeckList().addAll(
				Arrays.asList(Utils.findCard(redEyesDarknessMetalDragon), Utils.findCard(redEyesDarknessMetalDragon)));
		Utils.executeCardEffect(Utils.findCard(blackMetalDragon), effectNumber);
	}
}
