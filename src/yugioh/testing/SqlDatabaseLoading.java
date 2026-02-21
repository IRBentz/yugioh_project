package yugioh.testing;

import module java.base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import module yugioh;

class SqlCardObject implements ImportCardInterface {
	static Logger logger = Logger.getLogger(SqlCardObject.class.getName());

	ResultSet resultSet;

	public SqlCardObject(final ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	@Override
	public CardTypeComponent getCardTypeComponent(final String input) {
		return null;
	}

	@Override
	public IconComponent getIconComponent(final String input) {
		return null;
	}

	@Override
	public int getInt(final String input) {
		return 0;
	}

	@Override
	public LinkArrowComponent[] getLinkArrowArray(final String input) {
		return new LinkArrowComponent[] {};
	}

	@Override
	public MonsterAttributeComponent getMonsterAttributeComponent(final String input) {
		return null;
	}

	@Override
	public MonsterTypeComponent getMonsterTypeComponent(final String input) {
		return null;
	}

	@Override
	public String getString(final String input) {
		return null;
	}

	@Override
	public String[] getStringArray(final String input) {
		return new String[] {};
	}

	@Override
	public TypeComponent[] getTypeComponentArray(final String input) {
		return new TypeComponent[] {};
	}
}

public class SqlDatabaseLoading {

	public static void main(String[] args) {
		final var databasePath = "jdbc:sqlite:BabelCDB/cards.cdb";
		try (var conn = DriverManager.getConnection(databasePath)) {
			if (conn != null) {
				System.out.println("Connection to SQLite has been established.");

				// Example 1: Read data from a specific table
				// readData(conn, "datas");
				// Example 2: Read database schema (list tables)
				SqlDatabaseLoading.readSchema(conn);
				System.out.println(conn.getTypeMap());
			}
		} catch (final SQLException e) {
			System.err.println("Database error: " + e.getMessage());
		}
	}

	/**
	 * Reads and prints all rows from a specified table.
	 *
	 * @param conn      The database connection.
	 * @param tableName The name of the table to read.
	 */
	public static void readData(final Connection conn, final String tableName) throws SQLException {
		final var query = "SELECT * FROM " + tableName;
		try (var stmt = conn.createStatement(); var rs = stmt.executeQuery(query)) {

			System.out.println("\nReading data from table: " + tableName);
			while (rs.next()) {
				// Access data by column name or index
				final var name = rs.getString("id");
				final var occupation = rs.getString("ot");
				System.out.println("Name = " + name + ", Occupation = " + occupation);
			}
		}
	}

	/**
	 * @param conn
	 * @throws SQLException
	 */
	public static void readSchema(final Connection conn) throws SQLException {
		// Query the special sqlite_schema table to get table names
		final var query = "SELECT sql FROM sqlite_master WHERE type = 'table'";
		try (var stmt = conn.createStatement(); var rs = stmt.executeQuery(query)) {
			System.out.println("\nTable Schema in the database:");
			while (rs.next()) {
				final var item = rs.getString("sql").replaceAll(" +", " ");
				final List<String> items = Arrays.asList(item.split("\n "));
				for (String s : items) {
					s = s.strip();
				}

				final var items2 = new String[items.size()];
				var i = 0;
				for (final String s : items) {
					if (s.startsWith("\"")) {
						items2[i] = s.replace(",", "");
						i++;
					}
				}

				final var items3 = new String[items2.length][2];
				var j = 0;
				for (final String s : items2) {
					if (s != null) {
						items3[j] = s.split(" ");
						j++;
					}
				}

				final var pairedItems = (ArrayList<SqlPair>) new TableSchema(new ArrayList<>()).getPairedItemsList();
				for (final String[] s : items3) {
					if ((s[0] != null) || (s[1] != null)) {
						switch (s[1]) {
						case "INTEGER" -> pairedItems.add(new SqlPair(s[0], sqlTypes.INTEGER));
						case "TEXT" -> pairedItems.add(new SqlPair(s[0], sqlTypes.TEXT));
						default -> System.out.println("Unfound case for " + s[1]);
						}
					}
				}
				System.out.println(pairedItems);
				Global.getCardDb();

			}
		}
	}
}

class SqlPair {
	private final String name;
	private final sqlTypes sqlType;

	SqlPair(final String n, final sqlTypes sT) {
		this.name = n;
		this.sqlType = sT;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "[" + this.name + ", " + this.sqlType + "]";
	}
}

class TableSchema {
	private final ArrayList<SqlPair> pairedItems;

	TableSchema(final ArrayList<SqlPair> pI) {
		this.pairedItems = pI;
	}

	public List<SqlPair> getPairedItemsList() {
		return this.pairedItems;
	}

	@Override
	public String toString() {
		return this.pairedItems.toString();
	}
}
