package com.prestashop.pages;

import com.prestashop.utils.DriverActions;
import org.openqa.selenium.By;

public class ItemPopUpPage extends BasePage {
    private final By messageAfterAdding = By.cssSelector("h4");
    private final By closeNotificationMsg = By.xpath("//i[@class='material-icons' and contains(text(),'close')]");
    private final By proceedToCheckoutButton = By.xpath("//div[@class='cart-content-btn']//a[@class='btn btn-primary']");

    public String getMessageAfterAdding() {
        DriverActions.waitToBeVisible(messageAfterAdding);
        String textOfMessage = DriverActions.getText(messageAfterAdding);
        DriverActions.click(closeNotificationMsg);
        return textOfMessage;
    }

    public void clickProceedToCheckoutButton() {
        DriverActions.click(proceedToCheckoutButton);
    }
}
