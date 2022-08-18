package com.elena.mystore.publicpage;

import com.elena.mystore.BaseTest;
import com.elena.mystore.util.DataProviders;
import org.testng.annotations.Test;

import static com.elena.mystore.util.SoftAssertionHandler.softVerify;
import static org.hamcrest.Matchers.is;

public class SearchMainPageTest extends BaseTest {

    @Test(dataProvider = "searchInputCorrectValuesProvider", dataProviderClass = DataProviders.class)
    public void searchMainPageTest(String correctSearchInput) {
        mainMyStorePage = openMainMyStorePage();
        catalogPage = mainMyStorePage.search(correctSearchInput);
        softVerify("Result in paginator isn't found for search query",
                () -> catalogPage.isSearchHasResultsInPaginator(), is(true));
        softVerify("Result isn't found for search query",
                () -> catalogPage.isSearchHasResults(), is(false));
        softVerify("Search results aren't match",
                () -> catalogPage.isSearchHasResults(), is(catalogPage.isSearchHasResultsInPaginator()));
    }
}
