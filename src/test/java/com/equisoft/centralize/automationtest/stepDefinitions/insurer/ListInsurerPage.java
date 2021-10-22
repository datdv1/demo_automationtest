package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListInsurerPage extends InsurerPage {

    @FindBy(xpath = "//div[contains(@class,'ProfileName')]/h2")
    protected WebElement insurerProfileName;

    public ListInsurerPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isSelectedInsurerShowOnFolder() {
        String insurerFolderItemXpath = String.format("//span[@class='MuiTypography-root MuiListItemText-primary MuiTypography-body1 MuiTypography-displayBlock' and contains(text(), '%s')]", insurerName);
        wait.forPresenceOfElements(5, By.xpath(insurerFolderItemXpath), "Selected Insurer Folder");
        WebElement insurerFolderItem = driver.findElement(By.xpath(insurerFolderItemXpath));
        return insurerFolderItem.isDisplayed();
    }

    public boolean isSelectedInsurerDisplayed() {
        wait.forElementToBeDisplayed(5, insurerProfileName, "Selected Insurer Profile Name");
        return insurerName.equals(insurerProfileName.getText());
    }

}
