package Testsuites;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by Pablo on 17/5/2017.
 */

public class LinkVerificationTest {

    private String type;
    private WebElement element;
    private String link;



    public void clicklink (String cssselector, int wait, WebDriver driver){
        WebElement element = driver.findElement(By.cssSelector(cssselector));
        element.click();
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public boolean linkcompare (String reference, WebDriver driver ) {

        return driver.getCurrentUrl().equals(reference);

}

    public void returnpage (String linkreturn, WebDriver driver){

        driver.get(linkreturn);


    }



}

