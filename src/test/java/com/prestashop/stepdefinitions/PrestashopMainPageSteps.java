package com.prestashop.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import com.prestashop.pages.CommonPage;
import com.prestashop.pages.PrestashopMainPage;

import static com.prestashop.stepdefinitions.CartSteps.EXPECTED_ITEMS_IN_CART;

public class PrestashopMainPageSteps {
    private final PrestashopMainPage prestashopMainPage;
    private final CommonPage commonPage;

    public PrestashopMainPageSteps(PrestashopMainPage prestashopMainPage, CommonPage commonPage) {
        this.prestashopMainPage = prestashopMainPage;
        this.commonPage = commonPage;
    }

    @Given("user open PrestaShop main page from any browser")
    public void userOpenPrestashopMainPageFromAnyBrowser() {
        prestashopMainPage.openMainPage();
    }

    @When("user clicks random item on PrestaShop main Page")
    public void userClicksRandomItemOnPrestaShopMainPage() {
        commonPage.switchToIframe();
        prestashopMainPage.clickRandomItem();
        EXPECTED_ITEMS_IN_CART.add(prestashopMainPage.getAddedItemName());
        commonPage.switchToDefaultContent();
    }

    @Then("user sees {string} items in cart on PrestaShop main Page")
    public void userSeesItemsInCartOnPrestaShopMainPage(String numberInCart) {
        commonPage.switchToIframe();
        Assertions
                .assertThat(prestashopMainPage.getNumberOfItemsInCart())
                .as("Number of items in the cart is incorrect")
                .isEqualTo(numberInCart);
        commonPage.switchToDefaultContent();
    }

    @And("user clicks Cart icon on PrestaShop main Page")
    public void userClicksCartIconOnPrestaShopMainPage() {
        commonPage.switchToIframe();
        prestashopMainPage.clickCartIcon();
        commonPage.switchToDefaultContent();
    }
}
