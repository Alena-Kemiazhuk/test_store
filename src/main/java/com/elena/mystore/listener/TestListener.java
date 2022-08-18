package com.elena.mystore.listener;

import com.elena.mystore.allurereport.AllureReportAttachment;
import com.elena.mystore.core.driver.DriverManager;
import com.elena.mystore.core.logger.Logger;
import com.elena.mystore.util.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener, IInvokedMethodListener {

    private static final Logger LOGGER = new Logger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.debug("STARTING TEST: " + getMethodName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.debug("SUCCESS: " + getMethodName(result));
        sendDataToAllure();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.debug("FAILURE: " + getMethodName(result));
        sendDataToAllure();
    }

    private String getMethodName(ITestResult result) {
        return result.getMethod().getMethodName();
    }

    private void sendDataToAllure() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            String screenshotName = ScreenshotUtil.getUniqueNameForScreenshot();
            AllureReportAttachment
                    .attachScreenshot(ScreenshotUtil.getScreenshot(screenshotName), screenshotName);
            AllureReportAttachment.attachPageSource(driver.getPageSource());
        }
    }
}
