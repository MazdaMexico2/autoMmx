package Testcases.mx.GlobalHeader;

import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class vehiculosdrpodowlinktest {

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

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
           // System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");

          //  System.setProperty("webdriver.chrome.driver", "chromedriver");

       driver = new ChromeDriver();
      //  driver = new FirefoxDriver();
        //driver = new SafariDriver();
        configFile = new Properties();
    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {
        link_test = new LinkVerificationTest();

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test */
        driver.get(propsmmx.getProperty("prod_home_url"));

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        //jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(5000);

        //Mazda 2

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mazda2_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mazda2_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // Mazda 3 sedan

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mazda3S_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mazda3S_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // Mazda 3 hatchback

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mazda3H_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mazda3H_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // Mazda 6

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mazda6_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mazda6_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // Mazda CX3

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("MazdaCX3_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("MazdaCX3_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // Mazda CX5

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("MazdaCX5_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("MazdaCX5_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // Mazda CX9

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("MazdaCX9_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("MazdaCX9_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // Mazda MX5

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("MazdaMX5_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("MazdaMX5_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        // Mazda MX5 RF

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("MazdaMX5RF_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("MazdaMX5RF_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }







}
