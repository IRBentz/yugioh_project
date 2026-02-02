package com.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.io.sqlTypes;

public class SqlDatabaseLoading {

	public static void main(String[] args) {
		var databasePath = "jdbc:sqlite:BabelCDB/cards.cdb";
		try (var conn = DriverManager.getConnection(databasePath)) {
			if (conn != null) {
				System.out.println("Connection to SQLite has been established.");

				// Example 1: Read data from a specific table
				// readData(conn, "datas");
				// Example 2: Read database schema (list tables)
				readSchema(conn);
				System.out.println(conn.getTypeMap());
			}
		} catch (SQLException e) {
			System.err.println("Database error: " + e.getMessage());
		}
	}

	/**
	 * Reads and prints all rows from a specified table.
	 *
	 * @param conn      The database connection.
	 * @param tableName The name of the table to read.
	 */
	public static void readData(Connection conn, String tableName) throws SQLException {
		var query = "SELECT * FROM " + tableName;
		try (var stmt = conn.createStatement(); var rs = stmt.executeQuery(query)) {

			System.out.println("\nReading data from table: " + tableName);
			while (rs.next()) {
				// Access data by column name or index
				var name = rs.getString("id");
				var occupation = rs.getString("ot");
				System.out.println("Name = " + name + ", Occupation = " + occupation);
			}
		}
	}

	/**
	 * Reads and prints all table names in the database schema.
	 *
	 * @param conn The database connection.
	 */
	public static void readSchema(Connection conn) throws SQLException {
		// Query the special sqlite_schema table to get table names
		var query = "SELECT sql FROM sqlite_master WHERE type = 'table'";
		try (var stmt = conn.createStatement(); var rs = stmt.executeQuery(query)) {
			System.out.println("\nTable Schema in the database:");
			while (rs.next()) {
				var item = rs.getString("sql").replaceAll(" +", " ");
				List<String> items = Arrays.asList(item.split("\n "));
				for (String s : items) {
					s = s.strip();
				}
				var items2 = new String[items.size()];
				var i = 0;
				for (String s : items) {
					if (s.startsWith("\"")) {
						items2[i++] = s.replace(",", "");
					}
				}

				var items3 = new String[items2.length][2];
				var j = 0;
				for (String s : items2) {
					if (s != null) {
						items3[j++] = s.split(" ");
					}
				}

				var pairedItems = (ArrayList<SqlPair>) new TableSchema(new ArrayList<>()).getPairedItemsList();
				for (String[] s : items3) {
					if ((s[0] != null) || (s[1] != null)) {
						switch (s[1]) {
						case "INTEGER" -> pairedItems.add(new SqlPair(s[0], sqlTypes.INTEGER));
						case "TEXT" -> pairedItems.add(new SqlPair(s[0], sqlTypes.TEXT));
						default -> System.out.println("Unfound case for " + s[1]);
						}
					}
				}
				System.out.println(pairedItems);
			}
		}
	}
}

class SqlPair {
	private final String name;
	private final sqlTypes sqlType;

	SqlPair(String n, sqlTypes sT) {
		name = n;
		sqlType = sT;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + sqlType + "]";
	}
}

class TableSchema {
	private ArrayList<SqlPair> pairedItems;

	TableSchema(ArrayList<SqlPair> pI) {
		pairedItems = pI;
	}

	public List<SqlPair> getPairedItemsList() {
		return pairedItems;
	}

	@Override
	public String toString() {
		return pairedItems.toString();
	}
}