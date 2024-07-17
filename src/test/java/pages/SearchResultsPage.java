package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class SearchResultsPage {

    public SearchResultsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucuYazisi;

    @FindBy(id = "add-to-wishlist-button-submit")
    public WebElement listeyeEkle;

    @FindBy(xpath = "//span[@class='huc-atwl-header-small']")
    public WebElement wishListProductTitle;

    @FindBy(xpath = "//button[@data-action='a-popover-close']")
    public WebElement wishListCloseButton;

    @FindBy(xpath = "//span[.='Alışveriş Listesi']")
    public WebElement productList;
}
