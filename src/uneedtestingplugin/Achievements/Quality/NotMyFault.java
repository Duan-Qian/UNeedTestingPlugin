/**
 * Achievement Event: It's not My Fault
 * Achievement Category: Quality
 * Details: All test cases failed in one suite (cases should more than 30).
 */
package uneedtestingplugin.Achievements.Quality;

import uneedtestingplugin.Modal.ProcessData;

public class NotMyFault {
	private static int minCaseNum = 30;
	public boolean notMyFault (int testCaseNum, int successCount) {
		if (testCaseNum >= minCaseNum && successCount == 0) {
			String event = "Not My Fault";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}