package Testcases.mx.GlobalHeader;

import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by alina.viquez on 6/1/17.
 */
public class mazdaDropdown {

    private Properties propsmmx;
    private LinkVerificationTest link_test;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();

        this.propsmmx = readprops.getConfigProperties("properties/GlobalHeader.properties");

    }


    @BeforeMethod
    public void setUp() throws IOException {

        if (propsmmx.getProperty("device").equalsIgnoreCase("PC")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }

        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();

        //Test Alina #2

    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {
        link_test = new LinkVerificationTest();

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        // Define URL to test
        driver.get(propsmmx.getProperty("prod_home_url"));

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        //jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(5000);


        // Nuestra Historia

        link_test.clicklink(propsmmx.getProperty("Mazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Nuestrahistoria_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Nuestrahistoria_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // Mazda Financial

        link_test.clicklink(propsmmx.getProperty("Mazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mazdafinancial_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mazdafinancial_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // SKYACTIVE

        link_test.clicklink(propsmmx.getProperty("Mazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Skyactive_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Skyactive_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // SKYACTIVE button

        link_test.clicklink(propsmmx.getProperty("Mazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Skyactive_button_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Skyactive_button_prod"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

    }
    @AfterMethod
    public void tearDown() {

        driver.quit();



    }
}