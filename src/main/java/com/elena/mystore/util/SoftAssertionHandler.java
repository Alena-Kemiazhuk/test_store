package com.elena.mystore.util;

import com.google.common.base.Joiner;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SoftAssertionHandler {

    @Getter
    private static List<Throwable> verificationFailures = new ArrayList<>();

    public static <T> void softVerify(String message, Supplier<T> webElement,
                                      Matcher<? super T> matcher) {
        try {
            assertThat(message, webElement.get(), matcher);
        } catch (AssertionError e) {
            addVerificationFailure(e);
            ScreenshotUtil.getScreenshot(ScreenshotUtil.getUniqueNameForScreenshot());
        }
    }

    public static void addVerificationFailure(Throwable e) {
        verificationFailures.add(e);
    }

    public static void assertAll() {
        if (!verificationFailures.isEmpty()) {
            String resultMessage = Joiner.on("\n")
                    .join(verificationFailures.stream().map(Throwable::getMessage).collect(Collectors.toList()));
            verificationFailures.clear();
            throw new AssertionError(resultMessage);
        }
    }

}
