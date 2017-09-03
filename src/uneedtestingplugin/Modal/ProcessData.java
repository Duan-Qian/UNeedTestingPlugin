/**
 * This method is made for process the achievement events
 */
package uneedtestingplugin.Modal;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import uneedtestingplugin.Animate;
import uneedtestingplugin.DataBase.AchievementDao;
import uneedtestingplugin.DataBase.ConnectDB;

public class ProcessData {
	
	/*
	 * This method is made for process the achievement events
	 * which need be counted.
	 * Method requires event, and condition value of different stages.
	 */
	public void processType1 (String event, int[] count_condition) {
		
		String username = readUsername();
		// update database
		Connection conn = ConnectDB.getConnection();
		AchievementDao ach = new AchievementDao();
		int count = ach.achievementCount(event, username) + 1;
		int stage = ach.stage(event, username);
		int badge = 0;
		String sql = "";
		String sqlCount = "update userLine set count=count+1 where event='" + event + "' and username='" + username + "'";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sqlCount);
			ps.executeUpdate();					
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (count >= count_condition[0] && count< count_condition[1] && stage == 0) {
			sql = "update userLine set stage=1, con="+count_condition[1]+" where event='" + event + "' and username='" + username + "'";
			badge = 1;				
		} else if (count >= count_condition[1] && count < count_condition[2] && stage == 1) {
			sql = "update userLine set stage=2, con="+count_condition[2]+" where event='" + event + "' and username='" + username + "'";
			badge = 2;				
		} else if (count >= count_condition[2] && stage == 2) {
			sql = "update userLine set stage=3 where event='" + event + "' and username='" + username + "'";
			badge = 3;
		}
		if (badge != 0) {
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.executeUpdate();					
				ps.close();
				// set popup message when unlock the achievement
				if (badge == 1) {
					Animate animate = new Animate();
					animate.bronze(event);
				} else if (badge == 2) {
					Animate animate = new Animate();
					animate.silver(event);
				} else if (badge == 3) {
					Animate animate = new Animate();
					animate.gold(event);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * This method is made for process the achievement events
	 * which only need be counted once.
	 * Mainly for the hidden acheivements.
	 */
	public void processType2 (String event, String username, int stage) {
		Connection conn = ConnectDB.getConnection();
		if (stage == 0) {
			String sql = "update userLine set stage=3, count=1 where event='" + event + "' and username='" + username + "'";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.executeUpdate();					
				ps.close();
					
				// set pop-up message when unlock the achievement
				Animate animate = new Animate();
				animate.hiddenAchievement(event);
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// this method is for getting current user name
	public String readUsername(){
		try {
			File file = new File("currentuser.txt");
			FileReader fileReader = new FileReader(file);
			StringBuffer stringBuffer = new StringBuffer();
			int numCharsRead;
			char[] charArray = new char[1024];
			while ((numCharsRead = fileReader.read(charArray)) > 0) {
				stringBuffer.append(charArray, 0, numCharsRead);
			}
			fileReader.close();
			// get current user name
			String username = stringBuffer.toString();
			
			return username;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}