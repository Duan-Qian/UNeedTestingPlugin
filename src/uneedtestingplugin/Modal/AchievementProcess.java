/**
 * This method collects test result from TestRunListener, and passes result data to each achievement condition.
 */
package uneedtestingplugin.Modal;

import java.util.Calendar;

import uneedtestingplugin.Popout;
import uneedtestingplugin.Achievements.Failure.ShouldPass;
import uneedtestingplugin.Achievements.Hardwork.Fatty;
import uneedtestingplugin.Achievements.Hardwork.JUnitLegend;
import uneedtestingplugin.Achievements.Hardwork.ToughGuy;
import uneedtestingplugin.Achievements.Hidden.MerryChristmas;
import uneedtestingplugin.Achievements.Hidden.Rings;
import uneedtestingplugin.Achievements.Hidden.Valentine;
import uneedtestingplugin.Achievements.Quality.Almost;
import uneedtestingplugin.Achievements.Quality.NotMyFault;
import uneedtestingplugin.Achievements.Quality.Survived;
import uneedtestingplugin.Achievements.Quality.WellDone;
import uneedtestingplugin.Achievements.RealTime.GoodStart;
import uneedtestingplugin.Achievements.RealTime.Nightmare;
import uneedtestingplugin.Achievements.RealTime.Reversed;
import uneedtestingplugin.Achievements.Speed.Flash;
import uneedtestingplugin.Achievements.Speed.HaveACoffee;
import uneedtestingplugin.Achievements.Speed.Rocket;
import uneedtestingplugin.Achievements.Speed.TakeANap;
import uneedtestingplugin.DataBase.UserDao;

public class AchievementProcess {
	public void achievementProcess(int testCaseNum, int successCount, int failureCount, double totalTime, Calendar currTime, boolean allPass) {
		
		/*
		 * Speed Category
		 */
		// FLash
		Flash flash = new Flash();
		flash.flash(testCaseNum, totalTime);
		
		// Rocket
		Rocket rocket = new Rocket();
		rocket.rocket(testCaseNum, totalTime);
		
		// Have a Coffee
		HaveACoffee haveACoffee = new HaveACoffee();
		haveACoffee.havaACoffee(testCaseNum, totalTime);
		
		// Take a Nap
		TakeANap takeANap = new TakeANap();
		takeANap.takeANap(testCaseNum, totalTime);
		
		/*
		 * Hidden Achievement Category
		 */
		// Ring
		Rings rings = new Rings();
		rings.rings(testCaseNum, currTime);
		
		// Merry Christmas
		MerryChristmas merryChristmas = new MerryChristmas();
		merryChristmas.merryChristmas(testCaseNum);
		
		// Happy Valentine's Day!?
		Valentine valentine = new Valentine();
		valentine.valentine(testCaseNum);
		
		/*
		 * Quality Category
		 */
		// Well Done
		WellDone wellDone = new WellDone();
		wellDone.wellDone(testCaseNum, failureCount);
		
		// Almost
		Almost almost = new Almost();
		almost.almost(testCaseNum, failureCount);
		
		// It's Not My Fault
		NotMyFault notMyFault = new NotMyFault();
		notMyFault.notMyFault(testCaseNum, successCount);
		
		// Survived
		Survived survived = new Survived();
		survived.survived(testCaseNum, successCount);
		
		/*
		 * Hard Work Category
		 */
		// JUnit Legend
		JUnitLegend jUnitLegend = new JUnitLegend();
		jUnitLegend.jUnitLegend(testCaseNum);
		
		// Fatty
		Fatty fatty = new Fatty();
		fatty.fatty(testCaseNum);
		
		// Tough Guy
		ToughGuy toughGuy = new ToughGuy();
		toughGuy.toughGuy(testCaseNum);
		
		/*
		 * I Love Testing Category
		 */
		// Nightmare
		Nightmare nightmare = new Nightmare();
		nightmare.nightmare(testCaseNum, currTime, successCount, failureCount);
		
		// Black and White Reversed
		Reversed reversed = new Reversed();
		reversed.reversed(testCaseNum, currTime);
		
		// Good Start
		GoodStart gs = new GoodStart();
		gs.goodStart(testCaseNum);
		
		/*
		 * Failure Category
		 */
		// It Should Pass
		ShouldPass shouldPass = new ShouldPass();
		shouldPass.shouldPass(testCaseNum, failureCount);
		
		/*
		 * Update user points and rank info
		 */
		// get current user name
		ProcessData pt = new ProcessData();
		String username = pt.readUsername();
		if (username.equals("") || username.equals(null) || username.equals("null")) {
			Popout po = new Popout();
			po.loginForm();
		}
					
		// update user rank and points
		UserDao userDao = new UserDao();
		int points = userDao.sumPoints(username);
		userDao.updatePoints(username, points);
		int rank = userDao.rankUser(username);
		userDao.updateRank(username, rank);
		
		userDao.saveTestCaseNum(testCaseNum, username);

	}
}