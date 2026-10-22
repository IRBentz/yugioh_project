package yugioh.engine;

import java.util.ArrayList;
import java.util.List;

import yugioh.card.Card;
import yugioh.card.component.ArchetypeSetcodeComponent;
import yugioh.player.Player;

public class Global {
	private static List<Card> cardDb = new ArrayList<>();
	private static List<ArchetypeSetcodeComponent> archetypeSetcodeList = new ArrayList<>();
	private static List<int[]> falList = new ArrayList<>();
	private static Player opponent = new Player();
	private static Player player = new Player();

	public static List<Card> getCardDb() {
		return cardDb;
	}
	public static List<ArchetypeSetcodeComponent> getArchetypeSetcodeList() { return archetypeSetcodeList; }
	public static List<int[]> getFalList() {
		return falList;
	}
	public static Player getOpponent() {
		return opponent;
	}
	public static Player getPlayer() {
		return player;
	}
	public static void setCardDb(List<Card> cardDb) {
		Global.cardDb = cardDb;
	}
	public static void setArchetypeSetcodeList(List<ArchetypeSetcodeComponent> archetypeSetcodeList) { Global.archetypeSetcodeList = archetypeSetcodeList; }
	public static void setFalList(List<int[]> falList) {
		Global.falList = falList;
	}
	public static void setOpponent(Player opponent) {
		Global.opponent = opponent;
	}
	public static void setPlayer(Player player) {
		Global.player = player;
	}

	protected Global() throws UnsupportedOperationException {
	}
}
