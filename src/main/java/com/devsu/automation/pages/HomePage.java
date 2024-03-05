package com.devsu.automation.pages;

import com.devsu.automation.utils.DriverManager;
import com.devsu.automation.utils.SeleniumFunctions;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import com.google.gson.JsonObject;
//import com.devsu.automation.utils.JsonLoader;

public class HomePage {

    private WebDriver driver;
    SeleniumFunctions functions = new SeleniumFunctions();
    //private JsonObject pageElements;
    private static String fileDOM = "HomePage.json";
    private static String fileData = "FormData.json";

    public HomePage() throws Exception {
        this.driver = DriverManager.getDriver();
        //functions.navigationToURL();
        // this.pageElements = JsonLoader.loadPageElements("HomePage.json");
        functions.initializeFileJson(fileDOM);
        functions.initializeFileJsonData(fileData);
    }

    /*
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
    */

    public void clickLoginButton() throws Exception{
        functions.waitForElementPresent("LoginButton");
        functions.scrollToElement("LoginButton");
        functions.clickOnElement("LoginButton");
    }

    public void enterUsername(String username) throws Exception{
        functions.waitForElementPresent("UsernameText");
        functions.scrollToElement("UsernameText");
        functions.setTextOnElement("UsernameText", username);
        functions.clickOnElement("UsernameText");
    }

    public void enterPassword(String password) throws Exception{
        functions.waitForElementPresent("PasswordText");
        functions.scrollToElement("PasswordText");
        functions.setTextOnElement("PasswordText", password);
        functions.clickOnElement("PasswordText");
    }

    public void clickLoginModalButton() throws Exception{
//        getElement("LoginModalButton").click();
        functions.waitForElementPresent("LoginModalButton");
        functions.scrollToElement("LoginModalButton");
        functions.clickOnElement("LoginModalButton");

    }

}
