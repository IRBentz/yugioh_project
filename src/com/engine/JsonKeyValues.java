package com.engine;

public enum JsonKeyValues {
	JKV_attack, JKV_card_type, JKV_cards, JKV_defense, JKV_icon, JKV_index, JKV_level, JKV_linkArrow, JKV_linkRating,
	JKV_lore, JKV_monsterAttribute, JKV_monsterType, JKV_name, JKV_pendulumLevel, JKV_pendulumLore, JKV_rank,
	JKV_summonRequirement, JKV_type;
	
	public final String JKVname;
	private JsonKeyValues() {
		this.JKVname = this.name().substring("JKV_".length());
	}
}
