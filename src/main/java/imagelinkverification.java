/**
 * Created by Pablo on 18/5/2017.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;



public class imagelinkverification {

    private LinkVerificationTest link_test;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void setUp() throws IOException {
       // System.setProperty("webdriver.chrome.driver", "chromedriver");

        // PC path
        // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
      System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        //driver = new SafariDriver();
        configFile = new Properties();
    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {
        link_test = new LinkVerificationTest();

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test */
        driver.get("https://www.mazda.mx");

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        //jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(5000);

        //link1
     link_test.clicklink(".mazda-logo",2000, driver);
     link_test.linkcompare("https://www.mazda.mx/", driver);
     link_test.returnpage("https://www.mazda.mx/", driver);
    // link 2

    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    }
