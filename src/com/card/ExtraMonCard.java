package com.card;

import com.card.component.MonsterAttributeComponent;
import com.card.component.MonsterTypeComponent;
import com.card.component.TypeComponent;

public class ExtraMonCard extends MonCard implements CardInterfaces.ExtraCard {
	final String SUMMON_REQ;

	public ExtraMonCard() {
		super();
		this.SUMMON_REQ = null;
	}

	public ExtraMonCard(String name, int index, MonsterAttributeComponent mon_attri, MonsterTypeComponent mon_type, TypeComponent[] types,
			String summon_req, String lore, int level_rank, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.SUMMON_REQ = summon_req;
	}
	
	@Override
	public String getSumMonsterReq() {
		return SUMMON_REQ;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + SUMMON_REQ;
	}
}