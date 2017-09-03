package uneedtesting.Testing;

import org.junit.Test;

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
import uneedtestingplugin.Achievements.RealTime.Nightmare;
import uneedtestingplugin.Achievements.RealTime.Reversed;
import uneedtestingplugin.Achievements.Speed.Flash;
import uneedtestingplugin.Achievements.Speed.HaveACoffee;
import uneedtestingplugin.Achievements.Speed.Rocket;
import uneedtestingplugin.Achievements.Speed.TakeANap;
//import uneedtestingplugin.DataBase.AchievementDao;
//import uneedtestingplugin.DataBase.ConnectDB;
//import uneedtestingplugin.DataBase.UserDao;
//import uneedtestingplugin.Modal.ProcessType2;

import static org.junit.Assert.assertEquals;

//import java.sql.Connection;
import java.util.Calendar;

public class AchievementTest {
	
	/*
	 * Failure Category
	 */
	// It Should Pass
	@Test
	public void testShouldPassTrue() {
		ShouldPass shouldPass = new ShouldPass();
		assertEquals(shouldPass.shouldPass(30, 1), true);
	}
	
	@Test
	public void testShouldPassFalse1() {
		ShouldPass shouldPass = new ShouldPass();
		assertEquals(shouldPass.shouldPass(29, 1), false);
	}
	
	@Test
	public void testShouldPassFalse2() {
		ShouldPass shouldPass = new ShouldPass();
		assertEquals(shouldPass.shouldPass(30, 0), false);
	}
	
	@Test
	public void testShouldPassFalse3() {
		ShouldPass shouldPass = new ShouldPass();
		assertEquals(shouldPass.shouldPass(29, 1), false);
	}
	/*
	 * Hard Work Category
	 */
	// Fatty
	@Test
	public void testFattyTrue() {
		Fatty fatty = new Fatty();
		assertEquals(fatty.fatty(310), true);
	}
	
	@Test
	public void testFattyFalse1() {
		Fatty fatty = new Fatty();
		assertEquals(fatty.fatty(299), false);
	}
	
	@Test
	public void testFattyFalse2() {
		Fatty fatty = new Fatty();
		assertEquals(fatty.fatty(999), false);
	}
	
	// JUnit Legend
	@Test
	public void testJUnitLegendTrue() {
		JUnitLegend jUnitLegend = new JUnitLegend();
		assertEquals(jUnitLegend.jUnitLegend(10), true);
	}
	
	@Test
	public void testJUnitLegendFalse() {
		JUnitLegend jUnitLegend = new JUnitLegend();
		assertEquals(jUnitLegend.jUnitLegend(9), false);
	}
	
	// Tough Guy
	@Test
	public void testToughGuyTrue() {
		ToughGuy toughGuy = new ToughGuy();
		assertEquals(toughGuy.toughGuy(999), true);
	}
	
	@Test
	public void testToughGuyFalse() {
		ToughGuy toughGuy = new ToughGuy();
		assertEquals(toughGuy.toughGuy(998), false);
	}
	
	/*
	 * Hidden Achievement Category
	 */
	// Merry Christmas
	@Test
	public void testMerryChristmasTrue() {
		MerryChristmas mc = new MerryChristmas();
		mc.merryChristmas(1225);	
		assertEquals(MerryChristmas.check, true);
	}
	
	@Test
	public void testMerryChristmasFalse() {
		MerryChristmas mc = new MerryChristmas();
		mc.merryChristmas(122);
		assertEquals(MerryChristmas.check, false);
	}
	
	// Valentine
	@Test
	public void testValentineTrue() {
		Valentine v = new Valentine();
		v.valentine(214);
		assertEquals(Valentine.check, true);
		Valentine.check = false;
	}
		
	@Test
	public void testValentineFalse() {
		Valentine v = new Valentine();
		v.valentine(2);
		assertEquals(Valentine.check, false);
	}
	
