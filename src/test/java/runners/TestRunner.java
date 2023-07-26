package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:test-output/cucumber-reports/cucumber-reports.html"},
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags = "@amazon",
        dryRun = false
)

public class TestRunner {


}
