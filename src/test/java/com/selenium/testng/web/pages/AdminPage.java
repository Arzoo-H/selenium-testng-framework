package com.selenium.testng.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import com.selenium.testng.utils.LocatorUtil;
import com.selenium.testng.utils.LoggerUtil;
import com.selenium.testng.web.base.BasePage;
import com.selenium.testng.web.locators.AdminPageLocators;

public class AdminPage extends BasePage {
	
	private static final Logger log = LoggerUtil.getLogger(AdminPage.class);

    public AdminPage(WebDriver driver) {
        super(driver);
    }
  
    By DeleteSelectedBtn = By.xpath(AdminPageLocators.DELETE_SELECTED_BTN);
    By ModalCancelBn = By.xpath(AdminPageLocators.MODAL_CANCEL_BTN);
    
	// ==========================================
	// FUNCTIONS
	// ==========================================
    
	/**
	 * Selects the mentioned user having the employee name and a role
	 * @param employeeName [String] : Employee Name
	 * @param role [String] : Their role
	 * @return true if user is selected
	 * @author Arzoo Hingorani
	 */
	public boolean selectUser(String employeeName, String role) {
		By usernameChk = LocatorUtil.xpath(AdminPageLocators.USERNAME_CHK, employeeName, role);
		try {
			if (actions.waitForClickable(usernameChk) != null) {
				actions.scrollIntoView(usernameChk);
				actions.click(usernameChk);
				log.info("Employee {} having role {} is selected", employeeName, role);
				
				if(actions.getAttribute(usernameChk, "class").contains("focus"))
					return true;
			}
		} catch (Exception e) {
			log.error("Could not select employee {} having role {}", employeeName, role, e);
		}
		return false;
	}
	
	/**
	 * Click on Delete Selected user button
	 * @return true if button is clicked
	 * @author Arzoo Hingorani
	 */
	public boolean clickOnDeleteSelectedUser() {
		try {
			if (actions.waitForClickable(DeleteSelectedBtn) != null) {
				actions.scrollIntoView(DeleteSelectedBtn);
				actions.click(DeleteSelectedBtn);
				log.info("Clicked on Delete Selected button");
				return true;
			}
		} catch (Exception e) {
			log.error("Could not click on Delete Selected button", e);
		}
		return false;
	}
	
	/**
	 * Click on Cancel button on the Delete selected user popup
	 * @return true if button is clicked
	 * @author Arzoo Hingorani
	 */
	public boolean clickCancelBtnOnDeleteUserModal() {
		try {
			if (actions.waitForClickable(ModalCancelBn) != null) {
				actions.click(ModalCancelBn);
				log.info("Clicked on Cancel button on Modal popup");
				return true;
			}
		} catch (Exception e) {
			log.error("Could not click on Cancel button on Modal popup", e);
		}
		return false;
	}
}