package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import com.equisoft.centralize.automationtest.stepDefinitions.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InsurerPage extends BasePage {

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

    protected String insurerName = null;

    @FindBy(xpath = "//div[contains(@class, 'InsurerInformationColumnTitle') and contains(text(), 'Company name')]/../div[contains(@class, 'InsurerInformationColumnValue')]")
    protected WebElement companyName;

    @FindBy(xpath = "//div[contains(@class, 'InsurerInformationColumnTitle') and contains(text(), 'Communication language')]/../div[contains(@class, 'InsurerInformationColumnValue')]")
    protected WebElement communicationLanguage;

    @FindBy(xpath = "//div[contains(@class, 'InsurerInformationColumnTitle') and contains(text(), 'Website')]/../div[contains(@class, 'InsurerInformationColumnValue')]//span")
    protected WebElement website;

    @FindBy(xpath = "//div[contains(@class, 'InsurerInformationColumnTitle') and contains(text(), 'Email(s)')]/../div[contains(@class, 'InsurerInformationContainerContent')]")
    protected WebElement email;

    @FindBy(xpath = "//div[contains(@class, 'InsurerInformationColumnTitle') and contains(text(), 'Phone(s)')]/../div[contains(@class, 'InsurerInformationContainerContent')]")
    protected WebElement phone;

    @FindBy(xpath = "//div[contains(@class, 'InsurerInformationColumnTitle') and contains(text(), 'Addresses')]/../div[contains(@class, 'InsurerInformationContainerContent')]")
    protected WebElement address;

    public void goToInsurersListPage() {
        wait.forElementToBeDisplayed(5, folderBtn, "Folder button");
        folderBtn.click();
        wait.forElementToBeDisplayed(5, insurerFolderItem, "Insurer folder item");
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
        insurerName = insurerNameCell.getText();
        insurerRecord.click();
    }

}
