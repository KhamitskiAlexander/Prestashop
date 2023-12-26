package pages;

import org.openqa.selenium.By;
import utils.DriverActions;

public class CommonPage {
    private final By IFRAME_MAIN = By.id("framelive");

    public void goIntoIFrame() {
        DriverActions.switchToIframe(IFRAME_MAIN);
    }
    public void goOutIFrame() {
        DriverActions.switchToDefaultContent();
    }
}
