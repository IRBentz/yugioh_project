package com.card;

import com.card.component.CardTypeComponent;
import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;

public class MonCard extends Card {
	private final int LEVEL_RANK, ATTACK, DEFENSE;
	private final MonsterAttributeComponent MON_ATTRI;
	private final MonsterTypeComponent MON_TYPE;
	private final TypeComponent[] TYPES;

	public MonCard() {
		super();
		this.MON_ATTRI = null;
		this.MON_TYPE = null;
		this.TYPES = null;
		this.LEVEL_RANK = 0;
		this.ATTACK = 0;
		this.DEFENSE = 0;
	}

	public MonCard(String name, int index, MonsterAttributeComponent mon_attri, MonsterTypeComponent mon_type, TypeComponent[] types, String lore,
			int level_rank, int attack, int defense) {
		super(name, index, CardTypeComponent.Monster, lore);
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

	public MonsterAttributeComponent getAttribute() {
		return MON_ATTRI;
	}

	public int getDefense() {
		return DEFENSE;
	}

	public int getLevelOrRank() {
		return LEVEL_RANK;
	}

	public MonsterTypeComponent getMonType() {
		return MON_TYPE;
	}

	public TypeComponent[] getTypes() {
		return TYPES;
	}

	@Override
	public String toString() {
		String types = "";
		for (TypeComponent type : TYPES) {
			types += type.toString() + " ";
		}
		types = types.substring(0, types.length() - 1);

		return super.toString() + " | " + MON_ATTRI + " | " + MON_TYPE + " | " + types + " | " + LEVEL_RANK + " | "
				+ ATTACK + " | " + DEFENSE;
	}
}