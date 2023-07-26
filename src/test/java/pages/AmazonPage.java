package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='sp-cc-accept']")
    public WebElement txtCookies;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    public WebElement txtGirisYapinPencere;

    @FindBy(xpath = "//a[@class='nav-action-signin-button']")
    public WebElement txtGirisYap;

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement txtemailBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement txtPasswordBox;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement loginTextYazisi;

    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement searchDropdownBox;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement txtSearchbox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucYazisi;

    @FindBy(xpath = "//a[@aria-label='2 sayfasına git']")
    public WebElement ikinciSayfa;

    @FindBy(xpath = "(//img[@class='s-image'])[2]")
    public WebElement secondProduct;

    @FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']")
    public WebElement favoriEkle;

    @FindBy(xpath = "//span[text()='1 ürün şuraya eklendi:']")
    public WebElement wishList;

    @FindBy(linkText = "Listenizi Görüntüleyin")
    public WebElement listDisplayed;

    @FindBy(name = "submit.deleteItem")
    public WebElement deleteButon;

    @FindBy(xpath = "//div[text()='Silindi']")
    public WebElement silindi;

    @FindBy(xpath = "//span[text()='Çıkış Yap']")
    public WebElement exitbutton;

    @FindBy(xpath= "//h1[@class='a-spacing-small']")
    public WebElement girisButon;
}
