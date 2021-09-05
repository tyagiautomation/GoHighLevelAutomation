package com.GHH.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.GHH.utility.ExtentManager;
import com.GHH.utility.ExtentTestManager;
import com.GHH.utility.getScreenShot;

import com.aventstack.extentreports.Status;

public class TestListners extends baseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Started.....");
		Reporter.log("Method name is - " + result.getName());
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed : " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed.....");
		getScreenShot.takeScreenshotAtEndOfTest();
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed : " + result.getMethod().getMethodName());

		ExtentTestManager.getTest().addScreenCaptureFromPath(getScreenShot.takeScreenshotAtEndOfTest());

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Test Result is - " + result.getStatus());
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped : " + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("Test Started.....");
		// getScreenShot.takeScreenshotAtEndOfTest();
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

}
