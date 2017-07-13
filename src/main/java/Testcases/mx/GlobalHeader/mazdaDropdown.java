package Testcases.mx.GlobalHeader;

import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import Testsuites.selectBrowser;
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
    private selectBrowser defineBrowser;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();

        this.propsmmx = readprops.getConfigProperties("properties/GlobalHeader.properties");

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


        // Define URL to test
        driver.get(propsmmx.getProperty("prod_home_url"));

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        //jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(5000);


        // Nuestra Historia

        link_test.clicklink(propsmmx.getProperty("Mazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Nuestrahistoria_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Nuestrahistoria_prod_url"), driver,"Global Header: Mazda Dropdown- Nuestra Historia");


        // Mazda Financial

        link_test.clicklink(propsmmx.getProperty("Mazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mazdafinancial_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mazdafinancial_prod_url"), driver,"Global Header: Mazda Dropdown- Mazda Financial");


        // SKYACTIVE

        link_test.clicklink(propsmmx.getProperty("Mazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Skyactive_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Skyactive_prod_url"), driver,"Global Header: Mazda Dropdown- SKYACTIVE");


        // SKYACTIVE button

        link_test.clicklink(propsmmx.getProperty("Mazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Skyactive_button_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Skyactive_button_prod"), driver,"Global Header: Mazda Dropdown- SKYACTIVE Button");


    }
    @AfterMethod
    public void tearDown() {

        driver.quit();

    }
}