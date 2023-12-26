package com.prestashop;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources"},
        tags = "@ui",
        glue = {"com/prestashop/stepdefinitions", "hooks"},
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
