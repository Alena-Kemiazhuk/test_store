package com.elena.mystore.pageobject.page;

import com.elena.mystore.exception.ProductBugException;
import com.elena.mystore.util.DriverUtil;
import com.elena.mystore.util.RegexUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends AbstractStorePage {

    private final Logger LOGGER = getLOGGER();

    @FindBy(xpath = "//div[./div[@id='pagination']]//div[@class='product-count']")
    private WebElement itemsPaginatorCount;

    @FindBy(xpath = "//div[@class='product-container']")
    private List<WebElement> itemsCount;

    @FindBy(xpath = "//div[./div[@id='pagination']]//div[@class='product-count']")
    private WebElement noResults;

    public CatalogPage() {
        super();
    }

    public int getItemsCountInPaginator() {
        try {
            String strItemsAmount = itemsPaginatorCount.getText();
            LOGGER.info("Amount of items in paginator are " + RegexUtil.getFirstGroupByRegex(strItemsAmount, "of (\\d*)"));
            return Integer.parseInt(RegexUtil.getFirstGroupByRegex(strItemsAmount, "of (\\d*)"));
        } catch (NoSuchElementException e) {
            throw new ProductBugException("Amount of items in paginator wasn't found", e);
        }
    }

    public int getItemsCount() {
        try {
            LOGGER.info("Amount of items are " + itemsCount.size());
            return itemsCount.size();
        } catch (NoSuchElementException e) {
            throw new ProductBugException("Amount of items wasn't found", e);
        }
    }

    public boolean isIncorrectSearchResultPresent() {
        LOGGER.info("Verify is incorrect search result present");
        return DriverUtil.isElementPresent(driver, By.xpath("//p[contains(text(), 'No results')]"), 3);
    }

    public boolean isSearchHasResultsInPaginator() {
        LOGGER.info("Verify is search result present in paginator");
        return getItemsCountInPaginator() > 0;
    }

    public boolean isSearchHasResults() {
        LOGGER.info("Verify is search result present");
        return getItemsCount() > 0;
    }
}
