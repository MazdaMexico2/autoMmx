package Testcases.mx.Contactanos;

import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import Testsuites.selectBrowser;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import sun.tools.jconsole.Tab;

import static org.openqa.selenium.Keys.*;

/**
 * Created by alina.viquez on 7/9/17.
 */
public class ContactanosForm {

    private Properties propsmmx;
    private LinkVerificationTest link_test;
    private selectBrowser defineBrowser;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();
        this.propsmmx = readprops.getConfigProperties("properties/Contactanos.properties");

    }

    @BeforeMethod
    public void setup() throws Exception {

        defineBrowser = new selectBrowser();
        driver = defineBrowser.setupBrowser(propsmmx.getProperty("browser"),propsmmx.getProperty("device"));

    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {
        link_test = new LinkVerificationTest();
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test in STG environment, we need to call the path twice because first time you send the
        parameter and the second time the page load the style Note: The url with parameter should not be call form
        properties file*/
        driver.get("https://mazdamx:mazda217@stage.mazda.mx/");
        Thread.sleep(3000);
        driver.get("https://stage.mazda.mx/");
        Thread.sleep(3000);



        /*Maximize Window and load*/
        driver.manage().window().maximize();
        jse.executeScript("window.scrollBy(0,3500)");
        Thread.sleep(3000);

        driver.findElement(By.className(propsmmx.getProperty("contactanosLink"))).click();
        Thread.sleep(2000);
        driver.findElement(By.id("nombre")).sendKeys("Automated");
        Thread.sleep(2000);
        driver.findElement(By.id("apellido")).sendKeys("Test");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.id("email")).sendKeys("testqammx001@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("subject")).sendKeys("Test Subject");
        Thread.sleep(2000);
        driver.findElement(By.id("user-help-message")).sendKeys("This is a test message");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.className("checkbox")).click();
        Thread.sleep(3000);
        driver.findElement(By.className(propsmmx.getProperty("submitContactanosForm"))).click();
        Reporter.log("Pass: Submit Page Form "+ "<br>");
        Thread.sleep(5000);

        driver.findElement(By.className("mdp-forms__summary--message-secondary")).click();
        Reporter.log("Pass: Thank you Page "+ "<br>");
        Thread.sleep(3000);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}