package com.engine;

import java.util.ArrayList;
import java.util.List;

import com.card.Card;
import com.player.Player;

public abstract class Global {
	/**
	 * @deprecated
	 * @since 0.0.0
	 */
	@Deprecated(since = "0.0.1", forRemoval = true)
	public static int back_ver;

	public static final int PADDING = 15;
	private static List<Card> cardDb = new ArrayList<>();
	private static List<int[]> falList = new ArrayList<>();
	private static Player opponent = new Player();
	private static Player player = new Player();

	/**
	 * @return the card_db
	 */
	public static List<Card> getCardDb() {
		return cardDb;
	}

	/**
	 * @param card_db the card_db to set
	 */
	public static void setCardDb(List<Card> cardDb) {
		Global.cardDb = cardDb;
	}

	/**
	 * @return the falList
	 */
	public static List<int[]> getFalList() {
		return falList;
	}

	/**
	 * @param falList the falList to set
	 */
	public static void setFalList(List<int[]> falList) {
		Global.falList = falList;
	}

	/**
	 * @return the opponent
	 */
	public static Player getOpponent() {
		return opponent;
	}

	/**
	 * @param opponent the opponent to set
	 */
	public static void setOpponent(Player opponent) {
		Global.opponent = opponent;
	}

	/**
	 * @return the player
	 */
	public static Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public static void setPlayer(Player player) {
		Global.player = player;
	}
}