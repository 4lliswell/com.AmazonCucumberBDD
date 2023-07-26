package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class amazonStepDefinitions {

    AmazonPage amazonPage = new AmazonPage();
    Select select;

    @Given("chrome browser kullanilarak {string} ana sayfasina gidilir")
    public void chromeBrowserKullanilarakAnaSayfasinaGidilir(String url) {

        Driver.getDriver().get(ConfigReader.getProperty(url));

    }

    @And("ana sayfanin acildigi kontrol edilir")
    public void anaSayfaninAcildigiKontrolEdilir() {

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("amazonUrl");

        Assert.assertEquals(expectedUrl, actualUrl);

    }

    @When("cerez tercihlerinden cerezleri kabul et secilir")
    public void cerezTercihlerindenCerezleriKabulEtSecilir() {

        amazonPage.txtCookies.click();

    }

    @When("siteye login olunur")
    public void siteyeLoginOlunur() {

        ReusableMethods.moveToElementHover(amazonPage.txtGirisYapinPencere);
        ReusableMethods.waitForVisibility(amazonPage.txtGirisYap);
        amazonPage.txtemailBox.sendKeys(ConfigReader.getProperty("amazonEmail") + Keys.ENTER);
        amazonPage.txtPasswordBox.sendKeys(ConfigReader.getProperty("amazonPassword") + Keys.ENTER);
    }

    @And("login islemi kontrol edilir")
    public void loginIslemiKontrolEdilir() {

        String loginResult = amazonPage.loginTextYazisi.getText();
        Assert.assertFalse(loginResult.contains("Merhaba"));
    }

    @When("arama butonu yanindaki kategoriler tabindan bilgisayar secilir")
    public void aramaButonuYanindakiKategorilerTabindanBilgisayarSecilir() {

        select = new Select(amazonPage.searchDropdownBox);
        select.selectByVisibleText("Bilgisayarlar");

    }

    @And("bilgisayar kategorisi secildigi kontrol edilir")
    public void bilgisayarKategorisiSecildigiKontrolEdilir() {
        select = new Select(amazonPage.searchDropdownBox);
        String actualSelect = select.getFirstSelectedOption().getText();
        String expectedSelect = "Bilgisayarlar";

        Assert.assertEquals(expectedSelect, actualSelect);
    }

    @When("arama alanina MSI yazilir ve arama yapilir")
    public void aramaAlaninaMSIYazilirVeAramaYapilir() {

        amazonPage.txtSearchbox.sendKeys("MSI" + Keys.ENTER);
    }

    @And("arama yapildigi kontrol edilir")
    public void aramaYapildigiKontrolEdilir() {

        String aramaSonucYazisi = amazonPage.aramaSonucYazisi.getText();
        Assert.assertTrue(aramaSonucYazisi.contains("MSI"));
    }

    @When("arama sonuclari sayfasindan ikinci sayfa acilir")
    public void aramaSonuclariSayfasindanIkinciSayfaAcilir() {

        ReusableMethods.javaScriptExcecuter(amazonPage.ikinciSayfa);
    }

    @And("ikinci sayfanin acildigi kontrol edilir")
    public void ikinciSayfaninAcildigiKontrolEdilir() {

        String ikinciSayfaUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(ikinciSayfaUrl.contains("page=2"));
    }

    @When("sayfadaki ikinci urun favorilere eklenir")
    public void sayfadakiIkinciUrunFavorilereEklenir() {

        amazonPage.secondProduct.click();
        amazonPage.favoriEkle.click();
    }

    @And("ikinci urunun favorilere eklendigi kontrol edilir")
    public void ikinciUrununFavorilereEklendigiKontrolEdilir() {

        Assert.assertTrue(amazonPage.wishList.getText().contains("ürün şuraya eklendi:"));
    }

    @When("hesabim seceneginden favori listem sayfasina gidilir")
    public void hesabimSecenegindenFavoriListemSayfasinaGidilir() {

        amazonPage.listDisplayed.click();
    }

    @And("favori listem sayfasinin acildigi kontrol edilir")
    public void favoriListemSayfasininAcildigiKontrolEdilir() {

        String favoriListemUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(favoriListemUrl.contains("wishlist"));
    }

    @When("eklenen urun favorilerden silinir")
    public void eklenenUrunFavorilerdenSilinir() {

        amazonPage.deleteButon.click();
    }

    @And("silme isleminin gercekleştigi kontrol edilir")
    public void silmeIslemininGercekleştigiKontrolEdilir() {

        Assert.assertTrue(amazonPage.silindi.isDisplayed());
    }

    @When("uye cikis islemi yapilir")
    public void uyeCikisIslemiYapilir() {

        ReusableMethods.moveToElementHover(amazonPage.txtGirisYapinPencere);
        ReusableMethods.waitForVisibility(amazonPage.exitbutton);
    }

    @And("cikis isleminin yapildigi kontrol edilir")
    public void cikisIslemininYapildigiKontrolEdilir() {

        Assert.assertTrue(amazonPage.girisButon.isDisplayed());
    }

    @Then("chrome browser kapatilir")
    public void chromeBrowserKapatilir() {

        Driver.closeDriver();
    }
}
