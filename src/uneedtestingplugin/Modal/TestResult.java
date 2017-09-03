package uneedtestingplugin.Modal;

import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.jdt.junit.model.ITestElement.Result;
import org.eclipse.jdt.junit.model.ITestRunSession;

import java.util.Calendar;

import org.eclipse.jdt.junit.TestRunListener;

public class TestResult extends TestRunListener {
	private int testCaseNum;
	private double totalTime;
	private int successCount;
	private int failureCount;
	private Boolean allPass = true;
	
	@Override
	public void sessionFinished(ITestRunSession session) {
		Calendar currTime = Calendar.getInstance();
		totalTime = session.getElapsedTimeInSeconds();
		
		System.out.println("Test Case Total Num: " + testCaseNum);
		System.out.println("TotalTime: " + session.getElapsedTimeInSeconds());
		System.out.println("Fail Case Num: " + failureCount);
		System.out.println("Success Case Num: " + successCount);
		System.out.println("Is all cases passed: " + allPass);
		
		// Pass test result to achievement condition method
		AchievementProcess achievementProcess = new AchievementProcess();
		achievementProcess.achievementProcess(testCaseNum, successCount, failureCount, totalTime, currTime, allPass);
		
		// Initialise the parameter
		failureCount = 0;
		successCount = 0;
		testCaseNum = 0;
	}
	@Override
	public void testCaseFinished(ITestCaseElement testCaseElement) {
		// count case number
		testCaseNum++;		

		// count passed case number, and failed case number 
		Result failureCase = testCaseElement.getTestResult(true);
		String failureCaseString = failureCase.toString();
		if (failureCaseString.equals("Failure")) {
			failureCount++;
			allPass = false;
		} else if (failureCaseString.equals("OK")){
			successCount++;
		}
	}

}
