package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources"},
        tags = "@ui",
        glue = {"stepdefinitions","hooks"},
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"}
)
public class PrestashopTest extends AbstractTestNGCucumberTests {
}
