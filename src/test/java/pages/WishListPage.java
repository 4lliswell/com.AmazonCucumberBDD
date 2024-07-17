package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WishListPage {

    public WishListPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "profile-list-name")
    public WebElement wishListTitle;

    @FindBy(name = "submit.deleteItem")
    public WebElement deleteButon;

    @FindBy(xpath = "//div[.='Silindi']")
    public WebElement silindiText;

    @FindBy(xpath = "//span[.='Çıkış Yap']")
    public WebElement exitButton;

    @FindBy(xpath = "//h1")
    public WebElement girisYapText;

}
