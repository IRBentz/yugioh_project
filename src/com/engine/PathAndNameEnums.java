package com.engine;

public enum PathAndNameEnums {
	;
	public enum FileName {
		CARD_JSON("card.json");

		public final String nameWithExtension;

		FileName(String name) {
			this.nameWithExtension = name;
		}
	}

	public enum FolderPath {
		COM("src//com//"), JSON("db//_json//"), EFFECT_DB("db//effect_db//");

		public final String path;

		FolderPath(String path) {
			this.path = path;
		}
	}
	
	public enum ClassPath {
		EFFECT_DB("com.db.effect_db."), COMPONENT("com.card.component.");
		public final String path;
		ClassPath(String path) {
			this.path = path;
		}
	}
}
