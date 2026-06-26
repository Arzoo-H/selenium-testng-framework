package com.selenium.testng.utils;

import org.testng.Assert;

import io.restassured.response.Response;

public class AssertionUtils {

	public static void assertEquals(String actual, String expected, String stepMessage) {

		try {
			Assert.assertEquals(actual, expected);
			ExtentManager.getTest().pass(stepMessage);
			
		} catch (AssertionError e) {
			ExtentManager.getTest().fail(stepMessage + "<br>" + e.getMessage());
			throw e;
		}
	}

	public static void assertTrue(boolean condition, String stepMessage) {

		try {
			Assert.assertTrue(condition);
			ExtentManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {
			ExtentManager.getTest().fail(stepMessage + "<br>" + e.getMessage());
			throw e;
		}
	}

	public static void assertFalse(boolean condition, String stepMessage) {

		try {
			Assert.assertFalse(condition);
			ExtentManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {
			ExtentManager.getTest().fail(stepMessage + "<br>" + e.getMessage());
			throw e;
		}
	}

	public static void fail(String stepMessage) {

		ExtentManager.getTest().fail(stepMessage);
		Assert.fail(stepMessage);
	}

	// For API Assertins
	public static void assertStatusCode(Response response, int expectedStatusCode, String stepMessage) {

		try {
			Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
			ExtentManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {
			ExtentManager.getTest().fail(stepMessage + "<br>" + e.getMessage());
			throw e;
		}
	}

	public static void assertJsonPathEquals(Response response, String jsonPath, String expectedValue,
			String stepMessage) {

		try {
			Assert.assertEquals(response.jsonPath().getString(jsonPath), expectedValue);
			ExtentManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {
			ExtentManager.getTest().fail(stepMessage + "<br>" + e.getMessage());
			throw e;
		}
	}

	public static void assertResponseTimeLessThan(Response response, long expectedTimeInMillis, String stepMessage) {

		try {
			Assert.assertTrue(response.getTime() < expectedTimeInMillis);
			ExtentManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {
			ExtentManager.getTest().fail(stepMessage + "<br>" + e.getMessage());
			throw e;
		}
	}

	public static void assertJsonPathNotNull(Response response, String jsonPath, String stepMessage) {

		try {
			Assert.assertNotNull(response.jsonPath().get(jsonPath));
			ExtentManager.getTest().pass(stepMessage);

		} catch (AssertionError e) {
			ExtentManager.getTest().fail(stepMessage + "<br>" + e.getMessage());
			throw e;
		}
	}
}