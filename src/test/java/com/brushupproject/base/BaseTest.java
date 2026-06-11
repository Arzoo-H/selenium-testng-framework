package com.brushupproject.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.brushupproject.config.ConfigManager;
import com.brushupproject.listeners.*;


@Listeners({
    TestListener.class,
    RetryListener.class
})
public class BaseTest {

    protected WebDriver driver;
    protected static Properties properties;
    protected static String browser, env, url;

    
    @BeforeSuite
    public void oneTimeSetup() {
    	
		browser = System.getProperty("browser", ConfigManager.getInstance().getBrowser());
		env = System.getProperty("env", ConfigManager.getInstance().getEnv());
		url = System.getProperty("env", ConfigManager.getInstance().getBaseUrl());
		
    }

    @BeforeMethod
    public void setup() {

    	driver = new ChromeDriver();

        DriverFactory.setDriver(driver);

        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (DriverFactory.getDriver() != null) {

            DriverFactory.getDriver().quit();
            System.out.println("Closing browser");

            DriverFactory.unload();
        }
    }
    
    // Other methods
    
    public static String getBrowser() {
        return browser;
    }

    public static String getEnv() {
        return env;
    }
}