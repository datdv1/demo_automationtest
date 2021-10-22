package com.equisoft.centralize.automationtest.stepDefinitions.basepage;

import com.equisoft.centralize.automationtest.infrastructure.driver.Setup;
import com.equisoft.centralize.automationtest.infrastructure.driver.Wait;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }

}
