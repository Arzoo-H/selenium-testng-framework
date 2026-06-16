package com.brushupproject.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver(String browser) {

		WebDriver webDriver;

		switch (browser.toLowerCase()) {

		case "chrome":
			webDriver = new ChromeDriver();
			break;

		case "firefox":
			webDriver = new FirefoxDriver();
			break;

		case "edge":
			webDriver = new EdgeDriver();
			break;

		case "safari":
			webDriver = new SafariDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.set(webDriver);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void unload() {
		driver.remove();
	}
}
