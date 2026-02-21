package yugioh.testing;

import java.util.ArrayList;
import java.util.Arrays;

import yugioh.card.component.ArchetypeComponent;
import yugioh.engine.Backendv4;
import yugioh.engine.DBBuilder;
import yugioh.engine.Global;
import yugioh.io.Utils;

public abstract class AbstractEffectTester {
	public static void main(String[] args) {
		final var redEyesDarknessMetalDragon = 88264978;
		final var blackMetalDragon = 93969023;
		final var effectNumber = 2;
		DBBuilder builder = new Backendv4(0);
		builder.buildDB();
		Utils.findCard(redEyesDarknessMetalDragon)
				.setArchitype(new ArrayList<>(Arrays.asList(ArchetypeComponent.RED_EYES_A)));
		Global.getPlayer().getDeck().getMainDeckList().addAll(
				Arrays.asList(Utils.findCard(redEyesDarknessMetalDragon), Utils.findCard(redEyesDarknessMetalDragon)));
		Utils.executeCardEffect(Utils.findCard(blackMetalDragon), effectNumber);
	}
}
