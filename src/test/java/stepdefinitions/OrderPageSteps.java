package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.CommonPage;
import pages.OrderPage;

public class OrderPageSteps {
    private final OrderPage orderPage;
    private final CommonPage commonPage;

    public OrderPageSteps(OrderPage orderPage, CommonPage commonPage) {
        this.orderPage = orderPage;
        this.commonPage = commonPage;
    }

    @Then("user sees {string} section title on Order Page")
    public void userSeesSectionTitleOnOrderPage(final String title) {
        orderPage.switchToIFrame();
        Assertions
                .assertThat(orderPage.getPersonalInformationSectionTitle())
                .as(String.format("'%s' should be displayed as 'Personal information' section title", title))
                .containsIgnoringCase(title);
        orderPage.switchToDefaultContent();
    }

    @And("user fills in personal info")
    public void userFillsInPersonalInfo() {
        commonPage.goIntoIFrame();
        orderPage.fillPersonalInfo();
        commonPage.goOutIFrame();
    }

    @And("user fills in addresses info")
    public void userFillsInAddressesInfo() {
        commonPage.goIntoIFrame();
        orderPage.fillAddresses();
        commonPage.goOutIFrame();
    }

    @And("user clicks Continue for submit delivery options")
    public void userClicksContinueForSubmitDeliveryOptions() {
        commonPage.goIntoIFrame();
        orderPage.clickConfirmDeliveryOpt();
        commonPage.goOutIFrame();
    }

    @And("user fills in payment info")
    public void userFillsInPaymentInfo() {
        commonPage.goIntoIFrame();
        orderPage.fillInPayment();
        commonPage.goOutIFrame();
    }

    @Then("user gets message {string}")
    public void userGetsMessage(String message) {
        commonPage.goIntoIFrame();
        Assertions
                .assertThat(orderPage.getOrderConfirmationMessage())
                .as("The message after order confirmation isn't correct")
                .isEqualTo(message);
        commonPage.goOutIFrame();
    }
}
