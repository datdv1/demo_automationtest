package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import com.equisoft.centralize.automationtest.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateInsurerPage extends ListInsurerPage {

    private final String COMPANY_NAME = "New company name";
    private final String DISPLAY_NAME = "New insurer display name";
    private final String LANGUAGE = "French";
    private final String WEBSITE = "new-company-website.company-domain.com";
    private final String EMAIL_TYPE = "New bussiness";
    private final String EMAIL = "newcompany@company-domain.com";
    private final String PHONE_TYPE = "Company";
    private final String PHONE = "+1 (098) 765-4321";
    private final String PHONE_EXT = "ABC";
    private final String ADDRESS_TYPE = "Claim";
    private final String ADDRESS = "481 Rue Saint-Pierre";
    private final String PROVINCE = "Quebec";
    private final String CITY = "Drummondville";
    private final String POSTAL_CODE = "J2C 3W4";
    private final String ADDRESS_ADDITIONAL_INFO = "3rd floor";

    @FindBy(xpath = "//div[contains(@class, 'InsurerProfile_ProfileActions')]/div/button[@type='submit']")
    private WebElement editInsurerBtn;

    @FindBy(xpath = "//span[@class='MuiTab-wrapper' and contains(text(), 'Addresses')]/..")
    private WebElement addressesSection;

    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Save')]")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[@class='MuiAlert-message' and contains(text(), 'Insurer modifications applied successfully.')]")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[contains(text(), 'Company name - default')]/..//input")
    private WebElement companyNameInput;

    @FindBy(xpath = "//div[contains(text(), 'Display name - default')]/..//input")
    private WebElement displayNameInput;

    @FindBy(xpath = "//div[contains(@class, 'FormCreateInsurer_SelectLanguage')]")
    private WebElement groupLanguage;

    @FindBy(xpath = "//label[contains(text(), 'Website')]/..//input")
    private WebElement websiteInput;

    @FindBy(xpath = "//span[@class='MuiTab-wrapper' and contains(text() , 'Contact')]/..")
    private WebElement contactSectionBtn;

    @FindBy(xpath = "//div[contains(@class, 'ContactEmailContainer')]")
    private WebElement emailContainer;

    @FindBy(xpath = "//div[contains(@class, 'ContactPhoneContainer')]")
    private WebElement phoneContainer;

    @FindBy(xpath = "//span[@class='MuiTab-wrapper' and contains(text() , 'Addresses')]/..")
    private WebElement addressSectionBtn;

    @FindBy(xpath = "//div[contains(@class, 'AddressManagementContainer')]")
    private WebElement addressContainer;

    public UpdateInsurerPage() {
        super();
    }

    public void goToEditAnInsurer() {
        goToInsurersListPage();
        selectAnInsurer();
        isSelectedInsurerShowOnFolder();
        isSelectedInsurerDisplayed();
        wait.forElementToBeDisplayed(5, editInsurerBtn, "Edit Insurer Button");
        editInsurerBtn.click();
    }

    public void locateToAddressesSection() {
        wait.forElementToBeDisplayed(5, addressesSection, "Address Section Button");
        addressesSection.click();
    }

    public void clickSave() {
        saveBtn.click();
    }

    public boolean isEditSuccessful() {
        String successMessage = "Insurer modifications applied successfully.";
        wait.forElementToBeDisplayed(5, alertMessage, "Alert Message");
        return alertMessage.isDisplayed() && successMessage.equals(alertMessage.getText());
    }

    public void editGeneralInformation() {
        wait.forElementToBeDisplayed(5, companyNameInput, "Company Name Group");
        // Update company name
        WebDriverUtils.sendKeys(companyNameInput, COMPANY_NAME);
        // Update display name
        WebDriverUtils.sendKeys(displayNameInput, DISPLAY_NAME);
        // Update language
        WebElement languageInput = groupLanguage.findElement(By.tagName("input"));
        languageInput.click();
        WebElement languageOption = groupLanguage.findElement(By.xpath("//li[@aria-label='" + LANGUAGE + "']"));
        languageOption.click();
        // Update website
        WebDriverUtils.sendKeys(websiteInput, WEBSITE);
    }

    public void editContactInformation() {
        wait.forElementToBeDisplayed(5, contactSectionBtn, "Contact Section Button");
        contactSectionBtn.click();
        // Edit email information.
        // - Select email type.
        wait.forPresenceOfElements(5, By.xpath("//div[contains(@class, 'ContactEmailContainer')]"), "Email Container");
        WebElement emailTypeDropdownBtn = emailContainer.findElement(By.xpath("./div[contains(@class, 'SelectLanguage')]//button"));
        emailTypeDropdownBtn.click();
        WebElement emailTypeOption = emailContainer.findElement(By.xpath(".//li[@aria-label='" + EMAIL_TYPE + "']"));
        emailTypeOption.click();
        // - Update email.
        WebElement emailInput = emailContainer.findElement(By.xpath(".//div[contains(@class, 'EmailLabel')]/..//input"));
        WebDriverUtils.sendKeys(emailInput, EMAIL);

        // Edit phone information.
        // - Select phone type.
        waitToSeePhoneContainer();
        WebElement phoneTypeDropdownBtn = phoneContainer.findElement(By.xpath("./div[contains(@class, 'SelectLanguage')]//button"));
        phoneTypeDropdownBtn.click();
        WebElement phoneTypeOption = phoneContainer.findElement(By.xpath(".//li[@aria-label='" + PHONE_TYPE + "']"));
        phoneTypeOption.click();
        // - Update phone number.
        WebElement phoneInput = phoneContainer.findElement(By.xpath(".//div[contains(@class, 'PhoneInputContainer')]//input"));
        WebDriverUtils.sendKeys(phoneInput, PHONE);
        // - Update phone ext.
        WebElement phoneExtInput = phoneContainer.findElement(By.xpath(".//div[contains(@class, 'PhoneExt')]//input"));
        WebDriverUtils.sendKeys(phoneExtInput, PHONE_EXT);
    }

    public void editAddressInformation() {
        wait.forElementToBeDisplayed(5, addressSectionBtn, "Address Section Button");
        addressSectionBtn.click();
        // Update address information.
        // - Update address type.
        WebElement addressTypeDropdownBtn = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Type')]//button"));
        addressTypeDropdownBtn.click();
        WebElement addressTypeOption = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Type')]//li[@aria-label='" + ADDRESS_TYPE + "']"));
        addressTypeOption.click();
        // - Update country.
        WebElement countryDropdownBtn = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Country')]//button"));
        countryDropdownBtn.click();
        WebElement countryOption = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Country')]//li[@aria-label='Canada']"));
        countryOption.click();
        // - Update address.
        WebElement addressInput = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Address')]//input"));
        WebDriverUtils.sendKeys(addressInput, ADDRESS);
        // - Update additional info.
        WebElement addressAptInput = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Apt')]//input"));
        WebDriverUtils.sendKeys(addressAptInput, ADDRESS_ADDITIONAL_INFO);
        // - Update city.
        WebElement cityInput = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_City')]//input"));
        WebDriverUtils.sendKeys(cityInput, CITY);
        // - Update postal code.
        WebElement postalInput = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_PostalCode')]//input"));
        WebDriverUtils.sendKeys(postalInput, POSTAL_CODE);
        // - Update province/state.
        WebElement provinceDropdownBtn = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Province')]//button"));
        provinceDropdownBtn.click();
        wait.forPresenceOfElements(5, By.xpath("//div[contains(@class, 'AddressManagement_Province')]//li[@aria-label='" + PROVINCE + "']"), "Quebec Province");
        WebElement provinceOption = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Province')]//li[@aria-label='" + PROVINCE + "']"));
        provinceOption.click();
    }

    public boolean verifyNewInformation() {
        // Wait for all new data to be updated to UI.
        String containsColumnTitle = "contains(@class, 'InsurerInformationColumnTitle')";
        String containsColumnValue = "contains(@class, 'InsurerInformationColumnValue')";
        wait.forElementToBeDisplayed(5, insurerProfileName, "Selected Insurer Profile Name");
        wait.forPresenceOfElements(5, By.xpath("//div[contains(@class,'ProfileName')]/h2[contains(text(), '" + DISPLAY_NAME + "')]"), "New Display Name");
        wait.forPresenceOfElements(5, By.xpath("//div[" + containsColumnValue + " and contains(text(), '" + COMPANY_NAME + "')]"), "New Company Name");
        wait.forPresenceOfElements(5, By.xpath("//div[" + containsColumnValue + " and contains(text(), '" + LANGUAGE + "')]"), "New Language");
        wait.forPresenceOfElements(5, By.xpath("//span[contains(text(), '" + WEBSITE + "')]"), "New Website");
        String emailContainer = "//div[" + containsColumnTitle + " and contains(text(), 'Email(s)')]/..";
        wait.forPresenceOfElements(5, By.xpath(emailContainer + "//span[" + containsColumnTitle + " and contains(text(), '" + EMAIL_TYPE + "')]"), "New Email Type");
        wait.forPresenceOfElements(5, By.xpath(emailContainer + "//span[contains(text(), '" + EMAIL + "')]"), "New Email");
        String phoneContainer = "//div[" + containsColumnTitle + " and contains(text(), 'Phone(s)')]/..";
        wait.forPresenceOfElements(5, By.xpath(phoneContainer + "//span[" + containsColumnTitle + " and contains(text(), '" + PHONE_TYPE + "')]"), "New Phone Type");
        wait.forPresenceOfElements(5, By.xpath(phoneContainer + "//span[" + containsColumnValue + "]//span[contains(text(), '" + PHONE + "')]"), "New Phone Number");
        wait.forPresenceOfElements(5, By.xpath(phoneContainer + "//span[" + containsColumnValue + "]//span[contains(text(), '" + PHONE_EXT + "')]"), "New Phone Ext");
        String addressContainer = "//div[" + containsColumnTitle + " and contains(text(), 'Addresses')]/..";
        wait.forPresenceOfElements(5, By.xpath(addressContainer + "//span[" + containsColumnTitle + " and contains(text(), '" + ADDRESS_TYPE + "')]"), "New Address Type");
        wait.forPresenceOfElements(5, By.xpath(addressContainer + "//span[" + containsColumnValue + " and contains(text(), '" + ADDRESS + "')]"), "New Address");

        WebElement emailType = email.findElement(By.xpath("./span[" + containsColumnTitle + "]"));
        WebElement emailAddress = email.findElement(By.xpath(".//span[" + containsColumnValue + "]//span"));
        WebElement phoneType = phone.findElement(By.xpath("./span[" + containsColumnTitle + "]"));
        WebElement phoneNumber = phone.findElement(By.xpath(".//span[" + containsColumnValue + "]//span"));
        WebElement addressType = address.findElement(By.xpath("./span[" + containsColumnTitle + "]"));
        String addressInfo = address.findElement(By.xpath(".//span[" + containsColumnValue + "]")).getText();
        // Verify new data.
        return DISPLAY_NAME.equals(insurerProfileName.getText()) && COMPANY_NAME.equals(companyName.getText()) &&
                LANGUAGE.equals(communicationLanguage.getText()) && WEBSITE.equals(website.getText()) &&
                emailType.getText().contains(EMAIL_TYPE) && EMAIL.equals(emailAddress.getText()) &&
                phoneType.getText().contains(PHONE_TYPE) && phoneNumber.getText().contains(PHONE) &&
                phoneNumber.getText().contains(PHONE_EXT) && addressType.getText().contains(ADDRESS_TYPE) &&
                addressInfo.contains(ADDRESS) && addressInfo.contains(ADDRESS_ADDITIONAL_INFO) &&
                addressInfo.contains(CITY) && addressInfo.contains(PROVINCE) && addressInfo.contains(POSTAL_CODE);
    }

    private void waitToSeePhoneContainer() {
        try {
            wait.forPresenceOfElements(5, By.xpath("//div[contains(@class, 'ContactPhoneContainer')]"), "Email Container");
        } catch (Exception e) {
            WebElement addPhoneBtn = driver.findElement(By.xpath("//button[contains(@class, 'ContactPhoneList_AddPhone')]"));
            addPhoneBtn.click();
            wait.forPresenceOfElements(5, By.xpath("//div[contains(@class, 'ContactPhoneContainer')]"), "Email Container");
        }
    }

}
