package pages;

import org.openqa.selenium.By;
import utils.DriverActions;

public class ItemPage extends BasePage {

    private final By FRAMELIVE = By.id("framelive");

    public void switchToIFrame() {
        DriverActions.switchToIframe(FRAMELIVE);
    }

    public void switchToDefaultContent() {
        DriverActions.switchToDefaultContent();
    }
}
