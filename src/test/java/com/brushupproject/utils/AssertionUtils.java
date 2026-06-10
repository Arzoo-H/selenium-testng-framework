package com.brushupproject.utils;

import org.testng.Assert;

public class AssertionUtils {

	public static void assertEquals(String actual, String expected, String stepMessage) {

		try {

			Assert.assertEquals(actual, expected);

			ExtentTestManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {

			ExtentTestManager.getTest().fail(stepMessage);

			throw e;
		}
	}

	public static void assertTrue(boolean condition, String stepMessage) {

		try {

			Assert.assertTrue(condition);

			ExtentTestManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {

			ExtentTestManager.getTest().fail(stepMessage);

			throw e;
		}
	}

	public static void assertFalse(boolean condition, String stepMessage) {

		try {

			Assert.assertFalse(condition);

			ExtentTestManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {

			ExtentTestManager.getTest().fail(stepMessage);

			throw e;
		}
	}

	public static void fail(String stepMessage) {

		ExtentTestManager.getTest().fail(stepMessage);

		Assert.fail(stepMessage);
	}
}