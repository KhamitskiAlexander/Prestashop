package pages;

import config.BaseUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverActions;

import java.util.List;
import java.util.Random;

public class PrestashopMainPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrestashopMainPage.class);
    private final By CART_ICON = By.id("_desktop_cart");
    private final By NUMBER_IN_CART_ICON = By.xpath("//span[@class='cart-products-count']");
    private final By POPULAR_PRODUCTS = By.xpath("//picture");
    private final By FRAMELIVE = By.id("framelive");
    private final By ADDING_PRODUCT = By.cssSelector("h1");

    public void openMainPage() {
        getBrowserDriver().get(BaseUrl.PRESTASHOP);
    }

    public void clickRandomItem() {
        DriverActions.jsScrollTo(POPULAR_PRODUCTS);
        List<WebElement> listOfPopularProducts = DriverActions.getListOfWebElements(POPULAR_PRODUCTS);
        if (!listOfPopularProducts.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(listOfPopularProducts.size());
            WebElement randomProduct = listOfPopularProducts.get(randomIndex);
            randomProduct.click();
            LOGGER.info("Clicked on a random product.");
        } else {
            LOGGER.error("The list of popular products is empty.");
        }
    }

    public void switchToIFrame() {
        DriverActions.switchToIframe(FRAMELIVE);
    }

    public void switchToDefaultContent() {
        DriverActions.switchToDefaultContent();
    }

    public String getAddedItemName() {
        return DriverActions.getText(ADDING_PRODUCT);
    }

    public String getNumberOfItemsInCart() {
        return DriverActions.getText(NUMBER_IN_CART_ICON);
    }

    public void clickCartIcon() {
        DriverActions.click(CART_ICON);
    }
}