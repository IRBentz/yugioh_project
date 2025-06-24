package ygo_eng.card;

public class PenMonCard extends MonCard {
	final int PEND_LEVEL;
	final String PEND_LORE;

	public PenMonCard() {
		super();
		this.PEND_LEVEL = 0;
		this.PEND_LORE = null;
	}

	public PenMonCard(String name, int index, MonAttribute mon_attri, MonType mon_type, Type[] types, String pend_lore,
			String lore, int level_rank, int pend_level, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.PEND_LEVEL = pend_level;
		this.PEND_LORE = pend_lore;
	}

	public int getPendLevel() {
		return PEND_LEVEL;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + PEND_LEVEL + " | " + PEND_LORE;
	}
}