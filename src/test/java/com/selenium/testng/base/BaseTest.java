package com.selenium.testng.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.selenium.testng.config.ConfigManager;
import com.selenium.testng.config.LoggerConfig;
import com.selenium.testng.listeners.*;


@Listeners({
    TestListener.class,
    RetryListener.class
})
public class BaseTest {

	protected WebDriver driver;
    protected String url;

    @BeforeSuite
    public void oneTimeSetup() {
    	
    	// Programmatically setting log file details instead setting in Logback.xml
    	// because Logback reads logback.xml before our code gets a chance to set logFileName with 
    	// same runID as ExtentReport and Screenshot
    	LoggerConfig.configure();
    }

    @Parameters({"browser", "env"})
    @BeforeMethod
    public void setup(@Optional("firefox") String browser, @Optional("prod") String env) {

    	// Set details to a POJO class that has threadlocal to maintain details for parallel execution
    	TestContext.setContext(new TestContext(browser, env));
    	
    	DriverFactory.initDriver(browser);
	    driver = DriverFactory.getDriver();
	    
	    url = ConfigManager.getInstance().getUrl(env);
    	driver.get(url);
    	
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {

        	driver.quit();
            System.out.println("Closing browser");

            DriverFactory.unload();
        }
        
        TestContext.unload(); // Otherwise the ThreadLocal value remains attached to the thread until the JVM decides to clean it up.
    }
}