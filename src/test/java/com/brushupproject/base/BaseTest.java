package com.brushupproject.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.initDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null)
            driver.quit();
    }
}