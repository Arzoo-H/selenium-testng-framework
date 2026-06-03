package com.brushupproject.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String screenshotPath = System.getProperty("user.dir")
				                + "/reports/screenshots/"
				                + testName + "_"
				                + timestamp + ".png";

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {

            Files.createDirectories(new File(screenshotPath)
		                            .getParentFile()
		                            .toPath());

            Files.copy(source.toPath(),
	                    new File(screenshotPath).toPath(),
	                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
