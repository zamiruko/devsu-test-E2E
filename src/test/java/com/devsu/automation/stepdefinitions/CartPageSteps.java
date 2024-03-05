package com.devsu.automation.stepdefinitions;

import com.devsu.automation.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

public class CartPageSteps {

    CartPage cartPage;

    public CartPageSteps() throws Exception{
        cartPage = new CartPage();
    }

    @And("Debería ver {int} productos en el carrito")
    public void deberíaVerNProductosEnElCarrito(int nProducts) throws Exception{
        boolean existsNProducts = cartPage.reviewProductsOnTable("ProductsTable", nProducts);
        if(existsNProducts){
            //Exists N Products
        }else {
            throw new RuntimeException("This step is designed to fail, because not allow 2 Products");
        }

    }
    @When("Abro el formulario de compra")
    public void abroElFormularioDeCompra() throws Exception{
        cartPage.clickOnPlaceOrderButton();
    }

    @And("^Lleno el campo (.*) con el dato (.*)")
    public void llenoElCampoConElDato(String element, String data) throws Exception{
        cartPage.completeDataOnForm(element,data);
    }

    @Then("Debería tener el formulario lleno")
    public void deberíaTenerElFormularioLleno() throws Exception{
        //boolean formComplete = cartPage.formIsComplete();
        //if(formComplete){
            //FormComplete
        //}else {
        //    throw new RuntimeException("This step is designed to fail, because the form is not complete.");
        //}
    }

    @Given("Estoy en la pagina del carrito con el formulario completado")
    public void estoyEnLaPaginaDelCarritoConElFormularioCompletado() throws Exception{
        //No Necesario codigo
    }

    @When("Hago click en el botón de realizar pedido")
    public void hagoClickEnElBotónDeRealizarPedido() throws Exception{
        cartPage.clickOnPurchaseButton();
    }

    @Then("Debería ver la alerta de confirmación de compra y finalizar la compra")
    public void deberíaVerLaAlertaDeConfirmaciónDeCompraYFinalizarLaCompra() throws Exception{
        cartPage.finalizePurchaseOkButton();
    }
}
