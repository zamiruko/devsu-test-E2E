package com.devsu.automation.pages;

import com.devsu.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.gson.JsonObject;
import com.devsu.automation.utils.JsonLoader;

public class HomePage {

    private WebDriver driver;
    private JsonObject pageElements;

    public HomePage() {
        this.driver = DriverManager.getDriver();
        this.pageElements = JsonLoader.loadPageElements("HomePage.json");
    }

    private WebElement getElement(String elementName) {
        String method = pageElements.getAsJsonObject(elementName).get("GetFieldBy").getAsString();
        String value = pageElements.getAsJsonObject(elementName).get("ValueToFind").getAsString();

        switch (method) {
            case "xpath":
                return driver.findElement(By.xpath(value));
            // Puedes agregar más métodos de localización si es necesario
            default:
                throw new IllegalArgumentException("Unsupported locator method: " + method);
        }
    }

    public void clickLoginButton() {
        getElement("LoginButton").click();
    }

    public void enterUsername(String username) {
        getElement("UsernameText").sendKeys(username);
    }

    public void enterPassword(String password) {
        getElement("PasswordText").sendKeys(password);
    }

    public void clickLoginModalButton() {
        getElement("LoginModalButton").click();
    }

}
