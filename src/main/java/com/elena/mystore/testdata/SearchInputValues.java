package com.elena.mystore.testdata;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum SearchInputValues {

    DRESS("dress", true),

    INCORRECT_VALUE_ONE("juvalksdjf", false),

    INCORRECT_VALUE_TWO("ghjdshhjcjxj", false);

    private final String inputValue;
    private final boolean isCorrectValue;

    public static List<String> getCorrectInputValues() {
        return Arrays.stream(values())
                .filter(inputValues -> inputValues.isCorrectValue)
                .map(SearchInputValues::getInputValue)
                .collect(Collectors.toList());
    }
    public static List<String> getIncorrectInputValues() {
        return Arrays.stream(values())
                .filter(inputValues -> !inputValues.isCorrectValue)
                .map(SearchInputValues::getInputValue)
                .collect(Collectors.toList());
    }
}
