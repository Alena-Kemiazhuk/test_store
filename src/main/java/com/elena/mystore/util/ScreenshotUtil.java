package com.elena.mystore.util;


import com.elena.mystore.core.driver.DriverManager;
import lombok.experimental.UtilityClass;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

@UtilityClass
public final class ScreenshotUtil {

    private final static Logger LOGGER = LogManager.getRootLogger();

    private static final String SCREENSHOT_NAME_TEMPLATE = "screenshot_%d_%s.png";

    public static final String SCREENSHOTS_FOLDER = "target/screenshots";

    public static File getScreenshot() {
        LOGGER.debug("Get browser screenshot");
        String screenshotName = getUniqueNameForScreenshot();
        String screenshotPath = SCREENSHOTS_FOLDER + File.separator + screenshotName;
        try {
            File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(screenshotPath);
            FileUtils.copyFile(scrFile, screenshotFile);
            return screenshotFile;
        } catch (IOException e) {
            LOGGER.error("Failure during saving screenshot file.", e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private String getUniqueNameForScreenshot() {
        return String.format(SCREENSHOT_NAME_TEMPLATE, System.currentTimeMillis(),
                RandomString.make(5));
    }
}
