package com.devsu.automation.stepdefinitions;

import com.devsu.automation.pages.HomePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

public class HomePageSteps {

    HomePage homePage;

    public HomePageSteps() throws Exception {
        homePage = new HomePage();
    }

    @Given("Estoy en la pagina principal")
    public void estoyEnLaPaginaPrincipal() throws Exception {
        homePage.navigateToHomePage();
    }

    @When("Selecciono el primer producto")
    public void seleccionoElPrimerProducto() throws Exception {
        homePage.selectProduct("Product1Img");
    }

    @When("Selecciono el segundo producto")
    public void seleccionoElSegundoProducto() throws Exception {
        homePage.selectProduct("Product2Img");
    }

    @When("Estoy en la pagina del carrito")
    public void hagoClickEnElCarritoDeCompras() throws Exception {
        homePage.navigateToCartPage();
    }
}
