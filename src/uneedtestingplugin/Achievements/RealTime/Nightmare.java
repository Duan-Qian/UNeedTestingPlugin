/**
 * Achievement Event: Nightmare
 * Achievement Category: Real Time
 * Details: Run a suite during 23:00 and 5:00 with more than 50% cases failed (cases should more than 30).
 */
package uneedtestingplugin.Achievements.RealTime;

import java.util.Calendar;

import uneedtestingplugin.Modal.ProcessData;

public class Nightmare {
	private static int minCaseNum = 30;
	public boolean nightmare (int testCaseNum, Calendar currTime, int successCount, int failureCount) {		
		if (testCaseNum >= minCaseNum && currTime.get(Calendar.HOUR_OF_DAY) >= 0 && currTime.get(Calendar.HOUR_OF_DAY) <= 5 && failureCount > successCount) {
			String event = "Nightmare";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}