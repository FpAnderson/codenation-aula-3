package challenge;

import java.sql.*;

public class ConnectionFactory {

	private static Connection con;
	private static String url = "jdbc:sqlite:src/main/resources/database.sqlite";
	private static String drive = "org.sqlite.JDBC";

	public static Connection createConnection() throws SQLException {
		try {
			Class.forName(drive).newInstance();
			con = DriverManager.getConnection(url);
		}  catch (SQLException ex) {
			throw new RuntimeException(ex);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

}
