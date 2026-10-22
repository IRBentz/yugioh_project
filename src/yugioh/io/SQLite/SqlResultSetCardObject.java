package yugioh.io.SQLite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import yugioh.card.component.*;
import yugioh.io.ImportCardInterface;

public class SqlResultSetCardObject implements ImportCardInterface {
	static Logger logger = Logger.getLogger(SqlResultSetCardObject.class.getName());
	/*
	 * resultSet.getInt("id"), resultSet.getInt("alias"), resultSet.getString("name"), 
	 * resultSet.getString("desc"), resultSet.getInt("type"), resultSet.getInt("atk"), 
	 * resultSet.getInt("def"), resultSet.getInt("level"), resultSet.getInt("race"), 
	 * resultSet.getInt("attribute"), resultSet.getInt("category")
	 */
	
	ResultSet resultSet;
	
	public SqlResultSetCardObject(final ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	@Override
	public CardTypeComponent getCardTypeComponent(String input) throws SQLException {
		return (CardTypeComponent) stringToCardComponentInterface(resultSet.getString(input));
	}

	@Override
	public IconComponent getIconComponent(String input) throws SQLException{
		return (IconComponent) stringToCardComponentInterface(resultSet.getString(input));
	}

	@Override
	public int getInt(String input) throws SQLException {
		return resultSet.getInt(input);
	}

	@Override
	public LinkArrowComponent[] getLinkArrowArray(String input) throws SQLException {
		return LinkArrowComponent.evalIntToList(resultSet.getInt(input)).toArray(LinkArrowComponent[]::new);
	}

	@Override
	public MonsterAttributeComponent getMonsterAttributeComponent(String input) throws SQLException {
		return (MonsterAttributeComponent) stringToCardComponentInterface(resultSet.getString(input));
	}

	@Override
	public MonsterTypeComponent getMonsterTypeComponent(String input) throws SQLException {
		return (MonsterTypeComponent) stringToCardComponentInterface(resultSet.getString(input));
	}

	@Override
	public String getString(String input) throws SQLException {
		return resultSet.getString(input);
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
