package com.brushupproject.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.brushupproject.config.ConfigManager;
import com.brushupproject.listeners.*;


@Listeners({
    TestListener.class,
    RetryListener.class
})
public class BaseTest {

	protected static WebDriver driver;
    protected static Properties properties;
    protected static String browserName, environment, url;

    @Parameters({"browser", "env"})
    @BeforeSuite
    public void oneTimeSetup(@Optional("firefox") String browser, @Optional("prod") String env) {
    	
    	browserName = browser;
    	environment = env;
		url = System.getProperty("env", ConfigManager.getInstance().getBaseUrl());
		
	    DriverFactory.initDriver(browser);
	    driver = DriverFactory.getDriver();
    }

    @BeforeMethod
    public void setup() {

    	driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {

        	driver.quit();
            System.out.println("Closing browser");

            DriverFactory.unload();
        }
    }
    
    // Other methods
    
    public static String getBrowser() {
        return browserName;
    }

    public static String getEnv() {
        return environment;
    }
}