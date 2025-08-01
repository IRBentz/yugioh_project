package com.engine;

public enum FileEnums {
	;
	public enum FileNameEnum {
		Monster_info("monster.info"), Pendulum_info("pendulum_monster.info"), Fusion_info("fusion_monster.info"),
		Synchro_info("synchro_monster.info"), Xyz_info("xyz_monster.info"), Link_info("link_monster.info"),
		Spell_info("spell.info"), Trap_info("trap.info"), FaL_info("forbidden_and_limited.info"),
		Card_json("card.json");

		public final String name;

		private FileNameEnum(String name) {
			this.name = name;
		}
	}

	public enum FilePathEnum {
		ComPath("src//com//"), DepPath("src//dep//"), InfoPath("db//_info//"), JsonPath("db//_json//");

		public final String path;

		private FilePathEnum(String path) {
			this.path = path;
		}
	}
}
