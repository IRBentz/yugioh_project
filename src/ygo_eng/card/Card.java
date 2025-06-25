package ygo_eng.card;

import java.util.ArrayList;

public class Card implements EffectTarget {
	private Architype[] architype;
	private final int CARD_IND;
	private int max_copies_allowed = 3;
	private final String NAME, LORE;
	private final CardType TYPE;
	private Effect cardEffect;

	public Card() {
		this.NAME = null;
		this.TYPE = null;
		this.CARD_IND = 0;
		this.LORE = null;
		this.max_copies_allowed = 0;
	}

	public Card(String name, int index, CardType type, String lore) {
		this.NAME = name;
		this.CARD_IND = index;
		this.TYPE = type;
		this.LORE = lore;
	}

	public Effect effect() {
		return cardEffect;
	}

	public int getAllowedCopies() {
		return max_copies_allowed;
	}

	public Architype[] getArchitype() {
		return architype;
	}

	public int getIndex() {
		return CARD_IND;
	}

	@Override
	public Object getEffectObject() {
		return this;
	}

	public String getLore() {
		return LORE;
	}

	public String getName() {
		return NAME;
	}

	public CardType getType() {
		return TYPE;
	}

	public void setAllowedCopies(int newAmount) {
		max_copies_allowed = newAmount;
	}

	public void setArchitype(ArrayList<Architype> architype) {
		this.architype = architype.toArray(new Architype[architype.size()]);
	}

	public void setEffect(Effect effect) {
		this.cardEffect = effect;
	}

	@Override
	public String toString() {
		return String.format("%08d", CARD_IND) + " | " + max_copies_allowed + " | " + NAME + " | " + TYPE + " | "
				+ LORE;
	}
}