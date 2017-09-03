/**
 * Achievement Event: It Should Pass
 * Achievement Category: Quality
 * Details: The suite which has more than 10 cases, but failed.
 */
package uneedtestingplugin.Achievements.Failure;

import uneedtestingplugin.Modal.ProcessData;

public class ShouldPass {
	private static int minCaseNum = 30;
	public boolean shouldPass (int testCaseNum, int failureCount) {
		if (testCaseNum >= minCaseNum && failureCount > 0) {
			String event = "It Should Pass";
			int[] count_condition = {50, 300, 1000};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}