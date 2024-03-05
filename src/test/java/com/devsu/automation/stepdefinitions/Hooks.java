package com.devsu.automation.stepdefinitions;

import com.devsu.automation.utils.ConfigLoader;
import com.devsu.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class Hooks {

    private WebDriver driver;
    public static Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void beforeScenario() {
        log.info("[Configuration] - Inicializa el WebDriver antes de cada escenario");
        try {
            driver = DriverManager.getDriver();
            String baseUrl = ConfigLoader.load().getBaseUrl();
            driver.get(baseUrl);
        } catch (Exception e) {
            log.error("Failed to initialize the web driver on Hooks before Scenario: ", e);
            throw new RuntimeException("Driver initialization failed on Hooks before Scenario", e);
        }
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}
