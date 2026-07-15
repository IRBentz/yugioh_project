package yugioh.engine;

public enum PathAndNameEnums {
	;
	public enum ClassPath {
		YUGIOH("yugioh."), EFFECT_DB(YUGIOH.path + "db.effect_db."), COMPONENT(YUGIOH.path + "card.component.");

		public final String path;

		ClassPath(String path) {
			this.path = path;
		}
	}

	public enum FileName {
		CARD_JSON("card.json");

		public final String nameWithExtension;

		FileName(String name) {
			nameWithExtension = name;
		}
	}

	public enum FolderPath {
		SRC("src//"), DB("db//"), YUGIOH(SRC.path + "yugioh//"), JSON(DB.path + "_json//"), EFFECT_DB(DB.path + "effect_db//");

		public final String path;

		FolderPath(String path) {
			this.path = path;
		}
	}
}
