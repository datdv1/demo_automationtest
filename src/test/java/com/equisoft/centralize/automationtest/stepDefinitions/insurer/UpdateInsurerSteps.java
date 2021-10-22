package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class UpdateInsurerSteps {

    private final UpdateInsurerPage insurerPage;

    public UpdateInsurerSteps() {
        insurerPage = new UpdateInsurerPage();
    }

    /**
     * Scenario: Edit insurer successful
     */

    @Given("the user is on Edit Insurer page")
    public void goToEditInsurerPage() {
        insurerPage.goToEditAnInsurer();
    }

    @When("the user edits 'displayName' to {string} and the user edits 'companyName' to {string} and 'language' to {string} and 'website' to {string}")
    public void editGeneralInfo(String displayName, String companyName, String language, String website) {
        insurerPage.editGeneralInformation(displayName, companyName, language, website);
    }
    
    @When("the user edits 'emailType' to {string} and 'email' to {string} and 'phoneType' to {string} and 'phoneValue' to {string} and 'phoneExt' to {string}")
    public void editContactInfo(String emailType, String email, String phoneType, String phoneValue, String phoneExt) {
        insurerPage.editContactInformation(emailType, email, phoneType, phoneValue, phoneExt);
    }
    
    @When("the user edits 'addressType' to {string} and 'country' to {string} and 'address' to {string} and 'apt' to {string} and 'city' to {string} and 'province' to {string} and 'postalCode' to {string}")
    public void editAddressInfo(String addressType, String country, String address, String addressApt, String city, String province, String postalCode) {
        insurerPage.editAddressInformation(addressType, country, address, addressApt, city, province, postalCode);
    }

    @When("the user click to button 'Save'")
    public void clickSave() {
        insurerPage.clickSave();
    }

    @Then("the user can save page successfully with message 'Insurer modifications applied successfully.' pop up")
    public void seeUpdateSuccessfulMessage() {
        Assertions.assertTrue(insurerPage.isEditSuccessful());
    }

    @Then("the user can see new information in insurer detail page")
    public void verifyNewInformation() {
        Assertions.assertTrue(insurerPage.verifyNewInformation());
    }

}
