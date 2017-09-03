/**
 * Achievement Event: Happy Valentine's Day!?
 * Achievement Category: Hidden
 * Details: One test suite contains 214 cases.
 */
package uneedtestingplugin.Achievements.Hidden;

import uneedtestingplugin.DataBase.AchievementDao;
import uneedtestingplugin.Modal.ProcessData;

public class Valentine {
	public static boolean check = false;
	
	public void valentine (int testCaseNum) {
		if (testCaseNum == 214) {
			AchievementDao ach = new AchievementDao();
			String event = "Happy Valentine Day!";
			// get current user name
			ProcessData pt = new ProcessData();
			
			// get current user name
			String username = pt.readUsername();
			
			int stage = ach.stage(event, username);
			
			ProcessData pt2 = new ProcessData();
			pt2.processType2(event, username, stage);
			check = true;
		}
	}
}