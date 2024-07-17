package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Scenario Name: " + scenario.getName());
        System.out.println("Scenario ID: " + scenario.getId());
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            System.out.println("Senaryo başarısız oldu");
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Başarısız Senaryo Ekran Görüntüsü");

            Driver.closeDriver();
        }


    }
}
