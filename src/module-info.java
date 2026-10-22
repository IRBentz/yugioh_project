module yugioh {
	exports yugioh;
	exports yugioh.board;
	exports yugioh.card;
	exports yugioh.card.component;
	exports yugioh.engine;
	exports yugioh.io;
	exports yugioh.io.exception;
	exports yugioh.io.json;
	exports yugioh.io.SQLite;
	exports yugioh.io.FilePath;
	exports yugioh.io.zip;
	exports yugioh.logging.builtin;
	exports yugioh.player;
	exports yugioh.testing;

	requires transitive org.json;
	requires transitive java.desktop;
	requires transitive java.logging;
	requires transitive java.sql;
}
