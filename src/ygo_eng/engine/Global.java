package ygo_eng.engine;

import java.util.ArrayList;

import ygo_eng.card.Card;
import ygo_eng.player.Player;

public abstract class Global {
	public static int back_ver;
	public static ArrayList<Card> card_db = new ArrayList<>();
	public static ArrayList<int[]> fal_list = new ArrayList<>();
	public static Player player = new Player();
	public static Player opponent = new Player();
	public static final String EFFECT_CLASS_HEADER = "ygo_eng.db.effect_db.";
}
