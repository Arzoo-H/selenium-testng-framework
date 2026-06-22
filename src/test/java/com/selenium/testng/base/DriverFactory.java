package com.selenium.testng.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver(String browser, boolean headless) {

		WebDriver webDriver;

		switch (browser.toLowerCase()) {

		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();

			if (headless) {
				chromeOptions.addArguments("--headless=new");
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("--disable-dev-shm-usage");
			}

			webDriver = new ChromeDriver(chromeOptions);
			break;

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();

			if (headless) {
				firefoxOptions.addArguments("-headless");
			}

			webDriver = new FirefoxDriver(firefoxOptions);
			break;

		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();

			if (headless) {
				edgeOptions.addArguments("--headless=new");
				edgeOptions.addArguments("--no-sandbox");
				edgeOptions.addArguments("--disable-dev-shm-usage");
			}

			webDriver = new EdgeDriver(edgeOptions);
			break;

		case "safari":
			webDriver = new SafariDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		webDriver.manage().window().maximize();

		driver.set(webDriver);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void unload() {
		driver.remove();
	}
}
