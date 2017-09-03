/**
 * Achievement Event: Merry Christmas
 * Achievement Category: Hidden
 * Details: One test suite contains 1225 cases.
 */
package uneedtestingplugin.Achievements.Hidden;

import uneedtestingplugin.DataBase.AchievementDao;
import uneedtestingplugin.Modal.ProcessData;

public class MerryChristmas {
	public static boolean check = false;
	public void merryChristmas (int testCaseNum) {
		if (testCaseNum == 1225) {
			AchievementDao ach = new AchievementDao();
			String event = "Merry Christmas";
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