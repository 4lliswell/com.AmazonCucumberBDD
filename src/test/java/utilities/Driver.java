package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    POM`de Driver icin TestBase clasina extends etmek yerine
    Driver classindan static methodlar kullanarak driver olusturup,
    ilgili ayarlarin yapilmasi ve en sonda driver`in kapatilmasi tercih edilmistir.

    POM`de Driver class`indaki getDriver()`nin obje olusturularak kullanilmasini engellemek icin
    Sinleton pattern kullanimi benimsenmistir.

    Singleton Patern : tekli kullanim, bir classin farkli classlardan obje olusturularak
                       kullanimini engellemek icin kullanilir.

    Bunu saglamak icin yapmamiz gereken sey oldukca basit obje olusturmak icin kullanilan
    constructor`i private yaptiginizda baska classlarda Driver classindan obje olusturulmasi mumkun OLMAZ.
     */

    private Driver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headles-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        /*
        driver`a daha onceden deger atanmissa yeniden driver objesi olusturma olusturulmus
        onceki driver uzerinden devam et, eger driver`a daha onceden bir deger atanmamissa (yeni degeri null ise)
        ozaman driver objesi olustur dedik if kosulu ile

        onceden driver objesi olusmus ise driver`imiz static oldugu icin onceki atanmis degeri
        aklind atutacaktir.
         */

        return driver;
    }

    public static void closeDriver() {

        if (driver != null) { // driverimiz null degilse if calissin yani bir deger atanmissa
            driver.close(); // deger atanmissa driveri kapat
            driver = null;  // ne olur ne olmaz diye driver`a null degeri atadik sonrasinda
                            // tekrar calistirinca yeni obje olusturabilsin gibi
        }
    }
}
