package com.elena.mystore.pageobject.page;

import com.elena.mystore.core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractStorePage {
    protected final WebDriver driver;

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
}
