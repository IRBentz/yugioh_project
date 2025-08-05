package com;

//import static com.engine.QueDB_Builder.queUser;

public class YGO_RUNNER {
	public static void main(String[] args) {
		com.engine.Backend_v4.buildDB();
		com.engine.Global.card_db.forEach(card -> System.out.println(card));
	}
}
