/**
 * Achievement Event: ALmost
 * Achievement Category: Quality
 * Details: In one test suite which contains more than 30 cases, only one case failed.
 */
package uneedtestingplugin.Achievements.Quality;

import uneedtestingplugin.Modal.ProcessData;

public class Almost {
	private static int minCaseNum = 30;
	public boolean almost (int testCaseNum, int failureCount) {
		if (testCaseNum >= minCaseNum && failureCount == 1) {
			String event = "Almost";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}