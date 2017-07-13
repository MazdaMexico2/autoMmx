package Testsuites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
/**
 * Created by Pablo on 13/7/2017.
 */
public class PhoneLinkVerification {

    public boolean phonelinkcompare (String img, String reference, WebDriver driver, String linkreporter ) {

        WebElement im = driver.findElement(By.cssSelector(img));

        if (driver.getCurrentUrl().equals(reference) ){
            Reporter.log("Pass: " + linkreporter +" <br/>");
            return true;
        }
        else {
            Reporter.log("Fail: " + linkreporter +" <br/>");
            return false;
        }
}


}