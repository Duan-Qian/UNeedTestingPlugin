package uneedtesting.Testing;

import uneedtestingplugin.Achievements.Quality.NotMyFault;

public class AchievementTestHelper {
	public static boolean checkAchievement;
	
	public void updateDBWithAchievement(int testCaseNum, int successCount) {
		NotMyFault nf = new NotMyFault();
		nf.notMyFault(testCaseNum, successCount);

		
		checkAchievement = false;
	}
	
}