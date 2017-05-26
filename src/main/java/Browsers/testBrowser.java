package Browsers; /**
 * Created by alina.viquez on 5/1/17.
 */

import java.io.IOException;
import java.util.Properties;

import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//pablo
public class testBrowser {
    private LinkVerificationTest link_test;

    WebDriver driver;
    Properties configFile;

    private Properties propsmmx;


    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();

        this.propsmmx = readprops.getConfigProperties("properties/GlobalHeader.properties");

    }


    @BeforeMethod
    public void setUp() throws IOException {

        if( propsmmx.getProperty("device") == "PC"){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }

       // driver = new ChromeDriver();
      driver = new FirefoxDriver();
        //driver = new SafariDriver();

        //Test Alina #2

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
       // driver.close();
    }
}