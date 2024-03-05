package com.devsu.automation.stepdefinitions;

import com.devsu.automation.pages.HomePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

public class HomePageSteps {

    HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage();
    }

    @Given("Estoy en la pagina principal")
    public void estoyEnLaPaginaPrincipal() {
        homePage.navigateToHomePage();
    }

    @When("Selecciono el primer producto")
    public void seleccionoElPrimerProducto() {
        homePage.selectProduct("Product1Img");
    }

    @When("Selecciono el segundo producto")
    public void seleccionoElSegundoProducto() {
        homePage.selectProduct("Product2Img");
    }

    @When("Estoy en la pagina del carrito")
    public void hagoClickEnElCarritoDeCompras() {
        homePage.navigateToCartPage();
    }
}
