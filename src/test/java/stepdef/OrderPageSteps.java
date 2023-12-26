package stepdef;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.OrderPage;

public class OrderPageSteps {
    private final OrderPage orderPage;

    public OrderPageSteps(final OrderPage orderPage) {
        this.orderPage = orderPage;
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
}