	// Rings
	@Test
	public void testRingsTrue() {
		Rings r = new Rings();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.AUGUST, 22, 0, 0);
		r.rings(30, time);
		assertEquals(Rings.check, true);
	}
	
	@Test
	public void testRingsFalse1() {
		Rings r = new Rings();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.AUGUST, 22, 0, 0);
		r.rings(29, time);
		assertEquals(Rings.check, false);
	}
	
	@Test
	public void testRingsFalse2() {
		Rings r = new Rings();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.AUGUST, 22, 0, 3);
		r.rings(30, time);
		assertEquals(Rings.check, false);
	}
	/*
	 * Quality Category
	 */
	// Almost
	@Test
	public void testAlmostTrue() { 
		Almost a = new Almost();
		assertEquals(a.almost(30, 1), true);
	}
	
	@Test
	public void testAlmostFalse1() { 
		Almost a = new Almost();
		assertEquals(a.almost(29, 1), false);
	}
	
	@Test
	public void testAlmostFalse2() { 
		Almost a = new Almost();
		assertEquals(a.almost(30, 0), false);
	}
	
	@Test
	public void testAlmostFalse3() { 
		Almost a = new Almost();
		assertEquals(a.almost(30, 2), false);
	}
	
	@Test
	public void testAlmostFalse4() { 
		Almost a = new Almost();
		assertEquals(a.almost(29, 2), false);
	}
	
	// Not My Fault
	@Test
	public void testNotMyFault() {
		NotMyFault notMyFault = new NotMyFault();
		assertEquals(notMyFault.notMyFault(30, 0), true);
	}
	
	@Test
	public void testNotMyFaultFalse1() {
		NotMyFault notMyFault = new NotMyFault();
		assertEquals(notMyFault.notMyFault(24, 0), false);
	}
	
	@Test
	public void testNotMyFaultFalse2() {
		NotMyFault notMyFault = new NotMyFault();
		assertEquals(notMyFault.notMyFault(30, 1), false);
	}
	
	@Test
	public void testNotMyFaultFalse3() {
		NotMyFault notMyFault = new NotMyFault();
		assertEquals(notMyFault.notMyFault(24, 1), false);
	}
	
	// Survived
	@Test
	public void testSurvivedTrue() {
		Survived s = new Survived();
		assertEquals(s.survived(30, 1), true);
	}
	
	@Test
	public void testSurvivedFalse1() {
		Survived s = new Survived();
		assertEquals(s.survived(29, 1), false);
	}
	
	@Test
	public void testSurvivedFalse2() {
		Survived s = new Survived();
		assertEquals(s.survived(30, 0), false);
	}
	
	@Test
	public void testSurvivedFalse3() {
		Survived s = new Survived();
		assertEquals(s.survived(30, 2), false);
	}
	
	@Test
	public void testSurvivedFalse4() {
		Survived s = new Survived();
		assertEquals(s.survived(29, 1), false);
	}
	
	// Well Done
	@Test
	public void testWellDoneTrue() {
		WellDone wd = new WellDone();
		assertEquals(wd.wellDone(30, 0), true);
	}
	
	@Test
	public void testWellDoneFalse1() {
		WellDone wd = new WellDone();
		assertEquals(wd.wellDone(29, 0), false);
	}
	
	@Test
	public void testWellDoneFalse2() {
		WellDone wd = new WellDone();
		assertEquals(wd.wellDone(30, 1), false);
	}
	
	/*
	 * I Love Testing Category
	 */
	@Test
	public void testNightmareTrue1() {
		Nightmare m = new Nightmare();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.MARCH, 4, 0, 0);
		assertEquals(m.nightmare(30, time, 13, 17), true);
	}
	@Test
	public void testNightmareTrue2() {
		Nightmare m = new Nightmare();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.MARCH, 4, 5, 0);
		assertEquals(m.nightmare(30, time, 13, 17), true);
	}
	
	@Test
	public void testNightmareFalse1() {
		Nightmare m = new Nightmare();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.MARCH, 4, 5, 0);
		assertEquals(m.nightmare(29, time, 13, 17), false);
	}
	
	@Test
	public void testNightmareFalse2() {
		Nightmare m = new Nightmare();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.MARCH, 4, 6, 0);
		assertEquals(m.nightmare(30, time, 13, 17), false);
	}
	
	@Test
	public void testNightmareFalse3() {
		Nightmare m = new Nightmare();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.MARCH, 4, 4, 0);
		assertEquals(m.nightmare(30, time, 16, 14), false);
	}
	
	@Test
	public void testNightmareFalse4() {
		Nightmare m = new Nightmare();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.MARCH, 4, 4, 0);
		assertEquals(m.nightmare(30, time, 15, 15), false);
	}
	
	
	// Black and White Reversed
	@Test
	public void testReversedTrue() {
		Reversed r = new Reversed();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.MARCH, 4, 2, 0);
		assertEquals(r.reversed(30, time), true);
	}
	
	@Test
	public void testReversedFalse1() {
		Reversed r = new Reversed();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.MARCH, 4, 2, 0);
		assertEquals(r.reversed(29, time), false);
	}
	
	@Test
	public void testReversedFalse2() {
		Reversed r = new Reversed();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.MARCH, 4, 1, 0);
		assertEquals(r.reversed(30, time), false);
	}
	
	@Test
	public void testReversedFalse3() {
		Reversed r = new Reversed();
		Calendar time = Calendar.getInstance();
		time.set(2017, Calendar.MARCH, 4, 8, 0);
		assertEquals(r.reversed(30, time), false);
	}
	/*
	 * Speed Category
	 */
	// Flash
	@Test
	public void testFlashTrue() {
		Flash f = new Flash();
		assertEquals(f.flash(30, 0.1), true);
	}
	
	@Test
	public void testFlashFalse1() {
		Flash f = new Flash();
		assertEquals(f.flash(29, 0.1), false);
	}
	
	@Test
	public void testFlashFalse2() {
		Flash f = new Flash();
		assertEquals(f.flash(30, 0.11), false);
	}
	
	// Have a Coffee
	@Test
	public void testHaveACoffeeTrue() {
		HaveACoffee hc = new HaveACoffee();
		assertEquals(hc.havaACoffee(30, 600), true);
	}
	
	@Test
	public void testHaveACoffeeFalse1() {
		HaveACoffee hc = new HaveACoffee();
		assertEquals(hc.havaACoffee(29, 600), false);
	}
	
	@Test
	public void testHaveACoffeeFalse2() {
		HaveACoffee hc = new HaveACoffee();
		assertEquals(hc.havaACoffee(30, 599), false);
	}
	
	@Test
	public void testHaveACoffeeFalse3() {
		HaveACoffee hc = new HaveACoffee();
		assertEquals(hc.havaACoffee(30, 901), false);
	}
	
	// Rocket
	@Test
	public void testRicketTrue() {
		Rocket r = new Rocket();
		assertEquals(r.rocket(30, 1), true);
	}
	
	@Test
	public void testRicketFalse1() {
		Rocket r = new Rocket();
		assertEquals(r.rocket(29, 1), false);
	}
	
	@Test
	public void testRicketFalse2() {
		Rocket r = new Rocket();
		assertEquals(r.rocket(30, 0.1), false);
	}
	
	@Test
	public void testRicketFalse3() {
		Rocket r = new Rocket();
		assertEquals(r.rocket(30, 1.1), false);
	}
	
	// Take a Nap
	@Test
	public void testTakeANapTrue() {
		TakeANap tn = new TakeANap();
		assertEquals(tn.takeANap(30, 3600), true);
	}
	
	@Test
	public void testTakeANapFalse1() {
		TakeANap tn = new TakeANap();
		assertEquals(tn.takeANap(29, 3600), false);
	}
	
	@Test
	public void testTakeANapFalse2() {
		TakeANap tn = new TakeANap();
		assertEquals(tn.takeANap(30, 3599), false);
	}
}