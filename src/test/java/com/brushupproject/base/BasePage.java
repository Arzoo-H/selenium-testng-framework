package com.brushupproject.base;

import org.openqa.selenium.WebDriver;

import com.brushupproject.utils.ElementActions;

public class BasePage {

    protected WebDriver driver;
    protected ElementActions actions;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.actions = new ElementActions(driver);
    }
}
