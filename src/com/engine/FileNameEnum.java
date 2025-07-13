package com.engine;

public enum FileNameEnum {
	Monster("monster.info"),
	Pendulum("pendulum_monster.info"),
	Fusion("fusion_monster.info"),
	Synchro("synchro_monster.info"),
	Xyz("xyz_monster.info"),
	Link("link_monster.info"),
	Spell("spell.info"),
	Trap("trap.info"),
	FaL("forbidden_and_limited.info");
	public final String name;
	private FileNameEnum(String name) {
		this.name = name;
	}
}