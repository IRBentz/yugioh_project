package com.engine;

public enum Json {
	ATTACK("attack"), CARD_TYPE("card_type"), CARDS("cards"), DEFENSE("defense"), ICON("icon"), INDEX("index"),
	LEVEL("level"), LINK_ARROW("linkArrow"), LINK_RATING("linkRating"), LORE("lore"),
	MONSTER_ATTRIBUTE("monsterAttribute"), MONSTER_TYPE("monsterType"), NAME("name"), PENDULUM_LEVEL("pendulumLevel"),
	PENDULUM_LORE("pendulumLore"), RANK("rank"), SUMMON_REQUIREMENT("summonRequirement"), TYPE("type");

	public final String jkvName;

	Json(String name) {
		jkvName = name;
	}
}
