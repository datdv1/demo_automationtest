package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ListInsurerSteps {

    private final ListInsurerPage insurerPage;

    public ListInsurerSteps() {
        insurerPage = new ListInsurerPage();
    }

    @Given("the user go to insurers list page by click to link Insurer under Folder")
    public void goToInsurersListPage() {
        insurerPage.goToInsurersListPage();
    }

    @Given("the user can see insurers list page")
    public void seeInsurersListPage() {
        Assertions.assertTrue(insurerPage.isInsurerListPageDisplayed());
    }

    @Given("the user can see the list of insurers")
    public void seeListOfInsurer() {
        Assertions.assertTrue(insurerPage.isInsurerListDisplayed());
    }

    @When("the user select a row record")
    public void selectInsurer() {
        insurerPage.selectAnInsurer();
    }

    @Then("the user should see the insurer information with selected record in the Insurer Folder menu")
    public void showInsurerDetail() {
        Assertions.assertTrue(insurerPage.isSelectedInsurerShowOnFolder());
        Assertions.assertTrue(insurerPage.isSelectedInsurerDisplayed());
    }

}
