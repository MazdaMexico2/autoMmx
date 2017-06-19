package Testsuites;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

/**
 * Created by Pablo on 14/6/2017.
 */
public class ImageVerificationTest {

    public void imageTest (String img, String expectedUrl, WebDriver driver){


        WebElement im = driver.findElement(By.cssSelector(img));
        try {
            im.getAttribute("src");
            im.equals(expectedUrl);
            Reporter.log("Pass: " + expectedUrl + "<br>");

        } catch (Exception e) {
            Reporter.log("Fail:" + expectedUrl + "<br>");
        }

    }

    public void imageTestBkg (String img, String expectedBkg,  WebDriver driver){


        WebElement imBk = driver.findElement(By.cssSelector(img));
        try {
            imBk.getCssValue("background-image");
            imBk.equals(expectedBkg);
            Reporter.log("Pass: " + expectedBkg + "<br>");

        } catch (Exception e) {
            Reporter.log("Fail:" + expectedBkg + "<br>");
        }

    }

}


