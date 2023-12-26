package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webdrivers.DriverManager;

public abstract class BasePage {

    public WebDriver getBrowserDriver() {
        return DriverManager.getInstance().getWebDriver();
    }

    /**
     * Initializes an instance of {@link BasePage}.
     */
    public BasePage() {
        PageFactory.initElements(getBrowserDriver(), this);
    }
}