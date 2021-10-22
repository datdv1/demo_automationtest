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
     * Scenario: Verify user can save data without update
     */

    @Given("the user is on Edit Insurer page")
    public void goToEditInsurerPage() {
        insurerPage.goToEditAnInsurer();
    }

    @Given("the user locates to \"Addresses\" section")
    public void locateToAddressSection() {
        insurerPage.locateToAddressesSection();
    }

    @When("the user click to button 'Save'")
    public void clickSave() {
        insurerPage.clickSave();
    }

    @Then("the user can save page successfully with message 'Insurer modifications applied successfully.' pop up")
    public void seeUpdateSuccessfulMessage() {
        Assertions.assertTrue(insurerPage.isEditSuccessful());
    }

    /**
     * Scenario: Edit insurer successful
     */

    @When("the user edits general information")
    public void editGeneralInformation() {
        insurerPage.editGeneralInformation();
    }

    @When("the user edits contact information")
    public void editContactInformation() {
        insurerPage.editContactInformation();
    }

    @When("the user edits address information")
    public void editAddressInformation() {
        insurerPage.editAddressInformation();
    }

    @Then("the user can see new information in insurer detail page")
    public void verifyNewInformation() {
        Assertions.assertTrue(insurerPage.verifyNewInformation());
    }

}
