package com.card;

import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;

public class ExtraPenMonCard extends ExtraMonCard implements PenCard, ExtraCard {
	final int PEND_LEVEL;
	final String PEND_LORE;
	
	public ExtraPenMonCard() {
		super();
		this.PEND_LEVEL = 0;
		this.PEND_LORE = null;
	}
	
	public ExtraPenMonCard(String name, int index, MonsterAttributeComponent mon_attri, MonsterTypeComponent mon_type, TypeComponent[] types, String pend_lore,
			String summon_req, String lore, int level_rank, int pend_level, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, summon_req, lore, level_rank, attack, defense);
		this.PEND_LEVEL = pend_level;
		this.PEND_LORE = pend_lore;
	}

	@Override
	public int getPendLevel() {
		return PEND_LEVEL;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | " + PEND_LEVEL + " | " + PEND_LORE;
	}
}
