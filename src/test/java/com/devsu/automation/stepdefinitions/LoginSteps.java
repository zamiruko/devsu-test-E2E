package com.devsu.automation.stepdefinitions;

import com.devsu.automation.pages.HomePage;
//import com.devsu.automation.utils.ConfigLoader;
//import com.devsu.automation.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
//import org.openqa.selenium.WebDriver;

public class LoginSteps {

    HomePage homePage = new HomePage();

    public LoginSteps() throws Exception {
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() throws Exception {

        //homePage.wait(10);

        // Aquí puedes poner el código para navegar a la página principal si es necesario
    }

    @When("I click the login button")
    public void iClickTheLoginButton() throws Exception {
        homePage.clickLoginButton();
    }

    @And("I enter the username {string} and password {string}")
    public void iEnterTheUsernameAndPassword(String username, String password) throws Exception {
        homePage.enterUsername(username);
        homePage.enterPassword(password);
    }

    @And("I click the login modal button")
    public void iClickTheLoginModalButton() throws Exception {
        homePage.clickLoginModalButton();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() throws Exception {
        // Aquí puedes poner aserciones para verificar que el usuario esté logueado correctamente
    }

    /*
    private WebDriver driver;
    private HomePage homePage;

    public LoginSteps() {
        driver = DriverManager.getDriver();
    }

    @Given("el usuario está en la página de inicio")
    public void el_usuario_esta_en_la_pagina_de_inicio() {
        homePage = new HomePage(driver);
        driver.get(ConfigLoader.load().getBaseUrl());
    }

    @When("el usuario hace click en el botón de login")
    public void el_usuario_hace_click_en_el_boton_de_login() {
        homePage.clickOnLoginLink();
    }

    @Then("el modal de login se muestra")
    public void el_modal_de_login_se_muestra() {
        // Implementación pendiente. Debes verificar aquí que el modal de login es visible.
        // Por ejemplo, podrías usar una aserción para verificar la visibilidad del modal.
    }
     */
}
