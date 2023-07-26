package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

    public static void moveToElementHover(WebElement login) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(login).perform();

    }

    public static void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public static void javaScriptExcecuter(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", element);
    }

    public static String getScreenshot(WebDriver driver, String name) throws IOException {

        String date = formatCurrentDate(" yyyy.MM.dd_HH.mm.ss");

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String target = System.getProperty("user.dir") + "\\test-output\\screenshot\\" + name + date + ".png";

        File targetFile = new File(target);
        FileUtils.copyFile(source, targetFile);

        return target;
    }

    public static String formatCurrentDate(String pattern) {

        return new SimpleDateFormat(pattern).format(new Date());
    }


}
