package com.elena.mystore.util;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public final class RegexUtil {

    public static String getFirstGroupByRegex(String text, String regexWithGroup) {
        Pattern r = Pattern.compile(regexWithGroup);
        Matcher m = r.matcher(text);

        if (m.find()) {
            return m.group(1);
        } else {
            return "NO MATCH";
        }
    }
}
