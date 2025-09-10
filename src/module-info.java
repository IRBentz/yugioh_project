module yugioh {
	exports com;
	exports com.board;
	exports com.card;
	exports com.card.component;
	exports com.db.effect_db;
	exports com.engine;
	exports com.io;
	exports com.logging;
	exports com.player;
	exports com.testing;
	exports com.ui;
	exports com.wrapper.jpanel;
	exports com.wrapper.jscrollpane;
	exports com.wrapper.jsonobject;

	requires transitive org.json;
	requires transitive java.desktop;
	requires transitive java.logging;
}
