package stepdef.sharesteps;

import io.cucumber.java.en.When;
import utils.DriverActions;

public class SharedSteps {

    @When("user open previous page in browser")
    public void userOpenPreviousPageInBrowser() {
        DriverActions.switchToThePreviousPageInBrowser();
    }
}
