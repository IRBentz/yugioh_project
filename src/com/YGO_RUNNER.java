package com;

//import static com.engine.QueDB_Builder.queUser;

public class YGO_RUNNER {

	public static void main(String[] args) {
		//queUser();
		com.engine.Backend_v3.buildDB("src//ygo_eng//");
		com.engine.Global.card_db.forEach(card -> System.out.println(card));
	}
}
