package yugioh;

import yugioh.engine.Backendv4;
import yugioh.engine.DBBuilderInterface;
import yugioh.logging.builtin.Logging;

public class YgoRunner {
	public static void main(String[] args) {
		Logging.setupLogging();
		
		DBBuilderInterface builder = new Backendv4(0);
		builder.buildDB();
	}
}
