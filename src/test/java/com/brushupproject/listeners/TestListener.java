package com.brushupproject.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.brushupproject.base.BaseTest;
import com.brushupproject.base.DriverFactory;
import com.brushupproject.utils.ExtentManager;
import com.brushupproject.utils.ExtentTestManager;
import com.brushupproject.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private ExtentReports extent = ExtentManager.getInstance();

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

    	System.out.println("Inside onTestStart");
    	
		extent.setSystemInfo("Browser", BaseTest.getBrowser());
		extent.setSystemInfo("Environment", BaseTest.getEnv());
		
        test = extent.createTest(result.getMethod().getMethodName());
        // Assign this ExtentTest to a thread for one testcase/execution
        ExtentTestManager.setTest(test);
        
        System.out.println(ExtentTestManager.getTest());

    	test.info("Launching application");

    	System.out.println("End onTestStart");

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

    	System.out.println("Inside onTestFailure");

        test.fail(result.getThrowable());

        String screenshotPath = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(),
						                        				result.getMethod().getMethodName());

        try {
            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    	System.out.println("End onTestFailure");

    }

    @Override
    public void onFinish(ITestContext context) {

    	System.out.println("Inside onFinish");
    	
        extent.flush();
    	ExtentTestManager.unload();

    	System.out.println("End onFinish");

    }
}