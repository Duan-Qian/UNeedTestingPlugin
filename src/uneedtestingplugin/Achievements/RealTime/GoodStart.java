package uneedtestingplugin.Achievements.RealTime;

import uneedtestingplugin.DataBase.AchievementDao;
import uneedtestingplugin.Modal.ProcessData;

public class GoodStart {
	public void goodStart (int testCaseNum) {
		if (testCaseNum >= 1 ) {
			AchievementDao ach = new AchievementDao();
			String event = "Good Start";
			// get current user name
			ProcessData pt = new ProcessData();
			
			// get current user name
			String username = pt.readUsername();

			int stage = ach.stage(event, username);
			ProcessData pt2 = new ProcessData();
			pt2.processType2(event, username, stage);
		}
	}
}
