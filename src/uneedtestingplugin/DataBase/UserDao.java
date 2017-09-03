package uneedtestingplugin.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uneedtestingplugin.DataBase.ConnectDB;

public class UserDao {	
	// save testCaseNum into database
	public void saveTestCaseNum(int testCaseNum, String username) {
		Connection conn = ConnectDB.getConnection();
		String sql = "update users set testCaseNum=? where username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, testCaseNum);
			ps.setString(2, username);

			ps.executeUpdate();					
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
	}
	
	// determine correct and password
	public boolean verfyUser (String username, String password) {
		Connection conn = ConnectDB.getConnection();
		String sql = "select * from users where username = ? and password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
		return false;
	}
	
	// calculate user points
	public int sumPoints(String username) {
		Connection conn = ConnectDB.getConnection();
		String sql = "select SUM(points) from achievement join userLine on achievement.event=userLine.event where username=? and stage!=0";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
				
			if (rs.next()) {
				return rs.getInt("SUM(points)");
			}
				
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		} return 0;
	}
	public void updatePoints(String username, int points) {
		Connection conn = ConnectDB.getConnection();
		String sql = "update users set points=? where username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, points);
			ps.setString(2, username);

			ps.executeUpdate();					
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
	}
		
	// calculate user points
	public int rankUser(String username) {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT FIND_IN_SET( points, ( SELECT GROUP_CONCAT( points ORDER BY points DESC ) FROM users )) AS rank FROM users WHERE username =?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
				
			if (rs.next()) {
				return rs.getInt("rank");
			}
				
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		} return 0;
	}
	public void updateRank(String username, int rank) {
		Connection conn = ConnectDB.getConnection();
		String sql = "update users set rank=? where username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rank);
			ps.setString(2, username);

			ps.executeUpdate();					
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
	}
}