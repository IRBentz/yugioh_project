module yugioh {
	exports yugioh;
	exports yugioh.board;
	exports yugioh.card;
	exports yugioh.card.component;
	exports yugioh.db.effect_db;
	exports yugioh.engine;
	exports yugioh.io;
	exports yugioh.io.zip;
	exports yugioh.logging.builtin;
	exports yugioh.player;
	exports yugioh.testing;
	exports yugioh.wrapper.jsonobject;

	requires transitive org.json;
	requires transitive java.desktop;
	requires transitive java.logging;
	requires transitive java.sql;
}
