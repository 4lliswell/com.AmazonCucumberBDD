package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.WishListPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AmazonStepDefinitions {

    HomePage hp = new HomePage();
    SearchResultsPage sp = new SearchResultsPage();
    WishListPage wp = new WishListPage();

    Select select;
    String expectedProductTitle;

    @And("ana sayfanin acildigi kontrol edilir {string}")
    public void anaSayfaninAcildigiKontrolEdilir(String url) {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty(url);
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @When("cerez tercihlerinden cerezleri kabul et secilir")
    public void cerezTercihlerindenCerezleriKabulEtSecilir() {
        hp.cookiesAccept.click();
    }

    @When("siteye login olunur {string} {string}")
    public void siteyeLoginOlunur(String email, String password) {
        ReusableMethods.moveToElementHover(hp.girisYapinMenusu);
        ReusableMethods.waitForVisibility(hp.girisYapButton);
        sendText(hp.emailBox, email);
        sendText(hp.passwordBox, password);
    }

    public void sendText(WebElement element, String text) {
        element.sendKeys(ConfigReader.getProperty(text) + Keys.ENTER);
    }

    @And("login islemi kontrol edilir")
    public void loginIslemiKontrolEdilir() {
        String actualLoginResult = hp.girisYapinMenusu.getText();
        Assert.assertFalse(actualLoginResult.contains("Merhaba"));
    }

    @When("arama butonu yanindaki kategoriler tabindan {string} secilir")
    public void aramaButonuYanindakiKategorilerTabindanSecilir(String kategori) {
        select = new Select(hp.dropDownSelect);
        select.selectByVisibleText(kategori);
    }

    @And("{string} kategorisi secildigi kontrol edilir")
    public void kategorisiSecildigiKontrolEdilir(String expectedCategori) {
        String actualSelect = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelect, expectedCategori);
    }

    @When("arama alanina {string} yazilir ve arama yapilir")
    public void aramaAlaninaMSIYazilirVeAramaYapilir(String product) {
        hp.searchBox.sendKeys(product + Keys.ENTER);
    }

    @And("arama yapildigi kontrol edilir {string}")
    public void aramaYapildigiKontrolEdilir(String product) {
        String aramaSonucYazisi = sp.aramaSonucuYazisi.getText();
        Assert.assertTrue(aramaSonucYazisi.contains(product));
    }

    @When("arama sonuclari sayfasindan {string} sayfa acilir")
    public void aramaSonuclariSayfasindanSayfaAcilir(String pageNumber) {
        WebElement page = Driver.getDriver().findElement(By.xpath("//a[@aria-label='" + pageNumber + " sayfasına git']"));
        ReusableMethods.clickElementByJS(page);
    }

    @And("{string} sayfanin acildigi kontrol edilir")
    public void sayfaninAcildigiKontrolEdilir(String pageNumber) {
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("page=" + pageNumber));
    }

    @When("sayfadaki {string} urun favorilere eklenir")
    public void sayfadakiUrunFavorilereEklenir(String urunSirasi) {
        WebElement product = Driver.getDriver().findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + urunSirasi + "]"));
        expectedProductTitle = product.getText();
        product.click();
        ReusableMethods.waitForVisibility(sp.listeyeEkle);
    }

    @And("urunun favorilere eklendigi kontrol edilir")
    public void urununFavorilereEklendigiKontrolEdilir() {
        String actualProductTitle = sp.wishListProductTitle.getText();
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
        sp.wishListCloseButton.click();    }

    @When("hesabim seceneginden favori listem sayfasina gidilir")
    public void hesabimSecenegindenFavoriListemSayfasinaGidilir() {
        ReusableMethods.moveToElementHover(hp.girisYapinMenusu);
        ReusableMethods.waitForVisibility(sp.productList);
    }

    @And("favori listem sayfasinin acildigi kontrol edilir")
    public void favoriListemSayfasininAcildigiKontrolEdilir() {
        Assert.assertTrue(wp.wishListTitle.isDisplayed());
    }

    @When("eklenen urun favorilerden silinir")
    public void eklenenUrunFavorilerdenSilinir() {
        wp.deleteButon.click();
    }

    @And("silme isleminin gercekleştigi kontrol edilir")
    public void silmeIslemininGercekleştigiKontrolEdilir() {
        Assert.assertTrue(wp.silindiText.isDisplayed());
    }

    @When("uye cikis islemi yapilir")
    public void uyeCikisIslemiYapilir() {
        ReusableMethods.moveToElementHover(hp.girisYapinMenusu);
        ReusableMethods.waitForVisibility(wp.exitButton);
    }

    @And("cikis isleminin yapildigi kontrol edilir")
    public void cikisIslemininYapildigiKontrolEdilir() {
        Assert.assertTrue(wp.girisYapText.isDisplayed());
    }
}
