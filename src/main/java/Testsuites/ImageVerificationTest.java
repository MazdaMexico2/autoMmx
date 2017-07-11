package Testsuites;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

/**
 * Created by Pablo on 14/6/2017.
 */
public class ImageVerificationTest {

    public void imageTest (String img, String expectedUrl, WebDriver driver, String imgreport){


        WebElement im = driver.findElement(By.cssSelector(img));
        try {
            im.getAttribute("src");
            im.equals(expectedUrl);
            Reporter.log("Pass: " + imgreport + " image verification. "+ "<br>");

        } catch (Exception e) {
            Reporter.log("Fail:" + imgreport + "<br>");
        }

    }

    public void imageTestBkg (String img, String expectedBkg,  WebDriver driver, String imgbrreport){


        WebElement imBk = driver.findElement(By.cssSelector(img));
        try {
            imBk.getCssValue("background-image");
            imBk.equals(expectedBkg);
            Reporter.log("Pass: " + imgbrreport + " image background verification. "+ "<br>");

        } catch (Exception e) {
            Reporter.log("Fail:" + imgbrreport + " image background verification. "+ "<br>");
        }

    }


    public void imagebytagname ( String array,  String imageurl,  WebDriver driver, String imgreport){



     WebElement arrayimg = driver.findElement(By.className(array));
        WebElement imagencotizar=arrayimg.findElement(By.tagName("img"));
        if (imagencotizar.getAttribute("src").equals(imageurl)){
            Reporter.log("Pass: " + imgreport + " image verification. "+ "<br>");
        }
        else{
            Reporter.log("Fail: " + imgreport + " image verification. "+ "<br>");


        }

    }

    public void imagebyposition ( String position,  String positionurl,  WebDriver driver, String imgreport){



        List<WebElement> toutList = driver.findElements(By.cssSelector(position));
        ;
        try{
        toutList.get(1).getAttribute("src").equals(positionurl);
            Reporter.log("Pass: " + imgreport + " image verification."+ "<br>");
        }
        catch (Exception e) {
            Reporter.log("Fail:" + imgreport + " image verification. "+ "<br>");
        }

    }
}