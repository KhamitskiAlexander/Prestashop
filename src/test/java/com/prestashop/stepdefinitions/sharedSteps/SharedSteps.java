package com.prestashop.stepdefinitions.sharedSteps;

import io.cucumber.java.en.When;
import com.prestashop.utils.DriverActions;

public class SharedSteps {

    @When("user open previous page in browser")
    public void userOpenPreviousPageInBrowser() {
        DriverActions.switchToThePreviousPageInBrowser();
    }
}
