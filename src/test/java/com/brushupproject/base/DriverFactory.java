package com.brushupproject.base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	// Framework supports parallel execution using ThreadLocal WebDriver.
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void unload() {
        driver.remove();
    }
}
