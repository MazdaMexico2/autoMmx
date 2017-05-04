/**
 * Created by alina.viquez on 5/1/17.
 */

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//pablo
public class testBrowser {


    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();

        //Test Alina #2
        //Test Vince

    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test*/
        driver.get("https://www.mazda.mx/");

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}