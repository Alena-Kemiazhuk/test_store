package com.elena.mystore.core.logger;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;

/**
 * Logger integration with Allure report
 */
public class Logger {

    private org.apache.logging.log4j.Logger logger;

    public Logger(Class<?> clazz) {
        logger = LogManager.getLogger(clazz);
    }

    public void info(String message) {
        Allure.step(message);
        logger.info(message);
    }

    public void step(String message) {
        String messageUpperCase = message.toUpperCase();
        Allure.step(messageUpperCase);
        logger.info(messageUpperCase);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(String message, Throwable e) {
        logger.error(message, e);
    }
}