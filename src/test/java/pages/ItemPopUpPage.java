package pages;

import org.openqa.selenium.By;
import utils.DriverActions;

public class ItemPopUpPage extends BasePage {

    private final By FRAMELIVE = By.id("framelive");
    private final By MESSAGE_AFTER_ADDING = By.cssSelector("h4");
    private final By CLOSE_NOTIFICATION_MSG = By.xpath("//i[@class='material-icons' and contains(text(),'close')]");
    private final By proceedToCheckoutButton = By.xpath("//div[@class='cart-content-btn']//a[@class='btn btn-primary']");

    public void switchToIFrame() {
        DriverActions.switchToIframe(FRAMELIVE);
    }

    public void switchToDefaultContent() {
        DriverActions.switchToDefaultContent();
    }

    public String getMessageAfterAdding() {
        String textOfMessage = DriverActions.getText(MESSAGE_AFTER_ADDING);
        DriverActions.click(CLOSE_NOTIFICATION_MSG);
        return textOfMessage;
    }

    public void clickProceedToCheckoutButton() {
        DriverActions.click(proceedToCheckoutButton);
    }
}
