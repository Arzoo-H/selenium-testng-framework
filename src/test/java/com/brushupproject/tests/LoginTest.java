package com.brushupproject.tests;

import org.testng.annotations.Test;

import com.brushupproject.base.BaseTest;
import com.brushupproject.pages.LoginPage;
import com.brushupproject.utils.AssertionUtils;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage login = new LoginPage(driver);

        AssertionUtils.assertTrue(login.loginToPortal("Admin", "admin123"), 
        							"Log into the portal");
        
    }
}