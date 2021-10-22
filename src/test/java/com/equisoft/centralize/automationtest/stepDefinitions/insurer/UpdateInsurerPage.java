package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateInsurerPage extends ListInsurerPage {

    @FindBy(xpath = "//div[contains(@class, 'InsurerProfile_ProfileActions')]/div/button[@type='submit']")
    private WebElement editInsurerBtn;

    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Save')]")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[@class='MuiAlert-message' and contains(text(), 'Insurer modifications applied successfully.')]")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[contains(@class, 'FormEditInsurer_HeaderContainer')]//span[@class='MuiTab-wrapper' and contains(text() , 'Contact')]/..")
    private WebElement contactSectionBtn;

    @FindBy(xpath = "//div[contains(@class, 'FormEditInsurer_HeaderContainer')]//span[@class='MuiTab-wrapper' and contains(text() , 'Addresses')]/..")
    private WebElement addressSectionBtn;

    public UpdateInsurerPage() {
        super();
    }

    public void goToEditAnInsurer() {
        goToInsurersListPage();
        selectAnInsurer();
        isSelectedInsurerDisplayed();
        isSelectedInsurerShowOnFolder();
        wait.forElementToBeClickable(5, editInsurerBtn, "Edit Insurer Button");
        editInsurerBtn.click();
    }

    public void clickSave() {
        saveBtn.click();
    }

    public boolean isEditSuccessful() {
        String successMessage = "Insurer modifications applied successfully.";
        wait.forElementToBeDisplayed(5, alertMessage, "Alert Message");
        return alertMessage.isDisplayed() && successMessage.equals(alertMessage.getText());
    }

    public void editGeneralInformation(String displayName, String companyName, String language, String website) {
        super.fillGeneralInformation(displayName, companyName, language, website);
    }

    public void editContactInformation(String emailType, String email, String phoneType, String phoneValue, String phoneExt) {
        wait.forElementToBeDisplayed(5, contactSectionBtn, "Contact Section Button");
        contactSectionBtn.click();
        super.fillContactInformation(emailType, email, phoneType, phoneValue, phoneExt);
    }

    public void editAddressInformation(String addressType, String country, String address, String addressApt, String city, String province, String postalCode) {
        wait.forElementToBeDisplayed(5, addressSectionBtn, "Address Section Button");
        addressSectionBtn.click();
        super.fillAddressInformation(addressType, country, address, addressApt, city, province, postalCode);
    }

    public boolean verifyNewInformation() {
        return checkGeneralInfo() && checkContactInfo() && checkAddressInfo();
    }

}
