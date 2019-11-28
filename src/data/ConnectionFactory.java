package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection createConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/social";
			String user = "root";
			String password = "";

			Connection connection = DriverManager.getConnection(url, user, password);

			return connection;

		} catch (Exception e) {

			return null;
		}
	}
}