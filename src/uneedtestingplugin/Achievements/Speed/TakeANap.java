/**
 * Achievement Event: Take a Nap
 * Achievement Category: Speed
 * Details: One test suite contains at least 30 cases that takes more than 1 hour to execute.
 */
package uneedtestingplugin.Achievements.Speed;

import uneedtestingplugin.Modal.ProcessData;

public class TakeANap {
	private static int minCaseNum = 30;
	public boolean takeANap (int testCaseNum, double totalTime) {
		if (testCaseNum >= minCaseNum && totalTime >= 3600) {
			String event = "Take a Nap";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}