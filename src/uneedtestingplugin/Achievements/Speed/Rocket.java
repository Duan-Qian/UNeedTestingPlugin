/**
 * Achievement Event: Rocket
 * Achievement Category: Speed
 * Details: One test suite contains at least 30 cases that takes 0.1 to 1 second to execute.
 */
package uneedtestingplugin.Achievements.Speed;

import uneedtestingplugin.Modal.ProcessData;

public class Rocket {
	private static int minCaseNum = 30;
	
	public boolean rocket (int testCaseNum, double totalTime) {
		if (testCaseNum >= minCaseNum && totalTime > 0.1 && totalTime <= 1) {
			String event = "Rocket";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}