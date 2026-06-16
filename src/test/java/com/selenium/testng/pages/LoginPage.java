package com.selenium.testng.pages;

import static com.selenium.testng.locators.LoginPageLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.testng.base.BasePage;

public class LoginPage extends BasePage {

    private By txtUsername = By.name(USERNAME);

    private By txtPassword = By.name(PASSWORD);

    private By btnLogin = By.xpath(LOGIN_BTN);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    
	// ==========================================
	// FUNCTIONS
	// ==========================================
    
    public boolean loginToPortal(String username, String password) {

		if (actions.waitForClickable(txtUsername) != null) {
			actions.enterText(txtUsername, username);

			actions.enterText(txtPassword, password);

			actions.click(btnLogin);

			return true;
		}
		return false;
	}
}