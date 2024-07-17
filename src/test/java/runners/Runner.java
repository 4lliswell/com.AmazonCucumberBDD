package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/reports/html-reports/default-cucumber-reports.html",
                "json:target/reports/json-reports/json-reports.json",
                "junit:target/reports/xml-reports/xml-reports.xml",
                "rerun:target/failedScenarios.txt",
                "pretty"
        },
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags = "@amazon",
        dryRun = false
)

public class Runner {


}
