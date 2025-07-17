module yugioh {
	exports com;
	exports com.board;
	exports com.card;
	exports com.card.component;
	exports com.db.effect_db;
	exports com.engine;
	exports com.player;
	exports com.testing;
	exports com.ui;
	
	exports dep.card.enums;
	exports dep.engine;
	exports dep.testing;
	
	requires org.json;
	requires transitive java.desktop;
}