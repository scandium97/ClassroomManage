package db;

import java.sql.*;

public class DbUtil {
	static String db_url = "jdbc:mysql://localhost:3306/crms?serverTimezone=UTC";
	static String user = "root";
	static String password ="********";
	static String driver = "com.mysql.cj.jdbc.Driver";
	static public Connection GetConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(db_url,user,password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
