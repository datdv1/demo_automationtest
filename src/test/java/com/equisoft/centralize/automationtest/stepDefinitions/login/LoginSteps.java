package com.equisoft.centralize.automationtest.stepDefinitions.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Given("the user is on login page")
    public void goToLoginPage() {
        loginPage.goToLoginPage();
    }

    @When("the user enters username & password")
    public void enterUsernamePassword() {
        loginPage.enterUsernameAndPassword();
    }

    @When("the user clicks on the login button")
    public void clicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the dashboard page is opened")
    public void openDashboard() {
        Assertions.assertTrue(loginPage.isDashboardDisplayed());
    }

}
