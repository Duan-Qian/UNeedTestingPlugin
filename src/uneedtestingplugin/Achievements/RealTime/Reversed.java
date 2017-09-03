/**
 * Achievement Event: Black and White Reversed
 * Achievement Category: Real Time
 * Details: Run a suite during 02:00 and 07:00 (cases should more than 30).
 */
package uneedtestingplugin.Achievements.RealTime;

import java.util.Calendar;

import uneedtestingplugin.Modal.ProcessData;

public class Reversed {
	private static int minCaseNum = 30;
	public boolean reversed (int testCaseNum, Calendar currTime) {
		if (testCaseNum >= minCaseNum && currTime.get(Calendar.HOUR_OF_DAY) >= 2 && currTime.get(Calendar.HOUR_OF_DAY) <= 7) {
			String event = "Black and White Reversed";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}