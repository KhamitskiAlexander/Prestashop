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
    private final By cartIcon = By.id("_desktop_cart");
    private final By numberInCartIcon = By.xpath("//span[@class='cart-products-count']");
    private final By popularProducts = By.xpath("//picture");
    private final By addingProduct = By.cssSelector("h1");

    public void openMainPage() {
        getBrowserDriver().get(BaseUrl.PRESTASHOP);
    }

    public void clickRandomItem() {
        DriverActions.jsScrollTo(popularProducts);
        List<WebElement> listOfPopularProducts = DriverActions.getListOfWebElements(popularProducts);
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

    public String getAddedItemName() {
        return DriverActions.getText(addingProduct);
    }

    public String getNumberOfItemsInCart() {
        return DriverActions.getText(numberInCartIcon);
    }

    public void clickCartIcon() {
        DriverActions.click(cartIcon);
    }
}