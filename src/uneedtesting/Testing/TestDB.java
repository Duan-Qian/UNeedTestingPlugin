package uneedtesting.Testing;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import uneedtestingplugin.DataBase.AchievementDao;
import uneedtestingplugin.DataBase.MD5;
//import uneedtestingplugin.DataBase.NewUser;
import uneedtestingplugin.DataBase.UserDao;
import uneedtestingplugin.Modal.AchievementProcess;

public class TestDB {
	
	AchievementDao ad = new AchievementDao();
	UserDao ud = new UserDao();

	// MD5 method
	@SuppressWarnings("static-access")
	@Test
	public void testMD5() {
		MD5 m = new MD5();
		assertEquals(m.transMD5("duan"), "c275ddb09fc435b77521ba4e104c8dde95b40d86");	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMD52() {
		MD5 m = new MD5();
		assertEquals(m.transMD5(""), "");
	}
	
//	// new user
//	@Test
//	public void testNewUser() {
//		String username = "duan";
//		NewUser nu = new NewUser();
//		nu.newUser(username);
//		assertEquals(NewUser.test, false);
//	}
//	
//	@Test
//	public void testNewUser2() {
//		String username = "111";
//		NewUser nu =  new NewUser();
//		nu.newUser(username);
//		assertEquals(NewUser.test, false);
//		ud.deleteUserByName(username);
//	}
	
	@Test
	public void testGetDescription() {
		assertEquals(ad.getDescription("Almost"), "Only one test case failed in one suite (total cases should more than 30).");
	}
	
	@Test
	public void testAchievementCount() {
		assertEquals(ad.achievementCount("Almost", "qian"), 17);
	}
	
	@Test
	public void testStage() {
		assertEquals(ad.stage("Almost", "qian"), 2);
	}
	
	@Test
	public void testVerifyUser() {
		assertEquals(ud.verfyUser("Jack", "jack"), true);
	}
	
	@Test
	public void testVerifyUserFalse() {
		assertEquals(ud.verfyUser("Jack", "duan"), false);
	}
	
	@Test
	public void testSumPoints() {
		assertEquals(ud.sumPoints("qian"), 70);
	}
	
	@Test
	public void testSumPointsFalse() {
		assertEquals(ud.sumPoints("qianqian"), 0);
	}
	
	@Test
	public void testRankUser() {
		assertEquals(ud.rankUser("qian"), 1);
	}
	
	@Test
	public void testRankUserFalse() {
		assertEquals(ud.rankUser("qianqian"), 0);
	}
	
	@Test
	public void testAchievementProcess() {
		AchievementProcess ap = new AchievementProcess();
		Calendar currTime = Calendar.getInstance();
		ap.achievementProcess(30, 29, 1, 1, currTime, false);
	}
}