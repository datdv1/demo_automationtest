package com.equisoft.centralize.automationtest.stepDefinitions.insurer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ListInsurerPage extends InsurerPage {

    public ListInsurerPage() {
        super();
    }

    public boolean isSelectedInsurerShowOnFolder() {
        String insurerFolderItemXpath = "//div[contains(@class, 'PageNavigatorDynamic_ListItemText')]/span[contains(text(), '" + DISPLAY_NAME + "')]";
        wait.forPresenceOfElements(5, By.xpath(insurerFolderItemXpath), "Selected Insurer Folder");
        WebElement insurerFolderItem = driver.findElement(By.xpath(insurerFolderItemXpath));
        return insurerFolderItem.isDisplayed();
    }

    public boolean isSelectedInsurerDisplayed() {
        wait.forElementToBeDisplayed(5, insurerProfileName, "Selected Insurer Profile Name");
        return DISPLAY_NAME.equals(insurerProfileName.getText());
    }

}
