package com.prestashop.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import org.assertj.core.api.Assertions;
import com.prestashop.pages.CartPage;
import com.prestashop.pages.CommonPage;
import com.prestashop.utils.DriverActions;

public class CartSteps {
    private final CartPage cartPage;
    private final CommonPage commonPage;
    public static List<String> EXPECTED_ITEMS_IN_CART = new ArrayList<>();

    public CartSteps(CartPage cartPage, CommonPage commonPage) {
        this.cartPage = cartPage;
        this.commonPage = commonPage;
    }

    @And("user sees added products on Cart Page")
    public void userSeesAddedProductsOnCartPage() {
        commonPage.switchToIframe();
        List<String> actualItemsInCart = cartPage.getAllItemNamesInCart();
        Assertions
                .assertThat(EXPECTED_ITEMS_IN_CART)
                .as("All added products should be displayed in the cart")
                .containsAll(actualItemsInCart);
        commonPage.switchToDefaultContent();
    }

    @And("user clicks 'PROCEED TO CHECKOUT' button on Cart Page")
    public void userClicksProceedToCheckoutButtonOnCartPage() {
        commonPage.switchToIframe();
        cartPage.clickProceedToCheckoutButton();
        commonPage.switchToDefaultContent();
    }

    @And("user clicks {string} button")
    public void clickButtonOnPage(String buttonName) {
        commonPage.switchToIframe();
        DriverActions.clickOnButtonWithName(buttonName);
        commonPage.switchToDefaultContent();
    }
}
