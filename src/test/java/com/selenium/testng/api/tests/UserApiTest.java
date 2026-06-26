package com.selenium.testng.api.tests;

import org.testng.annotations.Test;

import com.selenium.testng.api.base.BaseApiTest;
import com.selenium.testng.api.clients.UserApiClient;
import com.selenium.testng.utils.AssertionUtils;

import io.restassured.response.Response;

public class UserApiTest extends BaseApiTest {

	@Test(groups = { "api-smoke" })
	public void verifyUserExists() {

		UserApiClient userApi = new UserApiClient();

		Response response = userApi.getUser(2);

		AssertionUtils.assertStatusCode(response, 
										200, 
										"Verified status code is 200");

		AssertionUtils.assertJsonPathEquals(response, 
											"data.first_name", 
											"Janet", 
											"Verified first name is Janet");

		AssertionUtils.assertResponseTimeLessThan(response, 
													2000, 
													"Verified response time is less than 2 seconds");

		AssertionUtils.assertJsonPathNotNull(response, 
												"data.email", 
												"Verified email is present");
	}
}