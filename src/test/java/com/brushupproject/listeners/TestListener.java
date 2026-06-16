package com.brushupproject.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.brushupproject.base.DriverFactory;
import com.brushupproject.base.TestContext;
import com.brushupproject.utils.ExtentManager;
import com.brushupproject.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private ExtentReports extent = ExtentManager.getInstance();

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
        // Assign this ExtentTest to a thread for one testcase/execution
        ExtentManager.setTest(test);
        
    	test.info("Launching application");
		test.assignCategory(TestContext.getContext().getBrowser()); // used to create filter tests by browser detail/category like chrome, firefox etc
    	test.info("Browser: " + TestContext.getContext().getBrowser());
		test.info("Environment : " + TestContext.getContext().getEnv());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String screenshotPath = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(),
						                        				result.getMethod().getMethodName());

        try {
            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void onFinish(ITestContext context) {
    	
        extent.flush();
        ExtentManager.unload();

    }
}