package Testsuites;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
/**
 * Created by Pablo on 13/7/2017.
 */
public class PhoneLinkVerification {








    public void phonesrccompare (String phonenumber,  WebDriver driver){

        WebElement phoneposition = driver.findElement(By.cssSelector(phonenumber));
        try {
            phoneposition.getCssValue("data-analytics-link-type");
            phoneposition.equals("call");
            Reporter.log("Pass: " + phonenumber + " phone link. "+ "<br>");

        } catch (Exception e) {
            Reporter.log("Fail:" + phonenumber + "  phone link. "+ "<br>");
        }

    }



}