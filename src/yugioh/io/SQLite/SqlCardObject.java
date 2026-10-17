package yugioh.io.SQLite;

import java.sql.ResultSet;
import java.util.logging.Logger;

import yugioh.card.component.CardTypeComponent;
import yugioh.card.component.IconComponent;
import yugioh.card.component.LinkArrowComponent;
import yugioh.card.component.MonsterAttributeComponent;
import yugioh.card.component.MonsterTypeComponent;
import yugioh.card.component.TypeComponent;
import yugioh.io.ImportCardInterface;

public class SqlCardObject implements ImportCardInterface {
	private static Logger logger = Logger.getLogger(SqlCardObject.class.getName());
	/*
	 * resultSet.getInt("id"), resultSet.getInt("alias"), resultSet.getString("name"), 
	 * resultSet.getString("desc"), resultSet.getInt("type"), resultSet.getInt("atk"), 
	 * resultSet.getInt("def"), resultSet.getInt("level"), resultSet.getInt("race"), 
	 * resultSet.getInt("attribute"), resultSet.getInt("category")
	 */
	
	ResultSet resultSet;
	
	public SqlCardObject(final ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	@Override
	public CardTypeComponent getCardTypeComponent(String input) {
		
		return null;
	}

	@Override
	public IconComponent getIconComponent(String input) {
		
		return null;
	}

	@Override
	public int getInt(String input) {
		
		return 0;
	}

	@Override
	public LinkArrowComponent[] getLinkArrowArray(String input) {
		
		return null;
	}

	@Override
	public MonsterAttributeComponent getMonsterAttributeComponent(String input) {
		
		return null;
	}

	@Override
	public MonsterTypeComponent getMonsterTypeComponent(String input) {
		
		return null;
	}

	@Override
	public String getString(String input) {
		
		return null;
	}

	@Override
	public String[] getStringArray(String input) {
		
		return null;
	}

	@Override
	public TypeComponent[] getTypeComponentArray(String input) {
		
		return null;
	}

}
