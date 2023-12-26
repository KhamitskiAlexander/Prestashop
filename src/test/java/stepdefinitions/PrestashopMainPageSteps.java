package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.PrestashopMainPage;

import static stepdefinitions.CartSteps.EXPECTED_ITEMS_IN_CART;

public class PrestashopMainPageSteps {
    private final PrestashopMainPage prestashopMainPage;

    public PrestashopMainPageSteps(final PrestashopMainPage prestashopMainPage) {
        this.prestashopMainPage = prestashopMainPage;
    }

    @Given("user open PrestaShop main page from any browser")
    public void userOpenPrestashopMainPageFromAnyBrowser() {
        prestashopMainPage.openMainPage();
    }

    @When("user clicks random item on PrestaShop main Page")
    public void userClicksRandomItemOnPrestaShopMainPage() {
        prestashopMainPage.switchToIFrame();
        prestashopMainPage.clickRandomItem();
        EXPECTED_ITEMS_IN_CART.add(prestashopMainPage.getAddedItemName());
        prestashopMainPage.switchToDefaultContent();
    }

    @Then("user sees {string} items in cart on PrestaShop main Page")
    public void userSeesItemsInCartOnPrestaShopMainPage(String numberInCart) {
        prestashopMainPage.switchToIFrame();
        Assertions
                .assertThat(prestashopMainPage.getNumberOfItemsInCart())
                .as("Number of items in the cart is incorrect")
                .isEqualTo(numberInCart);
        prestashopMainPage.switchToDefaultContent();
    }

    @And("user clicks Cart icon on PrestaShop main Page")
    public void userClicksCartIconOnPrestaShopMainPage() {
        prestashopMainPage.switchToIFrame();
        prestashopMainPage.clickCartIcon();
        prestashopMainPage.switchToDefaultContent();
    }
}
