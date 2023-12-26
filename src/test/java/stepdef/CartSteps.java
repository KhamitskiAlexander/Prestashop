package stepdef;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import org.assertj.core.api.Assertions;
import pages.CartPage;
import utils.DriverActions;

public class CartSteps {
    private final CartPage cartPage;
    public static List<String> EXPECTED_ITEMS_IN_CART = new ArrayList<>();

    public CartSteps(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    @And("user sees added products on Cart Page")
    public void userSeesAddedProductsOnCartPage() {
        cartPage.switchToIFrame();
        List<String> actualItemsInCart = cartPage.getAllItemNamesInCart();
        Assertions
                .assertThat(EXPECTED_ITEMS_IN_CART)
                .as("All added products should be displayed in the cart")
                .containsAll(actualItemsInCart);
        DriverActions.switchToDefaultContent();
    }

    @And("user clicks 'PROCEED TO CHECKOUT' button on Cart Page")
    public void userClicksProceedToCheckoutButtonOnCartPage() {
        cartPage.switchToIFrame();
        cartPage.clickProceedToCheckoutButton();
        DriverActions.switchToDefaultContent();
    }
}
