package yugioh.engine;

public enum PathAndNameEnums {
	;
	public enum ClassPath {
		EFFECT_DB("yugioh.db.effect_db."), COMPONENT("yugioh.card.component.");

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
		YUGIOH("src//yugioh//"), JSON("db//_json//"), EFFECT_DB("db//effect_db//");

		public final String path;

		FolderPath(String path) {
			this.path = path;
		}
	}
}
