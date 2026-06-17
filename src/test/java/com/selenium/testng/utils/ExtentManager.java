package com.selenium.testng.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String reportPath = System.getProperty("user.dir")
			                    + "/reports/ExtentReport_"
			                    + timestamp
			                    + ".html";

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
