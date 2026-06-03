package com.brushupproject.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;

import com.brushupproject.base.DriverFactory;
import com.brushupproject.utils.ExtentManager;
import com.brushupproject.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private ExtentReports extent = ExtentManager.getInstance();

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
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
    }
}