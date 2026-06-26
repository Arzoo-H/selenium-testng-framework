package com.selenium.testng.api.clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserApiClient {

	public Response getUser(int id) {

		return given().when().get("/api/users/" + id);
	}
}
