package uneedtestingplugin.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uneedtestingplugin.DataBase.ConnectDB;

public class AchievementDao {
	// check achievement stage
	public int stage (String event, String username) {
		Connection conn = ConnectDB.getConnection();
		String sql = "select * from userLine where event=? and username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, event);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("stage");
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
		return 0;
	}
	
	// get achievement count
	public int achievementCount (String event, String username) {
		Connection conn = ConnectDB.getConnection();
		String sql = "select * from userLine where event=? and username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, event);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("count");
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
		return 0;
	}
	
	// get achievement event description
	public String getDescription (String event) {
		Connection conn = ConnectDB.getConnection();
		String sql = "select * from achievement where event=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, event);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getString("description");
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
		return "";
	}
	
//	// check if user has exists on the local machine or not
//	public boolean hasUser (String username) {
//		Connection conn = ConnectDB.getConnection();
//		String sql = "select * from userLine where username=?";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			
//			if (!rs.next()) {
//				return true;
//			}
//			
//			rs.close();
//			ps.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			ConnectDB.closeConnection(conn);
//		}
//		return false;
//	}
}
