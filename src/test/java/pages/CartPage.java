package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import utils.DriverActions;

public class CartPage extends BasePage {
    private final By FRAMELIVE = By.id("framelive");
    private final By NAME_OF_ITEMS_IN_CART = By.xpath("//div[@class='product-line-info']");
    private final By proceedToCheckoutButton = By.xpath("//div[@class='card cart-summary']//a[@class='btn btn-primary']");

    public void switchToIFrame() {
        DriverActions.switchToIframe(FRAMELIVE);
    }

    public List<String> getAllItemNamesInCart() {
        List <String> listOfThingsInCart = DriverActions.getListOfStrings(NAME_OF_ITEMS_IN_CART);
        List<String> listOfThingsInCartInUpperCase = new ArrayList<>();
        for (String s : listOfThingsInCart) {
            listOfThingsInCartInUpperCase.add(s.toUpperCase());
        }
        return listOfThingsInCartInUpperCase;
    }

    public void clickProceedToCheckoutButton() {
        DriverActions.click(proceedToCheckoutButton);
    }
}
