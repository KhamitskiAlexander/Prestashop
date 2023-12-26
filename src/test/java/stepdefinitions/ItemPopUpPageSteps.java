package stepdefinitions;

import io.cucumber.java.en.And;
import org.assertj.core.api.Assertions;
import pages.CommonPage;
import pages.ItemPopUpPage;

public class ItemPopUpPageSteps {
    private final ItemPopUpPage itemPopUpPage;
    private final CommonPage commonPage;

    public ItemPopUpPageSteps(ItemPopUpPage itemPopUpPage, CommonPage commonPage) {
        this.itemPopUpPage = itemPopUpPage;
        this.commonPage = commonPage;
    }

    @And("user sees message {string} on Item pop up Page")
    public void userSeesMessage(String notificationMessage) {
        commonPage.switchToIframe();
        Assertions.assertThat(itemPopUpPage.getMessageAfterAdding())
                .as("The message after adding an item to the cart is incorrect")
                .contains(notificationMessage);
        commonPage.switchToDefaultContent();
    }

    @And("user clicks 'PROCEED TO CHECKOUT' button on Item pop up Page")
    public void userClicksProceedToCheckoutButtonOnItemPopUpPage() {
        commonPage.switchToIframe();
        itemPopUpPage.clickProceedToCheckoutButton();
        commonPage.switchToDefaultContent();
    }
}
