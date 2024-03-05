package com.devsu.automation.stepdefinitions;

import com.devsu.automation.utils.ConfigLoader;
import com.devsu.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void beforeScenario() {
        // Inicializa el WebDriver antes de cada escenario
        driver = DriverManager.getDriver();
        String baseUrl = ConfigLoader.load().getBaseUrl();
        driver.get(baseUrl);
    }

    @After
    public void afterScenario() {
        // Limpia el WebDriver después de cada escenario
        if (driver != null) {
            driver.quit();
        }
    }
}
