package br.ufc.vv.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost//Cinema", "root", "");
		} catch (SQLException|ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
