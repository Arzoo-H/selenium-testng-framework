package com.brushupproject.config;

import java.io.InputStream;
import java.util.Properties;


/**
 * 
 * I implemented ConfigManager as a Singleton using getInstance() to ensure a single configuration object per JVM. 
 * This avoids repeated loading and follows standard design pattern naming conventions for clarity.
 * @author Arzoo Hingorani
 *
 */
public class ConfigManager {

	private static ConfigManager instance;
	private Properties properties;

	// private constructor -> prevents external instantiation
	private ConfigManager() {

		properties = new Properties();

		/*
		 * When Maven builds the project, everything under: 'src/test/resources' is copied to: 'target/test-classes'
		 * which is automatically added to the classpath during test execution.
		 * 
		 * If your file is inside a folder 'src/test/resources/config/config.properties' 
		 * Then you must use: getResourceAsStream("config/config.properties");
		 */
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {

			if (input != null) {
				properties.load(input);
			} else 
				throw new RuntimeException("config.properties not found in classpath");

		} catch (Exception e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	// global access point
	public static ConfigManager getInstance() {

		if (instance == null) {
			instance = new ConfigManager();
		}

		return instance;
	}

	// helper methods (clean API)
	// passing 'chrome' for browser is to imply by default we choose chrome
	public String getBaseUrl() {
		return properties.getProperty("url");
	}

}
