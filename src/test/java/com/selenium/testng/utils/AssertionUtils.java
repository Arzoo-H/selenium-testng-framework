package com.selenium.testng.utils;

import org.testng.Assert;

public class AssertionUtils {

	public static void assertEquals(String actual, String expected, String stepMessage) {

		try {

			Assert.assertEquals(actual, expected);

			ExtentManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {

			ExtentManager.getTest().fail(stepMessage);

			throw e;
		}
	}

	public static void assertTrue(boolean condition, String stepMessage) {

		try {

			Assert.assertTrue(condition);

			ExtentManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {

			ExtentManager.getTest().fail(stepMessage);

			throw e;
		}
	}

	public static void assertFalse(boolean condition, String stepMessage) {

		try {

			Assert.assertFalse(condition);

			ExtentManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {

			ExtentManager.getTest().fail(stepMessage);

			throw e;
		}
	}

	public static void fail(String stepMessage) {

		ExtentManager.getTest().fail(stepMessage);

		Assert.fail(stepMessage);
	}
}