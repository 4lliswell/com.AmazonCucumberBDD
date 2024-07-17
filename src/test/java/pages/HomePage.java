package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "sp-cc-accept")
    public WebElement cookiesAccept;

    @FindBy(id = "nav-link-accountList")
    public WebElement girisYapinMenusu;

    @FindBy(xpath = "//a[@class='nav-action-signin-button']")
    public WebElement girisYapButton;

    @FindBy(id = "ap_email")
    public WebElement emailBox;

    @FindBy(id = "ap_password")
    public WebElement passwordBox;

    @FindBy(id = "searchDropdownBox")
    public WebElement dropDownSelect;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

}
