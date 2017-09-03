/**
 * Achievement Event: Flash
 * Achievement Category: Speed
 * Details: One test suite contains at least 30 cases that takes less than 0.1 second to execute.
 */
package uneedtestingplugin.Achievements.Speed;

import uneedtestingplugin.Modal.ProcessData;

public class Flash {
	private static int minCaseNum = 30;
	
	public boolean flash (int testCaseNum, double totalTime) {
		if (testCaseNum >= minCaseNum && totalTime <= 0.1) {
			String event = "Flash";
			int[] count_condition = {10, 15, 100};
			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}