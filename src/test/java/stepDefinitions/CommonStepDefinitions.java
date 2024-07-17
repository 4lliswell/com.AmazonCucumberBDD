package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigReader;
import utilities.Driver;

public class CommonStepDefinitions {

    @Then("kullanici tarayiciyi kapatir")
    public void kullaniciTarayiciyiKapatir() {
        Driver.closeDriver();
    }

    @Given("kullanici URL'e gider {string}")
    public void kullaniciUrleGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

}
