package com.elena.mystore;

import com.elena.mystore.config.ApplicationProperties;
import com.elena.mystore.core.driver.DriverManager;

import com.elena.mystore.pageobject.page.CatalogPage;
import com.elena.mystore.pageobject.page.MainMyStorePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@TestPropertySource("/application.properties")
@ContextConfiguration(classes = {SpringTestConfiguration.class, ApplicationProperties.class})
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected ApplicationProperties applicationProperties;

    protected MainMyStorePage mainMyStorePage;
    protected CatalogPage catalogPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        DriverManager.getDriver();
        DriverManager.toFullScreen();
    }

    public MainMyStorePage openMainMyStorePage() {
        return new MainMyStorePage(applicationProperties.getTargetUrl());
    }

    @AfterClass(alwaysRun = true)
    public void close() {
        DriverManager.closeDriver();
    }
}
