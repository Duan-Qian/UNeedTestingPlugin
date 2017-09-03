package uneedtestingplugin.DataBase;

import java.sql.*;

public class ConnectDB {
	public static Connection getConnection() {
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/UNeedTesting?useSSL=false";
			conn = DriverManager.getConnection(url, "root", "0908");
//			String url = "jdbc:mysql://sql8.freemysqlhosting.net/sql8192358?useSSL=false";
//			conn = DriverManager.getConnection(url, "sql8192358", "GtgvAu9xmt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection (Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
