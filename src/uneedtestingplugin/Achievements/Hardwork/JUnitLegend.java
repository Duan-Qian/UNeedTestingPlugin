/**
 * Achievement Event: JUnit Legend
 * Achievement Category: Hard Work
 * Details: Do plenty of JUnit test.
 */
package uneedtestingplugin.Achievements.Hardwork;

import uneedtestingplugin.Modal.ProcessData;

public class JUnitLegend {
	private static int minCaseNum = 10;
	public boolean jUnitLegend (int testCaseNum) {
		if (testCaseNum >= minCaseNum) {
			String event = "JUnit Legend";
			int[] count_condition = {999, 3000, 9999};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		} 
		return false;
	}
}