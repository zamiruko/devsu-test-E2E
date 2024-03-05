package com.devsu.automation.pages;

import com.devsu.automation.utils.DriverManager;
import com.devsu.automation.utils.SeleniumFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    public static Logger log = Logger.getLogger(CartPage.class);

    private WebDriver driver;
    private SeleniumFunctions functions = new SeleniumFunctions();
    private static String fileDOM = "ProductPage.json";

    public ProductPage() throws Exception {
        try {
            this.driver = DriverManager.getDriver();
            functions.initializeFileJson(fileDOM);
        } catch (Exception e) {
            log.error("Error initializing ProductPage: " + e.getMessage());
            throw new RuntimeException("Failed to initialize ProductPage", e);
        }
    }

    public void addProductToCart() throws Exception {
        try {
            functions.initializeFileJson(fileDOM);

            functions.waitForElementPresent("AddToCartButton");
            functions.scrollToElement("AddToCartButton");
            functions.clickOnElement("AddToCartButton");
            functions.acceptAlert();
        }catch (Exception e){
            log.error("Error adding Product to Cart: " + e.getMessage());
            throw new RuntimeException("Failed to add Product to Cart:", e);
        }
    }

    public void navigateToHomePage() throws Exception{
        try {
            functions.initializeFileJson(fileDOM);
            functions.clickOnElement("HomeButton");
        } catch (Exception e) {
            log.error("Error navigating to home page: " + e.getMessage());
            throw new RuntimeException("Failed to navigate to home page", e);
        }
    }

}
