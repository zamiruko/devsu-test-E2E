package com.devsu.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.apache.log4j.Logger;

import java.io.IOException;

public class DriverManager {

    public static WebDriver driver;
    private static Logger log = Logger.getLogger(DriverManager.class);

    public static void initializeDriver() throws IOException {
        if (driver == null) {
            try {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
                driver.manage().window().maximize();
            } catch (Exception e) {
                log.error("Failed to initialize the web driver: ", e);
                throw new RuntimeException("Driver initialization failed", e);
            }
        }
    }

    public static WebDriver getDriver() throws IOException {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
