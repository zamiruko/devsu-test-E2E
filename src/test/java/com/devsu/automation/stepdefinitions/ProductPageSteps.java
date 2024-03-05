package com.devsu.automation.stepdefinitions;

import com.devsu.automation.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ProductPageSteps {

    ProductPage productPage;

    public ProductPageSteps() throws Exception{
        productPage = new ProductPage();
    }

    @And("Agrego el producto al carrito")
    public void agregoElProductoAlCarrito() throws Exception{
        productPage.addProductToCart();
    }
    @When("Vuelvo a la pagina principal")
    public void vuelvoALaPaginaPrincipal() throws Exception {
        productPage.navigateToHomePage();
    }
}
