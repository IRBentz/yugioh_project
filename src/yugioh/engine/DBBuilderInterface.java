package yugioh.engine;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;

import yugioh.card.Card;
import yugioh.card.MonsterCard;
import yugioh.card.SpellTrapCard;
import yugioh.engine.PathAndNameEnums.ClassPath;
import yugioh.engine.PathAndNameEnums.FolderPath;

public interface DBBuilderInterface {
	Logger logger = Logger.getLogger(DBBuilderInterface.class.toString());
	
	void buildDB();
	
	MonsterCard buildExtraMonster() throws JSONException, SQLException;
	MonsterCard buildLinkMonster() throws JSONException, SQLException;
	MonsterCard buildMonster() throws JSONException, SQLException;
	void attachPendulumAttributes(MonsterCard monCard) throws JSONException, SQLException;
	MonsterCard buildPendulumExtraMonster() throws JSONException, SQLException;
	MonsterCard buildPendulumMonster() throws JSONException, SQLException;
	MonsterCard buildPendulumXyzMonster() throws JSONException, SQLException;
	SpellTrapCard buildSpellTrap() throws JSONException, SQLException;
	MonsterCard buildXyzMonster() throws JSONException, SQLException;
	Card getBuiltCard() throws JSONException, SQLException;
	
	
	default String concatStringArray(List<String> list) {
		var string = new StringBuilder();
		for (String s : list) {
			string.append(s);
		}
		return string.toString();
	}
	
	default String configurePathToClassName(Path pathToConfigure) {
		return pathToConfigure.toString().replace(".java", "");
	}
	
	default void bindCardEffects() {
		try {
			for (Card card : Global.getCardDb()) {
				for (Path path : (Iterable<Path>) Files.list(
						FileSystems.getDefault().getPath(FolderPath.YUGIOH.path + FolderPath.EFFECT_DB.path))::iterator) {
					if (path.getFileName().toString().replace(".java", "").equals(card.getName())) {
						card.setBoundClass(Class
								.forName(ClassPath.EFFECT_DB.path + this.configurePathToClassName(path.getFileName())));
					}
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			logger.log(Level.SEVERE, "An error occurred", e);
		}
	}
}