package com.elena.mystore.util;

import com.elena.mystore.core.logger.Logger;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

@UtilityClass
public final class DriverUtil {
    private static final Logger LOGGER = new Logger(DriverUtil.class);

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
