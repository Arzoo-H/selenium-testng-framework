package com.selenium.testng.tests;

import org.testng.annotations.Test;

import com.selenium.testng.base.BaseTest;
import com.selenium.testng.pages.LoginPage;
import com.selenium.testng.utils.AssertionUtils;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage login = new LoginPage(driver);

        AssertionUtils.assertTrue(login.loginToPortal("Admin", "admin123"), 
        							"Log into the portal");
        
    }
}