package com.elena.mystore.util;

import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

@UtilityClass
public final class DriverUtil {
    private final static Logger LOGGER = LogManager.getRootLogger();

    public boolean isElementPresent(WebDriver driver, By xpath, int timeoutSec) {
        LOGGER.debug("Verify if element is present with timeout: " + timeoutSec);
        driver.manage().timeouts().implicitlyWait(timeoutSec, TimeUnit.SECONDS);
        List<WebElement> elements;
        try {
            elements = driver.findElements(xpath);
        } finally {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        return !elements.isEmpty();
    }
}
