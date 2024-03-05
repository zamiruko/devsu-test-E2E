package com.devsu.automation.pages;

import com.devsu.automation.utils.DriverManager;
import com.devsu.automation.utils.SeleniumFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public static Logger log = Logger.getLogger(CartPage.class);

    private WebDriver driver;
    private SeleniumFunctions functions = new SeleniumFunctions();
    private static String fileDOM = "HomePage.json";

    public HomePage() throws Exception {
        try {
            this.driver = DriverManager.getDriver();
            functions.initializeFileJson(fileDOM);
        } catch (Exception e) {
            log.error("Error initializing HomePage: " + e.getMessage());
            throw new RuntimeException("Failed to initialize HomePage", e);
        }
    }

    public void clickLoginButton() throws Exception{
        try {
            functions.waitForElementPresent("LoginButton");
            functions.scrollToElement("LoginButton");
            functions.clickOnElement("LoginButton");
        } catch (Exception e) {
            System.err.println("Error clicking on Login Button: " + e.getMessage());
            throw new RuntimeException("Failed to click on Login Button", e);
        }
    }

    public void enterUsername(String username) throws Exception{
        try{
        functions.initializeFileJson(fileDOM);

        functions.waitForElementPresent("UsernameText");
        functions.scrollToElement("UsernameText");
        functions.setTextOnElement("UsernameText", username);
        functions.clickOnElement("UsernameText");
        } catch (Exception e) {
            System.err.println("Error setting text on UserName: " + e.getMessage());
            throw new RuntimeException("Failed to set text on UserName", e);
        }
    }

    public void enterPassword(String password) throws Exception{
        try {
            functions.initializeFileJson(fileDOM);

            functions.waitForElementPresent("PasswordText");
            functions.scrollToElement("PasswordText");
            functions.setTextOnElement("PasswordText", password);
            functions.clickOnElement("PasswordText");
        }catch (Exception e){
            System.err.println("Error setting text on Password: " + e.getMessage());
            throw new RuntimeException("Failed to set text on Password", e);
        }
    }

    public void clickLoginModalButton() throws Exception{
        try {
            functions.initializeFileJson(fileDOM);

            functions.waitForElementPresent("LoginModalButton");
            functions.scrollToElement("LoginModalButton");
            functions.clickOnElement("LoginModalButton");
        }catch (Exception e){
            System.err.println("Error clicking Modal Button: " + e.getMessage());
            throw new RuntimeException("Failed to click Modal Button", e);
        }
    }



    public void selectProduct(String productNro) throws Exception{
        try {
            functions.initializeFileJson(fileDOM);

            functions.waitForElementPresent(productNro);
            functions.scrollToElement(productNro);
            functions.clickOnElement(productNro);
        }catch (Exception e){
            System.err.println("Error clicking Product: " + e.getMessage());
            throw new RuntimeException("Failed to click Product", e);
        }
    }

    public void navigateToHomePage() throws Exception{
        try {
            functions.initializeFileJson(fileDOM);
            //functions.clickOnElement("HomeButton");
        }catch (Exception e){
            System.err.println("Error navigating to HomePage: " + e.getMessage());
            throw new RuntimeException("Failed to navigate HomePage", e);
        }
    }

    public void navigateToCartPage() throws Exception{
        try {
            functions.initializeFileJson(fileDOM);

            functions.clickOnElement("CartButton");
        }catch (Exception e){
            System.err.println("Error navigating to CartPage: " + e.getMessage());
            throw new RuntimeException("Failed to navigate CartPage", e);
        }
    }

}
