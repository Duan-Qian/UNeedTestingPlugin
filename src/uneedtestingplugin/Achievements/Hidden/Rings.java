/**
 * Achievement Event: Ring
 * Achievement Category: Hidden
 * Details: Run a test suite during 00:00 and 00:01.
 */
package uneedtestingplugin.Achievements.Hidden;

import java.util.Calendar;

import uneedtestingplugin.DataBase.AchievementDao;
import uneedtestingplugin.Modal.ProcessData;

public class Rings {
	public static boolean check = false;
	private static int minCaseNum = 30;
	public void rings (int testCaseNum, Calendar testTime) {
		if (testCaseNum >= minCaseNum && testTime.get(Calendar.HOUR_OF_DAY) == 0 && testTime.get(Calendar.MINUTE) >= 0 && testTime.get(Calendar.MINUTE) <= 1 ) {
			AchievementDao ach = new AchievementDao();
			String event = "Rings";
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