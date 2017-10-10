package TestSuites;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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