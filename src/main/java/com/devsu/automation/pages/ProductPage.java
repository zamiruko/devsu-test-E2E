package com.devsu.automation.pages;

//import com.devsu.automation.utils.JsonLoader;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import com.devsu.automation.utils.DriverManager;
import com.devsu.automation.utils.SeleniumFunctions;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    /*
    private WebDriver driver;
    private By addToCartButton;
    private By homeButton;
    private By productConfirmationModal;
    private By productConfirmationOkButton;



    public ProductPage(WebDriver driver) {
        this.driver = driver;
        loadElements();
    }

    private void loadElements() {
        // Suponiendo que el JSON tiene un objeto para cada elemento con una propiedad "ValueToFind"
        addToCartButton = By.xpath(JsonLoader.loadPageElements("ProductPage.json").get("AddToCartButton").getAsString());
        homeButton = By.xpath(JsonLoader.loadPageElements("ProductPage.json").get("HomeButton").getAsString());
        productConfirmationModal = By.xpath(JsonLoader.loadPageElements("ProductPage.json").get("ProductConfirmationModal").getAsString());
        productConfirmationOkButton = By.xpath(JsonLoader.loadPageElements("ProductPage.json").get("ProductConfirmationOkButton").getAsString());
    }

    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
        // Aquí iría el código para manejar la espera del modal y confirmar la adición
    }

    public void confirmProductAddition() {
        driver.findElement(productConfirmationOkButton).click();
        // Aquí iría el código para manejar la espera de que el modal desaparezca
    }

    public void navigateHome() {
        driver.findElement(homeButton).click();
        // Aquí iría el código para asegurarse de que la navegación ha sido exitosa
    }

 */
    private WebDriver driver;
    private SeleniumFunctions functions = new SeleniumFunctions();
    private static String fileDOM = "ProductPage.json";

    public ProductPage() throws Exception {
        this.driver = DriverManager.getDriver();
        functions.initializeFileJson(fileDOM);
    }

    public void addProductToCart() throws Exception {
        functions.initializeFileJson(fileDOM);

        functions.waitForElementPresent("AddToCartButton");
        functions.scrollToElement("AddToCartButton");
        functions.clickOnElement("AddToCartButton");
        functions.acceptAlert();
    }

    public void navigateToHomePage() throws Exception{
        functions.initializeFileJson(fileDOM);

        functions.clickOnElement("HomeButton");
    }

}
