package com.engine;

public enum PathAndNameEnums {
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
		ComPath("src//com//"), DepPath("src//dep//"), InfoPath("db//_info//"), JsonPath("db//_json//"), EffectDBPath("db//effect_db//");

		public final String path;

		private FilePathEnum(String path) {
			this.path = path;
		}
	}
	
	public enum ClassPathEnum {
		EffectDB("com.db.effect_db."),  Component("com.card.component.");
		public final String path;
		private ClassPathEnum(String path) {
			this.path = path;
		}
	}
}
