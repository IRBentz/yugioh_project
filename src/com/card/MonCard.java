package com.card;

public class MonCard extends Card {
	private final int LEVEL_RANK, ATTACK, DEFENSE;
	private final MonAttribute MON_ATTRI;
	private final MonType MON_TYPE;
	private final Type[] TYPES;

	public MonCard() {
		super();
		this.MON_ATTRI = null;
		this.MON_TYPE = null;
		this.TYPES = null;
		this.LEVEL_RANK = 0;
		this.ATTACK = 0;
		this.DEFENSE = 0;
	}

	public MonCard(String name, int index, MonAttribute mon_attri, MonType mon_type, Type[] types, String lore,
			int level_rank, int attack, int defense) {
		super(name, index, CardType.MONSTER, lore);
		this.MON_ATTRI = mon_attri;
		this.MON_TYPE = mon_type;
		this.TYPES = types;
		this.LEVEL_RANK = level_rank;
		this.ATTACK = attack;
		this.DEFENSE = defense;
	}

	public int getAttack() {
		return ATTACK;
	}

	public MonAttribute getAttribute() {
		return MON_ATTRI;
	}

	public int getDefense() {
		return DEFENSE;
	}

	public int getLevelOrRank() {
		return LEVEL_RANK;
	}

	public MonType getMonType() {
		return MON_TYPE;
	}

	public Type[] getTypes() {
		return TYPES;
	}

	@Override
	public String toString() {
		String types = "";
		for (Type type : TYPES) {
			types += type.toString() + " ";
		}
		types = types.substring(0, types.length() - 1);

		return super.toString() + " | " + MON_ATTRI + " | " + MON_TYPE + " | " + types + " | " + LEVEL_RANK + " | "
				+ ATTACK + " | " + DEFENSE;
	}
}