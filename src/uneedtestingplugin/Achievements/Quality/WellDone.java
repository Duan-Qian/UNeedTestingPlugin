/**
 * Achievement Event: Well Done
 * Achievement Category: Quality
 * Details: All test cases succeeded in one suite (cases should more than 30).
 */
package uneedtestingplugin.Achievements.Quality;

import uneedtestingplugin.Modal.ProcessData;

public class WellDone {
	private static int minCaseNum = 30;
	public boolean wellDone (int testCaseNum, int failureCount) {
		if (testCaseNum >= minCaseNum && failureCount == 0) {
			String event = "Well Done";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}