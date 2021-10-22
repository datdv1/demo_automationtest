package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import com.equisoft.centralize.automationtest.stepDefinitions.basepage.BasePage;
import com.equisoft.centralize.automationtest.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InsurerPage extends BasePage {
    
    private static final String CONTAINS_COLUMN_TITLE = "contains(@class, 'InsurerInformationColumnTitle')";
    private static final String CONTAINS_COLUMN_VALUE = "contains(@class, 'InsurerInformationColumnValue')";

    @FindBy(xpath = "//div[contains(@class, 'SidebarButton_SidebarButtonName') and contains(text(), 'Folders')]/..")
    private WebElement folderBtn;

    @FindBy(xpath = "//span[@class='MuiTypography-root MuiListItemText-primary MuiTypography-body1 MuiTypography-displayBlock' and contains(text(), 'Insurers')]")
    private WebElement insurerFolderItem;

    @FindBy(xpath = "//div[contains(@class, 'Insurers_Header')]/h2[contains(text(), 'Insurers')]")
    private WebElement insurerPageTitle;

    @FindBy(xpath = "//div[@role='rowgroup']/div[@role='row']")
    private List<WebElement> insurerList;

    @FindBy(xpath = "//div[@role='rowgroup']/div[@role='row'][1]")
    private WebElement insurerRecord;

    @FindBy(xpath = "//div[contains(@class,'ProfileName')]/h2")
    protected WebElement insurerProfileName;

    @FindBy(xpath = "//label[contains(text(), 'Company name - default')]/..//input")
    private WebElement companyNameInput;

    @FindBy(xpath = "//label[contains(text(), 'Display name - default')]/..//input")
    private WebElement displayNameInput;

    @FindBy(xpath = "//div[contains(@class, 'FormCreateInsurer_SelectLanguage')]")
    private WebElement languageGroup;

    @FindBy(xpath = "//label[contains(text(), 'Website')]/..//input")
    private WebElement websiteInput;

    @FindBy(xpath = "//div[contains(@class, 'ContactEmail_SelectType')]")
    private WebElement emailTypeGroup;

    @FindBy(xpath = "//div[contains(@class, 'ContactEmail_EmailLabel')]/..//input")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(@class, 'ContactPhoneList_AddPhone')]")
    private WebElement addPhoneBtn;

    @FindBy(xpath = "//div[contains(@class, 'ContactPhone_SelectType')]")
    private WebElement phoneTypeGroup;

    @FindBy(xpath = "//div[contains(@class, 'ContactPhone_PhoneInput')]//input")
    private WebElement phoneValueInput;

    @FindBy(xpath = "//div[contains(@class, 'ContactPhone_PhoneExt')]//input")
    private WebElement phoneExtInput;

    @FindBy(xpath = "//div[contains(@class, 'AddressManagement_Type')]")
    private WebElement addressTypeGroup;

    @FindBy(xpath = "//div[contains(@class, 'AddressManagement_Country')]")
    private WebElement countryGroup;

    @FindBy(xpath = "//div[contains(@class, 'AddressManagement_Address_')]//input")
    private WebElement addressInput;

    @FindBy(xpath = "//div[contains(@class, 'AddressManagement_Apt')]//input")
    private WebElement addressAdditionalInfoInput;

    @FindBy(xpath = "//div[contains(@class, 'AddressManagement_City')]//input")
    private WebElement cityInput;

    @FindBy(xpath = "//div[contains(@class, 'AddressManagement_PostalCode')]//input")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//div[contains(@class, 'AddressManagement_Province')]")
    private WebElement provinceGroup;

    @FindBy(xpath = "//div[contains(@class, 'InsurerInformationColumnTitle') and contains(text(), 'Addresses')]/../div[contains(@class, 'InsurerInformationContainerContent')]")
    protected WebElement address;
    
    protected String DISPLAY_NAME;
    protected String COMPANY_NAME;
    protected String LANGUAGE;
    protected String WEBSITE;
    protected String EMAIL_TYPE;
    protected String EMAIL;
    protected String PHONE_TYPE;
    protected String PHONE_VALUE;
    protected String PHONE_EXT;
    protected String ADDRESS_TYPE;
    protected String ADDRESS;
    protected String PROVINCE;
    protected String CITY;
    protected String POSTAL_CODE;
    protected String ADDRESS_ADDITIONAL_INFO;

    public InsurerPage() {
        PageFactory.initElements(driver, this);
    }

    public void goToInsurersListPage() {
        wait.forElementToBeClickable(5, folderBtn, "Folder button");
        folderBtn.click();
        wait.forElementToBeClickable(5, insurerFolderItem, "Insurer folder item");
        insurerFolderItem.click();
    }

    public boolean isInsurerListPageDisplayed() {
        wait.forElementToBeDisplayed(5, insurerPageTitle, "Insurer page title");
        return insurerPageTitle.isDisplayed();
    }

    public boolean isInsurerListDisplayed() {
        wait.forPresenceOfElements(5, By.xpath("//div[@role='rowgroup']/div[@role='row']"), "Insurer List");
        return insurerList.size() > 0;
    }

    public void selectAnInsurer() {
        wait.forElementToBeDisplayed(5, insurerRecord, "Insurer record");
        WebElement insurerNameCell = insurerRecord.findElement(By.xpath("./div[@role='cell'][1]"));
        DISPLAY_NAME = insurerNameCell.getText();
        insurerRecord.click();
    }


    public void fillGeneralInformation(String displayName, String companyName, String language, String website) {
        this.DISPLAY_NAME = displayName;
        this.COMPANY_NAME = companyName;
        this.LANGUAGE = language;
        this.WEBSITE = website;
        wait.forElementToBeDisplayed(5, companyNameInput, "Company Name Input");
        WebDriverUtils.sendKeys(companyNameInput, COMPANY_NAME);
        WebDriverUtils.sendKeys(displayNameInput, DISPLAY_NAME);

        WebElement languageDropdownBtn = languageGroup.findElement(By.tagName("button"));
        languageDropdownBtn.click();
        wait.forElementToBeClickable(5, By.xpath("//li[@aria-label='" + LANGUAGE + "']"), "Language Option");
        WebElement languageOption = languageGroup.findElement(By.xpath("//li[@aria-label='" + LANGUAGE + "']"));
        languageOption.click();
        WebDriverUtils.sendKeys(websiteInput, WEBSITE);
    }

    public void fillContactInformation(String emailType, String email, String phoneType, String phoneValue, String phoneExt) {
        this.EMAIL_TYPE = emailType;
        this.EMAIL = email;
        this.PHONE_TYPE = phoneType;
        this.PHONE_VALUE = phoneValue;
        this.PHONE_EXT = phoneExt;
        wait.forElementToBeDisplayed(5, emailTypeGroup, "Email Type Select Box");
        WebElement typeInput = emailTypeGroup.findElement(By.tagName("button"));
        typeInput.click();
        By emailTypeOptionCondition = By.xpath("//li[@aria-label = '" + EMAIL_TYPE + "']");
        wait.forElementToBeClickable(5, emailTypeOptionCondition, "Email Type Option");
        WebElement emailTypeOption = emailTypeGroup.findElement(emailTypeOptionCondition);
        emailTypeOption.click();
        wait.forElementToBeClickable(5, emailInput, "Email Input");
        WebDriverUtils.sendKeys(emailInput, EMAIL);

        waitToSeePhoneContainer();
        wait.forElementToBeDisplayed(5, phoneTypeGroup, "Phone Type Group");
        WebElement selectTypePhone = phoneTypeGroup.findElement(By.tagName("button"));
        selectTypePhone.click();
        By phoneTypeOptionCondition = By.xpath("//li[@aria-label = '" + PHONE_TYPE + "']");
        wait.forElementToBeClickable(5, phoneTypeOptionCondition, "Phone Type Option");
        WebElement phoneTypeOption = phoneTypeGroup.findElement(phoneTypeOptionCondition);
        phoneTypeOption.click();
        WebDriverUtils.sendKeys(phoneValueInput, PHONE_VALUE);
        phoneExtInput.sendKeys(PHONE_EXT);
    }

    public void fillAddressInformation(String addressType, String country, String address, String addressApt, String city, String province, String postalCode) {
        this.ADDRESS_TYPE = addressType;
        this.ADDRESS = address;
        this.ADDRESS_ADDITIONAL_INFO = addressApt;
        this.CITY = city;
        this.PROVINCE = province;
        this.POSTAL_CODE = postalCode;
        wait.forElementToBeDisplayed(5, addressTypeGroup, "Address Section");
        WebElement addressTypeDropdownBtn = addressTypeGroup.findElement(By.tagName("button"));
        addressTypeDropdownBtn.click();
        By addressTypeOptionCondition = By.xpath("//li[@aria-label='" + ADDRESS_TYPE + "']");
        wait.forElementToBeClickable(5, addressTypeOptionCondition, "Address Type Option");
        WebElement addressTypeOption = addressTypeGroup.findElement(addressTypeOptionCondition);
        addressTypeOption.click();

        WebElement countryDropdownBtn = countryGroup.findElement(By.tagName("button"));
        countryDropdownBtn.click();
        By countryOptionCondition = By.xpath("//li[@aria-label='" + country + "']");
        wait.forElementToBeClickable(5, countryOptionCondition, "Country Option");
        WebElement countryOption = countryGroup.findElement(countryOptionCondition);
        countryOption.click();

        wait.forElementToBeClickable(5, addressInput, "Address Input");
        WebDriverUtils.sendKeys(addressInput, ADDRESS);
        wait.forElementToBeClickable(5, addressAdditionalInfoInput, "Address Additional Info Input");
        WebDriverUtils.sendKeys(addressAdditionalInfoInput, ADDRESS_ADDITIONAL_INFO);
        wait.forElementToBeClickable(5, cityInput, "City Input");
        WebDriverUtils.sendKeys(cityInput, CITY);
        wait.forElementToBeClickable(5, postalCodeInput, "Postal Code Input");
        WebDriverUtils.sendKeys(postalCodeInput, POSTAL_CODE);

        WebElement provinceDropdownBtn = provinceGroup.findElement(By.tagName("button"));
        provinceDropdownBtn.click();
        By provinceOptionCondition = By.xpath("//li[@aria-label='" + PROVINCE + "']");
        wait.forPresenceOfElements(5, provinceOptionCondition, "Province Option");
        WebElement provinceOption = addressTypeGroup.findElement(provinceOptionCondition);
        provinceOption.click();
    }

    public boolean checkGeneralInfo() {
        wait.forPresenceOfElements(5, By.xpath("//div[contains(@class,'ProfileNameContainer')]/div[contains(@class,'ProfileName')]/h2[contains(text(), '" + DISPLAY_NAME + "')]"), "Display Name");
        wait.forPresenceOfElements(5, By.xpath("//div[contains(text() , 'Company name')]/../div[contains(@class , 'InsurerInformation_InsurerInformationColumnValue') and contains(text() , '" + COMPANY_NAME + "')]"), "Company Name");
        wait.forPresenceOfElements(5, By.xpath("//div[contains(text() , 'Communication language')]/../div[contains(@class , 'InsurerInformation_InsurerInformationColumnValue') and contains(text() , '" + LANGUAGE + "')]"), "Communication language");
        wait.forElementToBeClickable(5, By.xpath("//a[@href='" + WEBSITE + "']"), "New Website");
        return true;
    }

    public boolean checkContactInfo() {
        String emailContainer = "//div[" + CONTAINS_COLUMN_TITLE + " and contains(text(), 'Email(s)')]/..";
        wait.forPresenceOfElements(5, By.xpath(emailContainer + "//span[" + CONTAINS_COLUMN_TITLE + " and contains(text(), '" + EMAIL_TYPE + "')]"), "New Email Type");
        wait.forElementToBeClickable(5, By.xpath(emailContainer + "//span[contains(text(), '" + EMAIL + "')]"), "New Email");
        String phoneContainer = "//div[" + CONTAINS_COLUMN_TITLE + " and contains(text(), 'Phone(s)')]/..";
        wait.forPresenceOfElements(5, By.xpath(phoneContainer + "//span[" + CONTAINS_COLUMN_TITLE + " and contains(text(), '" + PHONE_TYPE + "')]"), "New Phone Type");
        wait.forElementToBeClickable(5, By.xpath(phoneContainer + "//span[contains(text(), '" + PHONE_VALUE + "') and contains(text(), '" + PHONE_EXT + "')]"), "New Phone Number");
        return true;
    }

    public boolean checkAddressInfo() {
        String addressContainer = "//div[" + CONTAINS_COLUMN_TITLE + " and contains(text(), 'Addresses')]/..";
        wait.forPresenceOfElements(5, By.xpath(addressContainer + "//span[" + CONTAINS_COLUMN_TITLE + " and contains(text(), '" + ADDRESS_TYPE + "')]"), "New Address Type");
        wait.forPresenceOfElements(5, By.xpath(addressContainer + "//span[" + CONTAINS_COLUMN_VALUE + " and contains(text(), '" + ADDRESS + "')]"), "New Address");

        String addressInfo = address.findElement(By.xpath(addressContainer + "//span[" + CONTAINS_COLUMN_VALUE + " and contains(text(), '" + ADDRESS + "')]")).getText();
        return addressInfo.contains(ADDRESS) && addressInfo.contains(ADDRESS_ADDITIONAL_INFO) &&
                addressInfo.contains(CITY) && addressInfo.contains(PROVINCE) && addressInfo.contains(POSTAL_CODE);
    }

    private void waitToSeePhoneContainer() {
        try {
            wait.forPresenceOfElements(5, By.xpath("//div[contains(@class, 'ContactPhoneContainer')]"), "Email Container");
        } catch (Exception e) {
            wait.forElementToBeClickable(5, addPhoneBtn, "Add Phone Button");
            addPhoneBtn.click();
            wait.forPresenceOfElements(5, By.xpath("//div[contains(@class, 'ContactPhoneContainer')]"), "Email Container");
        }
    }

}
