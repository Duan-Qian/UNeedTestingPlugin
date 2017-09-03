/**
 * Achievement Event: Tough Guy
 * Achievement Category: Hard Work
 * Details: One test suite contains more than 999 cases.
 */
package uneedtestingplugin.Achievements.Hardwork;

import uneedtestingplugin.Modal.ProcessData;

public class ToughGuy {
	
	public boolean toughGuy (int testCaseNum) {
		if (testCaseNum >= 999) {
			String event = "Tough Guy";
			int[] count_condition = {10, 15, 100};

			ProcessData pt1 = new ProcessData();
			pt1.processType1(event, count_condition);
			return true;
		}
		return false;
	}
}