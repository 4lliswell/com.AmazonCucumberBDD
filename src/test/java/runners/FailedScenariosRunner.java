package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/reports/html-reports/default-cucumber-reports.html",
                "json:target/reports/json-reports/cucumber1.json",
                "junit:target/reports/xml-reports/cucumber1.xml",
                "rerun:target/failedScenarios.txt",
                "pretty"
        },
        features = "@target/failedScenarios.txt",
        glue = "stepdefinitions"
)

public class FailedScenariosRunner {
}
