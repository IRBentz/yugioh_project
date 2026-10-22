package yugioh.testing;

import module java.base;

import java.sql.*;
import java.util.List;

import yugioh.card.component.CardTypeComponent;
import yugioh.card.component.IconComponent;
import yugioh.card.component.LinkArrowComponent;
import yugioh.card.component.MonsterAttributeComponent;
import yugioh.card.component.MonsterTypeComponent;
import yugioh.card.component.TypeComponent;
import yugioh.engine.Global;
import yugioh.io.ImportCardInterface;
import yugioh.io.SqlTypes;

public class SqlDatabaseLoading {

	public static void main(String[] args) {
		final var databasePath = "jdbc:sqlite:BabelCDB/cards.cdb";
		try (var conn = DriverManager.getConnection(databasePath)) {
			if (conn != null) {
				System.out.println("Connection to SQLite has been established.");

				// Example 1: Read data from a specific table
				//readData(conn, "datas");
				// Example 2: Read database schema (list tables)
				readSchema(conn);
				System.out.println(conn.getTypeMap());
				readJoinedTables(conn);
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
						case "INTEGER" -> pairedItems.add(new SqlPair(s[0], SqlTypes.INTEGER));
						case "TEXT" -> pairedItems.add(new SqlPair(s[0], SqlTypes.TEXT));
						default -> System.out.println("Unfound case for " + s[1]);
						}
					}
				}
				System.out.println(pairedItems);
				Global.getCardDb();

			}
		}
	}
	
	public static void readJoinedTables(final Connection conn) throws SQLException {
		final var query = "SELECT datas.id, alias, name, desc, type, atk, def, level, race, attribute, category, setcode FROM datas INNER JOIN texts ON datas.id = texts.id";
		try (var stmt = conn.createStatement(); var rs = stmt.executeQuery(query)) {
            int i = 0;
            while (rs.next() && i <= 50) {
				System.out.println(buildRS(rs).toString());
				i++;
			}
		}
	}
	
	private static Rs buildRS(final ResultSet rs) throws SQLException {
		return new Rs(rs.getInt("id"), rs.getInt("alias"), rs.getString("name"), rs.getString("desc"), rs.getInt("type"), rs.getInt("atk"), rs.getInt("def"), rs.getInt("level"), rs.getInt("race"), rs.getInt("attribute"), rs.getInt("category"));
	}
	
	public record Rs(int id, int alias, String name, String desc, int type, int atk, int def, int level, int race, int attribute, int category) {}
}

class SqlPair {
	private final String name;
	private final SqlTypes sqlType;

	SqlPair(final String n, final SqlTypes sT) {
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
