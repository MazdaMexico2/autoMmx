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



    public void phoneclicklink (String classname , int wait, WebDriver driver){
        WebElement element = driver.findElement(By.className(classname));
        element.click();
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void phonealert (WebDriver driver){
        try {
           WebDriverWait wait = new WebDriverWait(driver, 20);
           wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.dismiss();

        } catch (Exception e) {
            //exception handling
            e.printStackTrace(System.out);
        }


    }



    public boolean phonelinkcompare (String reference, WebDriver driver, String linkreporter ) {

        if (driver.getCurrentUrl().equals(reference) ){
            Reporter.log("Pass: " + linkreporter +" <br/>");
            return true;
        }
        else {
            Reporter.log("Fail: " + linkreporter +" <br/>");
            return false;
        }

    }

    public void phonereturnpage (String linkreturn, WebDriver driver){

        driver.get(linkreturn);

    }


}