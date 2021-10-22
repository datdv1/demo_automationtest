package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import com.equisoft.centralize.automationtest.utils.WebDriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateInsurerSteps {

    private final CreateInsurerPage insurerPage;

    public CreateInsurerSteps() {
        this.insurerPage = new CreateInsurerPage();
    }

    @Given("the user opens create insurer popup")
    public void openCreateInsurerPopup() {
        insurerPage.openCreateInsurerPopup();
    }

    @When("the user enters general information")
    public void enterGeneralInformation() throws InterruptedException {
        insurerPage.fillGeneralInformation();
    }

    @When("the user enters contact information")
    public void enterContactInformation() throws InterruptedException {
        insurerPage.fillGeneralContactInformation();
    }

    @When("the user enters address information")
    public void enterAddressInformation() {
        insurerPage.addAddress();
    }

    @When("the user clicks on the create button")
    public void clickCreateButton() throws InterruptedException {
        insurerPage.clickCreateButton();
    }

    @Then("the user created and user details page is opened")
    public void getResult() {
        Assertions.assertTrue(insurerPage.checkDisplayName());
        Assertions.assertTrue(insurerPage.checkCompanyName());
        Assertions.assertTrue(insurerPage.checkLanguageCompany());
        Assertions.assertTrue(insurerPage.checkEmailCompany());
        Assertions.assertTrue(insurerPage.isCreateSuccessful());
    }


}
