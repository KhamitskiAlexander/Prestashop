package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ItemPage;
import utils.DriverActions;

public class ItemPageSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemPageSteps.class);
    private final ItemPage itemPage;

    public ItemPageSteps(final ItemPage itemPage) {
        this.itemPage = itemPage;
    }

    @Then("checks that {string} button is {string} on Item Page")
    public void checksThatButtonIsOnItemPage(String buttonName, String displayedFilter) {
        itemPage.switchToIFrame();
        boolean isButtonDisplayed = DriverActions.isButtonDisplayedWithName(buttonName);
        switch (displayedFilter) {
            case "displayed":
                Assertions
                        .assertThat(isButtonDisplayed)
                        .as(String.format("The button with name '%s' isn't displayed!", buttonName))
                        .isTrue();
                itemPage.switchToDefaultContent();
                break;
            case "not displayed":
                Assertions
                        .assertThat(isButtonDisplayed)
                        .as(String.format("The button with name '%s' should not be displayed!", buttonName))
                        .isFalse();
                itemPage.switchToDefaultContent();
                break;
            default:
                LOGGER.error("Invalid 'displayedFilter' value: {}", displayedFilter);
                throw new RuntimeException("Invalid 'displayedFilter' value: " + displayedFilter);
        }
    }

    @And("user clicks {string} button on Item Page")
    public void userClicksButtonOnItemPage(String buttonName) {
        itemPage.switchToIFrame();
        DriverActions.clickOnButtonWithName(buttonName);
        itemPage.switchToDefaultContent();
    }
}
