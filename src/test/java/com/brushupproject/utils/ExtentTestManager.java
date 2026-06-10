package com.brushupproject.utils;

import com.aventstack.extentreports.ExtentTest;

/**
 * 
 * Responsible for:

	Create/manage test nodes
	Store current test in ThreadLocal
	Return current ExtentTest

 * @author Arzoo Hingorani
 *
 */
public class ExtentTestManager {

    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

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