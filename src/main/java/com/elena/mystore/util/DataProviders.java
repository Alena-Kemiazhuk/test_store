package com.elena.mystore.util;

import com.elena.mystore.testdata.SearchInputValues;
import org.testng.annotations.DataProvider;


import java.util.List;

public class DataProviders {

    @DataProvider(name = "searchInputIncorrectValuesProvider")
    public Object[] searchInputIncorrectValuesProvider() {
        List<String> searchInputVariants = SearchInputValues.getIncorrectInputValues();
        return searchInputVariants.toArray();
    }

    @DataProvider(name = "searchInputCorrectValuesProvider")
    public Object[] searchInputCorrectValuesProvider() {
        List<String> searchInputVariants = SearchInputValues.getCorrectInputValues();
        return searchInputVariants.toArray();
    }
}
