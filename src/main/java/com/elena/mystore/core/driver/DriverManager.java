package com.elena.mystore.core.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();

    private static volatile DriverManager instance;
    private static final Logger LOGGER = LogManager.getRootLogger();

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

    public static DriverManager getInstance() {
        DriverManager localInstance = instance;
        if (localInstance == null) {
            synchronized (DriverManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    LOGGER.debug("Create driver manager instance.");
                    instance = localInstance = new DriverManager();
                }
            }
        }
        return localInstance;
    }
}