package com.elena.mystore.pageobject.page;

import com.elena.mystore.core.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractStorePage {
    protected final WebDriver driver;
    private final static Logger LOGGER = LogManager.getRootLogger();

    public AbstractStorePage(String pageUrl) {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.get(pageUrl);
    }

    public AbstractStorePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.getCurrentUrl();
    }

    public Logger getLOGGER() {
        return LOGGER;
    }
}
