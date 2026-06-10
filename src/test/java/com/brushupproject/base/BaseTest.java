package com.brushupproject.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

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
    	
		properties = new Properties();

		/*
		 * When Maven builds the project, everything under: 'src/test/resources' is copied to: 'target/test-classes'
		 * which is automatically added to the classpath during test execution.
		 * 
		 * If your file is inside a folder 'src/test/resources/config/config.properties' 
		 * Then you must use: getResourceAsStream("config/config.properties");
		 */
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {

			if (input == null) {
				throw new RuntimeException("config.properties not found in classpath");
			}
			
			properties.load(input);

		} catch (IOException e) {

			throw new RuntimeException("Failed to load config.properties", e);
		}

		browser = System.getProperty("browser", properties.getProperty("browser"));
		env = System.getProperty("env", properties.getProperty("environment"));
		url = System.getProperty("env", properties.getProperty("url"));
		
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