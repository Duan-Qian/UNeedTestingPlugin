/**
 * Achievement Event: Have a Coffee
 * Achievement Category: Speed
 * Details:
 */
package uneedtestingplugin.Achievements.Speed;

import uneedtestingplugin.Modal.ProcessData;

public class HaveACoffee {
	private static int minCaseNum = 30;
	public boolean havaACoffee (int testCaseNum, double totalTime) {
		// test case number should more than 30, and test run time between 10 minutes and 15 minutes
		if (testCaseNum >= minCaseNum && totalTime >= 600 && totalTime <= 900) {
			String event = "Have a Coffee";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}