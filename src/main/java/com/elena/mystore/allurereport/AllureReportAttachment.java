package com.elena.mystore.allurereport;

import io.qameta.allure.Allure;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@NoArgsConstructor
public final class AllureReportAttachment {

    public static void attachScreenshot(File screenShotFile, String screenShotName) {
        Path content = Paths.get(screenShotFile.getAbsolutePath());
        try (InputStream is = Files.newInputStream(content)) {
           Allure.attachment(screenShotName, is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void attachPageSource(String pageSource) {
        Allure.addAttachment("Page source", pageSource);
    }
}
