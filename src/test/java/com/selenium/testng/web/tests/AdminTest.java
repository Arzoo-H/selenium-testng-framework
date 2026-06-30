package com.selenium.testng.web.tests;

import org.testng.annotations.Test;

import com.selenium.testng.base.BaseTest;
import com.selenium.testng.enums.Menu;
import com.selenium.testng.utils.AssertionUtils;
import com.selenium.testng.web.pages.AdminPage;
import com.selenium.testng.web.pages.DashboardPage;
import com.selenium.testng.web.pages.LoginPage;

public class AdminTest extends BaseTest {

    @Test(groups = {"ui-regression"})
    public void verifyUserExists() {

    	String employeeName = "G Singh", role = "ESS";
    	
        LoginPage login = new LoginPage(driver);

        AssertionUtils.assertTrue(login.loginToPortal("Admin", "admin123"), 
        							"Log into the portal");
        
        DashboardPage dashboardPage = new DashboardPage(driver);
        AssertionUtils.assertTrue(dashboardPage.clickOnMenu(Menu.ADMIN),
        							"Clicked on Admin menu");
        
        AdminPage adminPage = new AdminPage(driver);
        AssertionUtils.assertTrue(adminPage.selectUser(employeeName, role),
        							"Select user " + employeeName);
        
        AssertionUtils.assertTrue(adminPage.clickOnDeleteSelectedUser(),
									"Clicked on Delete Selected user button");
        
        AssertionUtils.assertTrue(adminPage.clickCancelBtnOnDeleteUserModal(),
        							"Clicked on Cancel button on modal popup of Deleting Selected user");
        
    } 
}