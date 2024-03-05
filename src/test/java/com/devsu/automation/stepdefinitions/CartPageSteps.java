package com.devsu.automation.stepdefinitions;

import com.devsu.automation.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageSteps {

    CartPage cartPage;

    public CartPageSteps() {
        cartPage = new CartPage();
    }

    @And("Debería ver {int} productos en el carrito")
    public void deberíaVerNProductosEnElCarrito(int nProducts) {
        boolean existsNProducts = cartPage.reviewProductsOnTable("ProductsTable", nProducts);
        if(!existsNProducts) {
            throw new RuntimeException("This step is designed to fail, because not allow 2 Products");
        }
    }
    @When("Abro el formulario de compra")
    public void abroElFormularioDeCompra() {
        cartPage.clickOnPlaceOrderButton();
    }

    @And("^Lleno el campo (.*) con el dato (.*)")
    public void llenoElCampoConElDato(String element, String data) {
        cartPage.completeDataOnForm(element,data);
    }

    @When("Hago click en el botón de realizar pedido")
    public void hagoClickEnElBotónDeRealizarPedido() {
        cartPage.clickOnPurchaseButton();
    }

    @Then("Debería ver la alerta de confirmación de compra y finalizar la compra")
    public void deberíaVerLaAlertaDeConfirmaciónDeCompraYFinalizarLaCompra() {
        cartPage.finalizePurchaseOkButton();
    }
}
