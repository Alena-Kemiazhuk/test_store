package com.elena.mystore.core.driver;


import com.elena.mystore.core.logger.Logger;
import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();

    private static final Logger LOGGER = new Logger(DriverManager.class);

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (DRIVERS.get() == null) {
            DRIVERS.set(ChromeDriverCreator.setupChromeDriver());
        }
        return DRIVERS.get();
    }

    public static void closeDriver() {
        if (DRIVERS.get() != null) {
            try {
                DRIVERS.get().quit();
                DRIVERS.remove();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    public static void toFullScreen() {
        LOGGER.debug("Set new screen size");
        getDriver().manage().window().maximize();
        LOGGER.info("Maximize is done. Test run in full screen");
    }
}