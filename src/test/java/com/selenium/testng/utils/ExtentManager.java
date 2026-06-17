package com.selenium.testng.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.testng.config.ExecutionContext;

/**
 * 
 * Responsible for:

	Create report
	Configure report
	Attach reporter
	Flush report
	
 * @author Arzoo Hingorani
 * 
 */
public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportPath = ExecutionContext.getReportPath();

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();

            extent.attachReporter(spark);

            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("UI Automation Results");
        }

        return extent;
    }
    
    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void unload() {
        extentTest.remove();
    }
}
