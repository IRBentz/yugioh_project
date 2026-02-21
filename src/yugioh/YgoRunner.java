package yugioh;

import yugioh.engine.Backendv4;
import yugioh.engine.DBBuilder;
import yugioh.logging.builtin.Logging;

public class YgoRunner {
	public static void main(String[] args) {
		Logging.setupLogging();
		
		DBBuilder builder = new Backendv4(0);
		builder.buildDB();
	}
}
