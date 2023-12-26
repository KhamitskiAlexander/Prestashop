package stepdefinitions;

import io.cucumber.java.en.And;
import org.assertj.core.api.Assertions;
import pages.ItemPopUpPage;

public class ItemPopUpPageSteps {
    private final ItemPopUpPage itemPopUpPage;

    public ItemPopUpPageSteps(ItemPopUpPage itemPopUpPage) {
        this.itemPopUpPage = itemPopUpPage;
    }

    @And("user sees message {string} on Item pop up Page")
    public void userSeesMessage(String notificationMessage) {
        itemPopUpPage.switchToIFrame();
        Assertions.assertThat(itemPopUpPage.getMessageAfterAdding())
                .as("The message after adding an item to the cart is incorrect")
                .contains(notificationMessage);
        itemPopUpPage.switchToDefaultContent();
    }

    @And("user clicks 'PROCEED TO CHECKOUT' button on Item pop up Page")
    public void userClicksProceedToCheckoutButtonOnItemPopUpPage() {
        itemPopUpPage.switchToIFrame();
        itemPopUpPage.clickProceedToCheckoutButton();
        itemPopUpPage.switchToDefaultContent();
    }
}
