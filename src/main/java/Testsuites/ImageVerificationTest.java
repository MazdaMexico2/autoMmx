package Testsuites;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

/**
 * Created by Pablo on 14/6/2017.
 */
public class ImageVerificationTest {

    public  void imageTest (String img, String expectedUrl, int wait, WebDriver driver){


        WebElement im = driver.findElement(By.cssSelector(img));
        try {
            im.getAttribute("src");
            Thread.sleep(wait);
            im.equals(expectedUrl);
            Reporter.log("Pass: " + expectedUrl + "<br>");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
