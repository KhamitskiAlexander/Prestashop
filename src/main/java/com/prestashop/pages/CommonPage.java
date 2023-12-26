package com.prestashop.pages;

import com.prestashop.utils.DriverActions;
import org.openqa.selenium.By;

public class CommonPage {
    private final By framelive = By.id("framelive");

    public void switchToIframe() {
        DriverActions.switchToIframe(framelive);
    }
    public void switchToDefaultContent() {
        DriverActions.switchToDefaultContent();
    }
}
