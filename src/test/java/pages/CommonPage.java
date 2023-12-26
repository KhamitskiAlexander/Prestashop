package pages;

import org.openqa.selenium.By;
import utils.DriverActions;

public class CommonPage {
    private final By framelive = By.id("framelive");

    public void switchToIframe() {
        DriverActions.switchToIframe(framelive);
    }
    public void switchToDefaultContent() {
        DriverActions.switchToDefaultContent();
    }
}
