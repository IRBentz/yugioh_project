package yugioh.engine;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import yugioh.card.Card;
import yugioh.card.MonsterCard;
import yugioh.card.SpellTrapCard;
import yugioh.engine.PathAndNameEnums.ClassPath;
import yugioh.engine.PathAndNameEnums.FolderPath;

public interface DBBuilderInterface {
	Logger logger = Logger.getLogger(DBBuilderInterface.class.toString());
	
	void buildDB();
	
	MonsterCard buildExtraMonster();
	MonsterCard buildLinkMonster();
	MonsterCard buildMonster();
	void attachPendulumAttributes(MonsterCard monCard);
	MonsterCard buildPendulumExtraMonster();
	MonsterCard buildPendulumMonster();
	MonsterCard buildPendulumXyzMonster();
	SpellTrapCard buildSpellTrap();
	MonsterCard buildXyzMonster();
	Card getBuiltCard();
	
	
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
			logger.log(Level.SEVERE, "An error occured", e);
		}
	}
}