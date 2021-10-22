package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateInsurerPage extends InsurerPage {

    @FindBy(id = "sidebar-add-button")
    private WebElement sidebarAddBtn;

    @FindBy(xpath = "//div[contains(@class, 'SidebarAdd_SidebarAddChoice') and contains(text(), 'Insurer')]")
    private WebElement createInsurerBtn;

    @FindBy(xpath = "//button[@type='submit' and contains(text() , 'Contact')]")
    private WebElement btnContact;

    @FindBy(xpath = "//button[@type='submit' and contains(text() , 'Addresses')]")
    private WebElement btnSubmitAddress;

    @FindBy(xpath = "//button[@type='submit' and contains(text() , 'Create insurer')]")
    private WebElement btnCreateInsurer;

    @FindBy(xpath = "//div[@class='MuiAlert-message' and contains(text(), 'Insurer successfully created.')]")
    private WebElement alertMessage;

    public CreateInsurerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openCreateInsurerPopup() {
        wait.forElementToBeClickable(5, sidebarAddBtn, "Add button");
        sidebarAddBtn.click();
        wait.forElementToBeClickable(5, createInsurerBtn, "Insurer button");
        createInsurerBtn.click();
    }

    public void fillGeneralInformation(String displayName, String companyName, String language, String website) {
        super.fillGeneralInformation(displayName, companyName, language, website);
        btnContact.click();
    }

    public void fillContactInformation(String emailType, String email, String phoneType, String phoneValue, String phoneExt) {
        super.fillContactInformation(emailType, email, phoneType, phoneValue, phoneExt);
        btnSubmitAddress.click();
    }

    public void clickCreateButton() {
        btnCreateInsurer.click();
    }

    public boolean isCreateSuccessful() {
        String successMessage = "Insurer successfully created.";
        wait.forElementToBeDisplayed(5, alertMessage, "Alert Message");
        return alertMessage.isDisplayed() && successMessage.equals(alertMessage.getText());
    }

}
