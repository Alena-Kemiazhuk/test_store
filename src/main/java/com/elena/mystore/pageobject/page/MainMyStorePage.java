package com.elena.mystore.pageobject.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMyStorePage extends AbstractStorePage {

    private final Logger logger = getLOGGER();

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement searchBtn;

    public MainMyStorePage(String url) {
        super(url);
    }

    public CatalogPage search(String searchText) {
        logger.info("Search for " + searchText);
        enterSearchText(searchText);
        clickSearch();
        return new CatalogPage();
    }

    public void enterSearchText(String searchText) {
        logger.info("Enter search text: " + searchText);
        searchInput.sendKeys(searchText);
    }

    public void clickSearch() {
        searchBtn.click();
    }
}
