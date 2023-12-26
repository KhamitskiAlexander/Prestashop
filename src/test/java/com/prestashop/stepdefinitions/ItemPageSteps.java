package com.prestashop.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.prestashop.pages.CommonPage;
import com.prestashop.utils.DriverActions;

public class ItemPageSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemPageSteps.class);
    private final CommonPage commonPage;

    public ItemPageSteps(CommonPage commonPage) {
        this.commonPage = commonPage;
    }

    @Then("checks that {string} button is {string} on Item Page")
    public void checksThatButtonIsOnItemPage(String buttonName, String displayedFilter) {
        commonPage.switchToIframe();
        boolean isButtonDisplayed = DriverActions.isButtonDisplayedWithName(buttonName);
        switch (displayedFilter) {
            case "displayed":
                Assertions
                        .assertThat(isButtonDisplayed)
                        .as(String.format("The button with name '%s' isn't displayed!", buttonName))
                        .isTrue();
                commonPage.switchToDefaultContent();
                break;
            case "not displayed":
                Assertions
                        .assertThat(isButtonDisplayed)
                        .as(String.format("The button with name '%s' should not be displayed!", buttonName))
                        .isFalse();
                commonPage.switchToDefaultContent();
                break;
            default:
                LOGGER.error("Invalid 'displayedFilter' value: {}", displayedFilter);
                throw new RuntimeException("Invalid 'displayedFilter' value: " + displayedFilter);
        }
    }

    @And("user clicks {string} button on Item Page")
    public void userClicksButtonOnItemPage(String buttonName) {
        commonPage.switchToIframe();
        DriverActions.clickOnButtonWithName(buttonName);
        commonPage.switchToDefaultContent();
    }
}
