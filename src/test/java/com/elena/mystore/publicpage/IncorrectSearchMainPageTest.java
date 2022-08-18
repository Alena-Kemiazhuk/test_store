package com.elena.mystore.publicpage;

import com.elena.mystore.BaseTest;
import com.elena.mystore.util.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncorrectSearchMainPageTest extends BaseTest {

    @Test(dataProvider = "searchInputIncorrectValuesProvider", dataProviderClass = DataProviders.class)
    public void incorrectSearchMainPageTest(String incorrectSearchInput) {
        mainMyStorePage = openMainMyStorePage();
        catalogPage = mainMyStorePage.search(incorrectSearchInput);
        Assert.assertTrue(catalogPage.isIncorrectSearchResultPresent(),
                "Result found for invalid search query");
    }
}
