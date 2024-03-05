package com.devsu.automation.pages;

import com.devsu.automation.utils.DriverManager;
import com.devsu.automation.utils.SeleniumFunctions;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class CartPage {

    public static Logger log = Logger.getLogger(CartPage.class);

    private WebDriver driver;
    private SeleniumFunctions functions = new SeleniumFunctions();
    private static String fileDOM = "CartPage.json";

    public CartPage() throws Exception {
        try{
            this.driver = DriverManager.getDriver();
            functions.initializeFileJson(fileDOM);
        } catch (Exception e) {
            log.error("Error initializing CartPage: " + e.getMessage());
            throw new RuntimeException("Failed to initialize CartPage", e);
        }

    }

    public void clickOnPlaceOrderButton() throws Exception {
        try {
            functions.initializeFileJson(fileDOM);

            functions.waitForElementPresent("PlaceOrderButton");
            functions.scrollToElement("PlaceOrderButton");
            functions.clickOnElement("PlaceOrderButton");
        }catch (Exception e){
            log.error("Error clicking on Place Order Button: " + e.getMessage());
            throw new RuntimeException("Failed to click on Place Order Button", e);
        }
    }

    public void completeDataOnForm(String element, String data) throws Exception {
        try {
            functions.initializeFileJson(fileDOM);

            functions.waitForElementPresent("NameTextBox");
            functions.scrollToElement("NameTextBox");
            switch (element) {
                case "Name":
                    functions.setTextOnElement("NameTextBox", data);
                    break;
                case "Country":
                    functions.setTextOnElement("CountryTextBox", data);
                    break;
                case "City":
                    functions.setTextOnElement("CityTextBox", data);
                    break;
                case "Credit Card":
                    functions.setTextOnElement("CreditCardTextBox", data);
                    break;
                case "Month":
                    functions.setTextOnElement("MonthTextBox", data);
                    break;
                case "Year":
                    functions.setTextOnElement("YearTextBox", data);
                    break;
            }
        }catch (Exception e){
            log.error("Error completing data on Form: " + e.getMessage());
            throw new RuntimeException("Failed to complete data on Form", e);
        }
    }

    public void clickOnPurchaseButton() throws Exception {
        try {
            functions.initializeFileJson(fileDOM);

            functions.waitForElementPresent("PurchaseButton");
            functions.scrollToElement("PurchaseButton");
            functions.clickOnElement("PurchaseButton");
        }catch (Exception e) {
            log.error("Error clicking on Purchase Button: " + e.getMessage());
            throw new RuntimeException("Failed to clicking on Purchase Button: ", e);
        }
    }
    public boolean reviewProductsOnTable(String table, int nProducts) throws Exception{
        try {
            functions.initializeFileJson(fileDOM);

            functions.waitForElementPresent(table);
            functions.scrollToElement(table);

            int elementsNumber = functions.countElementsOfElement(table);
            if (elementsNumber == nProducts) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e) {
            log.error("Error reviewing Products on table: " + e.getMessage());
            throw new RuntimeException("Failed to review Products on table: ", e);
        }
    }
    public void finalizePurchaseOkButton() throws Exception {
        try {
            functions.initializeFileJson(fileDOM);

            functions.waitForElementPresent("OKButton");
            functions.scrollToElement("OKButton");
            functions.clickOnElement("OKButton");
        }catch (Exception e) {
            log.error("Error clicking OK Button: " + e.getMessage());
            throw new RuntimeException("Failed to click OK Button: ", e);
        }
    }

}
