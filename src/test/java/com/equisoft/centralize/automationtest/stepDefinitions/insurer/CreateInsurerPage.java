package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import com.equisoft.centralize.automationtest.stepDefinitions.basepage.BasePage;
import com.equisoft.centralize.automationtest.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateInsurerPage extends BasePage {

    private static final String INSURER_DISPLAY_NAME = "ABC AUTOMATION Company";
    private static final String INSURER_COMPANY_NAME = "ABC";
    private static final String LANGUAGE_COMPANY = "English";
    private static final String EMAIL_COMPANY = "thien.dao@dirox.net";
    private final String ADDRESS_TYPE = "Head office";
    private final String ADDRESS = "731 Ontario Road";
    private final String PROVINCE = "Ontario";
    private final String CITY = "Welland";
    private final String POSTAL_CODE = "L3B";
    private final String ADDRESS_ADDITIONAL_INFO = "3rd floor";

    @FindBy(id = "sidebar-add-button")
    private WebElement sidebarAddBtn;

    @FindBy(xpath = "//div[contains(@class, 'SidebarAdd_SidebarAddChoice') and contains(text(), 'Insurer')]")
    private WebElement createInsurerBtn;

    @FindBy(xpath = "//div[contains(text(), 'Company name - default')]/..//input")
    private WebElement companyNameInput;

    @FindBy(xpath = "//div[contains(text(), 'Display name - default')]/..//input")
    private WebElement displayNameInput;

    @FindBy(xpath = "//div[contains(@class, 'FormCreateInsurer_SelectLanguage')]")
    private WebElement groupLanguage;

    @FindBy(xpath = "//label[contains(text(), 'Website')]/..//input")
    private WebElement websiteInput;

    @FindBy(xpath = "//button[@type='submit' and contains(text() , 'Contact')]")
    private WebElement btnContact;

    @FindBy(xpath = "//label[contains(text(), 'Type')]/..")
    private WebElement emailTypeGroup;

    @FindBy(xpath = "//div[contains(text(), 'Phone(s)')]/..")
    private WebElement phoneTypeGroup;

    @FindBy(xpath = "//div[contains(text(), 'Phone')]/..//input[@type='tel']")
    private WebElement phoneValueInput;

    @FindBy(xpath = "//label[contains(text(), 'Ext. (optional)')]/..//input")
    private WebElement extPhoneInput;

    @FindBy(xpath = "//button[@type='submit' and contains(text() , 'Addresses')]")
    private WebElement btnSubmitAddress;

    @FindBy(xpath = "//button[@type='submit' and contains(text() , 'Create insurer')]")
    private WebElement btnCreateInsurer;

    @FindBy(xpath = "//div[@class='MuiAlert-message' and contains(text(), 'Insurer successfully created.')]")
    private WebElement alertMessage;

    @FindBy(xpath = "//span[@class='MuiTab-wrapper' and contains(text() , 'Addresses')]/..")
    private WebElement addressSectionBtn;

    @FindBy(xpath = "//div[contains(@class, 'AddressManagementContainer')]")
    private WebElement addressContainer;

    public CreateInsurerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openCreateInsurerPopup() {
        wait.forElementToBeDisplayed(5, sidebarAddBtn, "Add button");
        sidebarAddBtn.click();
        wait.forElementToBeDisplayed(5, createInsurerBtn, "Insurer button");
        createInsurerBtn.click();
    }

    public void fillGeneralInformation() throws InterruptedException {
        wait.forElementToBeDisplayed(5, companyNameInput, "Company Name Group");
        companyNameInput.sendKeys(INSURER_COMPANY_NAME);
        displayNameInput.sendKeys(INSURER_DISPLAY_NAME);
        WebElement languageInput = groupLanguage.findElement(By.tagName("input"));
        languageInput.click();
        WebElement liOption = groupLanguage.findElement(By.xpath("//li[@aria-label='English']"));
        liOption.click();
        websiteInput.sendKeys("http://thien.dao.dirox.net");
        btnContact.click();
    }

    public void fillGeneralContactInformation() throws InterruptedException {
        WebElement typeInput = emailTypeGroup.findElement(By.tagName("input"));
        typeInput.click();
        WebElement liOption = emailTypeGroup.findElement(By.xpath("//li[@aria-label = 'Head office']"));
        liOption.click();
        WebElement emailInput = emailTypeGroup.findElement(By.xpath("//input[@data-testid = 'text-input']"));
        emailInput.sendKeys(EMAIL_COMPANY);
        WebElement buttonPhone = phoneTypeGroup.findElement(By.tagName("button"));
        buttonPhone.click();

        WebElement selectTypePhone = phoneTypeGroup.findElement(By.tagName("input"));
        selectTypePhone.click();
        WebElement liOptionTypePhone = selectTypePhone.findElement(By.xpath("//li[@aria-label = 'Company']"));
        liOptionTypePhone.click();

        phoneValueInput.sendKeys("1231231312");
        extPhoneInput.sendKeys("");
        btnSubmitAddress.click();
    }

    public void clickCreateButton() throws InterruptedException {
        btnCreateInsurer.click();
    }

    public void addAddress() {
        WebElement addressTypeDropdownBtn = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Type')]//button"));
        addressTypeDropdownBtn.click();
        WebElement addressTypeOption = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Type')]//li[@aria-label='" + ADDRESS_TYPE + "']"));
        addressTypeOption.click();
        WebElement countryDropdownBtn = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Country')]//button"));
        countryDropdownBtn.click();
        WebElement countryOption = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Country')]//li[@aria-label='Canada']"));
        countryOption.click();
        WebElement addressInput = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Address')]//input"));
        WebDriverUtils.sendKeys(addressInput, ADDRESS);
        WebElement addressAptInput = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Apt')]//input"));
        WebDriverUtils.sendKeys(addressAptInput, ADDRESS_ADDITIONAL_INFO);
        WebElement cityInput = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_City')]//input"));
        WebDriverUtils.sendKeys(cityInput, CITY);
        WebElement postalInput = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_PostalCode')]//input"));
        WebDriverUtils.sendKeys(postalInput, POSTAL_CODE);
        WebElement provinceDropdownBtn = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Province')]//button"));
        provinceDropdownBtn.click();
        wait.forPresenceOfElements(5, By.xpath("//div[contains(@class, 'AddressManagement_Province')]//li[@aria-label='" + PROVINCE + "']"), "Ontario Province");
        WebElement provinceOption = addressContainer.findElement(By.xpath(".//div[contains(@class, 'AddressManagement_Province')]//li[@aria-label='" + PROVINCE + "']"));
        provinceOption.click();
    }

    public boolean checkDisplayName() {
        wait.forPresenceOfElements(5, By.xpath("//div[contains(@class,'ProfileNameContainer')]/div[contains(@class,'ProfileName')]/h2[contains(text(), '" + INSURER_DISPLAY_NAME + "')]"), "Display Name");
        WebElement insurerProfileName = driver.findElement(By.xpath("//div[contains(@class,'ProfileNameContainer')]/div[contains(@class,'ProfileName')]/h2"));
        return INSURER_DISPLAY_NAME.equals(insurerProfileName.getText());
    }

    public boolean checkCompanyName() {
        wait.forPresenceOfElements(5, By.xpath("//div[contains(text() , 'Company name')]/../div[contains(@class , 'InsurerInformation_InsurerInformationColumnValue') and contains(text() , '" + INSURER_COMPANY_NAME + "')]"), "Company Name");
        WebElement insurerCompanyName = driver.findElement(By.xpath("//div[contains(text() , 'Company name')]/../div[contains(@class , 'InsurerInformation_InsurerInformationColumnValue')]"));
        return INSURER_COMPANY_NAME.equals(insurerCompanyName.getText());
    }

    public boolean checkLanguageCompany() {
        wait.forPresenceOfElements(5, By.xpath("//div[contains(text() , 'Communication language')]/../div[contains(@class , 'InsurerInformation_InsurerInformationColumnValue') and contains(text() , '" + LANGUAGE_COMPANY + "')]"), "Communication language");
        WebElement insurerCompanyName = driver.findElement(By.xpath("//div[contains(text() , 'Communication language')]/../div[contains(@class , 'InsurerInformation_InsurerInformationColumnValue')]"));
        return LANGUAGE_COMPANY.equals(insurerCompanyName.getText());
    }

    public boolean checkEmailCompany() {
        wait.forPresenceOfElements(5, By.xpath("//div[contains(text() , 'Email(s)')]/..//span[contains(@class , 'InsurerInformation_InsurerInformationColumnValue')]//span[contains(text() , '" + EMAIL_COMPANY + "')]"), "Email");
        WebElement insurerEmail = driver.findElement(By.xpath("//div[contains(text() , 'Email(s)')]/..//span[contains(@class , 'InsurerInformation_InsurerInformationColumnValue')]//span"));
        return EMAIL_COMPANY.equals(insurerEmail.getText());
    }

    public boolean isCreateSuccessful() {
        String successMessage = "Insurer successfully created.";
        wait.forElementToBeDisplayed(5, alertMessage, "Alert Message");
        return alertMessage.isDisplayed() && successMessage.equals(alertMessage.getText());
    }

}
