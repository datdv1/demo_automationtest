package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CreateInsurerSteps {

    private final CreateInsurerPage insurerPage;

    public CreateInsurerSteps() {
        this.insurerPage = new CreateInsurerPage();
    }

    @Given("the user opens create insurer popup")
    public void openCreateInsurerPopup() {
        insurerPage.openCreateInsurerPopup();
    }

    @When("the user enters displayName is {string} and companyName is {string} and language is {string} and website is {string}")
    public void enterGeneralInformation(String displayName, String companyName, String language, String website) {
        insurerPage.fillGeneralInformation(displayName, companyName, language, website);
    }

    @When("the user enters emailType is {string} and email is {string} and phoneType is {string} and phoneValue is {string} and phoneExt is {string}")
    public void enterContactInformation(String emailType, String email, String phoneType, String phoneValue, String phoneExt) {
        insurerPage.fillContactInformation(emailType, email, phoneType, phoneValue, phoneExt);
    }

    @When("the user enters addressType is {string} and country is {string} and address is {string} and addressApt is {string} and city is {string} and province is {string} and postalCode is {string}")
    public void enterAddressInformation(String addressType, String country, String address, String addressApt, String city, String province, String postalCode) {
        insurerPage.fillAddressInformation(addressType, country, address, addressApt, city, province, postalCode);
    }

    @When("the user clicks on the create button")
    public void clickCreateButton() {
        insurerPage.clickCreateButton();
    }

    @Then("the user created and user details page is opened")
    public void getResult() {
        Assertions.assertTrue(insurerPage.checkGeneralInfo());
        Assertions.assertTrue(insurerPage.checkContactInfo());
        Assertions.assertTrue(insurerPage.checkAddressInfo());
        Assertions.assertTrue(insurerPage.isCreateSuccessful());
    }


}
