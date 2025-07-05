module yugioh {
	exports ygo_eng.board to ygo_eng.engine;
	exports ygo_eng.db.effect_db to ygo_eng.engine;
	exports ygo_eng.card to ygo_eng.engine, ygo_eng.testing, ygo_eng.player;
	exports ygo_eng.testing;
	exports ygo_eng.engine to ygo_eng, ygo_eng.testing;
	exports ygo_eng.ui;
	exports ygo_eng.player;
	exports ygo_eng;

	requires transitive java.desktop;
}