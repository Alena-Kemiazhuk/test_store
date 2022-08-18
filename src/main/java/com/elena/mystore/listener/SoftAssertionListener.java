package com.elena.mystore.listener;

import com.elena.mystore.util.SoftAssertionHandler;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class SoftAssertionListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod() && testResult.isSuccess()
                && !SoftAssertionHandler.getVerificationFailures().isEmpty()) {
            try {
                SoftAssertionHandler.assertAll();

            } catch (AssertionError e) {
                testResult.setStatus(ITestResult.FAILURE);
                testResult.setThrowable(e);
            }
        }
    }
}