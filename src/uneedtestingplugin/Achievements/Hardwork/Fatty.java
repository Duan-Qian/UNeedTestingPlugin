/**
 * Achievement Event: Fatty
 * Achievement Category: Hard Work
 * Details: One test suite contains 300 to 999 cases.
 */
package uneedtestingplugin.Achievements.Hardwork;

import uneedtestingplugin.Modal.ProcessData;

public class Fatty {
	
	public boolean fatty (int testCaseNum) {
		if (testCaseNum >= 300 && testCaseNum < 999) {
			String event = "Fatty";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}