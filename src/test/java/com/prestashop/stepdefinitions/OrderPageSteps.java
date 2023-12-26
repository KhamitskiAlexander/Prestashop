package com.prestashop.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import com.prestashop.pages.CommonPage;
import com.prestashop.pages.OrderPage;

public class OrderPageSteps {
    private final OrderPage orderPage;
    private final CommonPage commonPage;

    public OrderPageSteps(OrderPage orderPage, CommonPage commonPage) {
        this.orderPage = orderPage;
        this.commonPage = commonPage;
    }

    @Then("user sees {string} section title on Order Page")
    public void userSeesSectionTitleOnOrderPage(final String title) {
        commonPage.switchToIframe();
        Assertions
                .assertThat(orderPage.getPersonalInformationSectionTitle())
                .as(String.format("'%s' should be displayed as 'Personal information' section title", title))
                .containsIgnoringCase(title);
        commonPage.switchToDefaultContent();
    }

    @And("user fills in personal info on Order Page")
    public void userFillsInPersonalInfoOnOrderPage() {
        commonPage.switchToIframe();
        orderPage.fillPersonalInfo();
        commonPage.switchToDefaultContent();
    }

    @And("user fills in addresses info on Order Page")
    public void userFillsInAddressesInfoOnOrderPage() {
        commonPage.switchToIframe();
        orderPage.fillAddresses();
        commonPage.switchToDefaultContent();
    }

    @And("user clicks 'Continue' button after Addresses section filling on Order Page")
    public void userClicksContinueButtonAfterAddressesSectionFillingOnOrderPage() {
        commonPage.switchToIframe();
        orderPage.clickContinueButtonAfterAddressFilling();
        commonPage.switchToDefaultContent();
    }

    @And("user clicks 'Continue' for submit delivery options on Order Page")
    public void userClicksContinueForSubmitDeliveryOptionsOnOrderPage() {
        commonPage.switchToIframe();
        orderPage.clickConfirmDeliveryOpt();
        commonPage.switchToDefaultContent();
    }

    @And("user fills in payment info on Order Page")
    public void userFillsInPaymentInfoOnOrderPage() {
        commonPage.switchToIframe();
        orderPage.fillInPayment();
        commonPage.switchToDefaultContent();
    }

    @Then("user sees {string} as order confirmation message on Order Page")
    public void userSeesAsOrderConfirmationMessageOnOrderPage(String message) {
        commonPage.switchToIframe();
        Assertions
                .assertThat(orderPage.getOrderConfirmationMessage())
                .as("The message after order confirmation isn't correct")
                .containsIgnoringCase(message);
        commonPage.switchToDefaultContent();
    }
}
