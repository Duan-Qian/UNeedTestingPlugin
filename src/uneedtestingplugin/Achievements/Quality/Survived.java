/**
 * Achievement Event: Survived
 * Achievement Category: Quality
 * Details: Only one test case succeeded in one suite (total cases should more than 30).
 */
package uneedtestingplugin.Achievements.Quality;

import uneedtestingplugin.Modal.ProcessData;

public class Survived {
	private static int minCaseNum = 30;
	public boolean survived (int testCaseNum, int successCount) {
		if (testCaseNum >= minCaseNum && successCount == 1) {
			String event = "Survived";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}