package com.brushupproject.tests;

import org.testng.annotations.Test;

import com.brushupproject.base.BaseTest;
import com.brushupproject.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage login = new LoginPage(driver);

        login.login("Admin", "admin123");
    }
}