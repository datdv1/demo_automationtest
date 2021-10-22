package com.equisoft.centralize.automationtest.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class WebDriverUtils {

    public static void sendKeys(WebElement element, String keys) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        element.sendKeys(keys);
    }

}
