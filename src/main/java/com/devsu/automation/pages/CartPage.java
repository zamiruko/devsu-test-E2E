package com.devsu.automation.pages;

import com.devsu.automation.utils.DriverManager;
import com.devsu.automation.utils.SeleniumFunctions;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private SeleniumFunctions functions = new SeleniumFunctions();
    private static String fileDOM = "CartPage.json";

    public CartPage() throws Exception {
        this.driver = DriverManager.getDriver();
        functions.initializeFileJson(fileDOM);
    }

    public void clickOnPlaceOrderButton() throws Exception {
        functions.initializeFileJson(fileDOM);

        functions.waitForElementPresent("PlaceOrderButton");
        functions.scrollToElement("PlaceOrderButton");
        functions.clickOnElement("PlaceOrderButton");
    }

    public void completeDataOnForm(String element, String data) throws Exception {
        functions.initializeFileJson(fileDOM);

        functions.waitForElementPresent("NameTextBox");
        functions.scrollToElement("NameTextBox");
        switch (element){
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
    }
/*    public boolean formIsComplete() throws  Exception{
        functions.initializeFileJson(fileDOM);

        functions.waitForElementPresent("NameTextBox");
        functions.scrollToElement("NameTextBox");

        if (
                functions.GetTextElement("NameTextBox").isEmpty() &&
                functions.GetTextElement("CountryTextBox").isEmpty() &&
                functions.GetTextElement("CityTextBox").isEmpty() &&
                functions.GetTextElement("CreditCardTextBox").isEmpty() &&
                functions.GetTextElement("MonthTextBox").isEmpty() &&
                functions.GetTextElement("YearTextBox").isEmpty() ""
        ) {
            return true;
        }else {
            return false;
        }
    }
*/
    public void clickOnPurchaseButton() throws Exception {
        functions.initializeFileJson(fileDOM);

        functions.waitForElementPresent("PurchaseButton");
        functions.scrollToElement("PurchaseButton");
        functions.clickOnElement("PurchaseButton");
    }
    public boolean reviewProductsOnTable(String table, int nProducts) throws Exception{
        functions.initializeFileJson(fileDOM);

        functions.waitForElementPresent(table);
        functions.scrollToElement(table);

        int elementsNumber = functions.countElementsOfElement(table);
        if(elementsNumber == nProducts) {
            return true;
        }else {
            return false;
        }
    }
    public void finalizePurchaseOkButton() throws Exception {
        functions.initializeFileJson(fileDOM);

        functions.waitForElementPresent("OKButton");
        functions.scrollToElement("OKButton");
        functions.clickOnElement("OKButton");
    }

}
