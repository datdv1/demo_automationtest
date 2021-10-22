package com.equisoft.centralize.automationtest.stepDefinitions.login;

import com.equisoft.centralize.automationtest.stepDefinitions.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//button[@aria-label='account of current user']")
    private WebElement userAvatar;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        String HOME_PAGE_URL = "https://stagging-claims01.dev.centralize.equisoft.com";
        driver.get(HOME_PAGE_URL);
        wait.forLoading(5);
    }

    public void enterUsernameAndPassword() {
        wait.forElementToBeDisplayed(10, usernameInput, "Username input");
        wait.forElementToBeDisplayed(10, passwordInput, "Password input");
        String USERNAME = "admin";
        String PASSWORD = "Centralize123!";
        usernameInput.sendKeys(USERNAME);
        passwordInput.sendKeys(PASSWORD);
    }

    public void clickLoginButton() {
        wait.forElementToBeDisplayed(10, submitBtn, "Login button");
        submitBtn.click();
    }

    public boolean isDashboardDisplayed() {
        wait.forElementToBeDisplayed(5, userAvatar, "Dashboard");
        return userAvatar.isDisplayed();
    }

}
