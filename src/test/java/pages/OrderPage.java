package pages;

import org.openqa.selenium.By;
import utils.DriverActions;

public class OrderPage extends BasePage {
    private final By FRAMELIVE = By.id("framelive");
    private final By PERSONAL_INFORMATION_SECTION_TITLE =
            By.xpath("//section[contains(@id, 'personal')]/h1[contains(@class, 'title')]");

    public void switchToIFrame() {
        DriverActions.switchToIframe(FRAMELIVE);
    }

    public void switchToDefaultContent() {
        DriverActions.switchToDefaultContent();
    }

    public String getPersonalInformationSectionTitle() {
        return DriverActions.getText(PERSONAL_INFORMATION_SECTION_TITLE).trim();
    }
}
