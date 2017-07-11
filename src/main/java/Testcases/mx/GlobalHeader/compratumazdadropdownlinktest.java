package Testcases.mx.GlobalHeader;

import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import Testsuites.selectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
/**
 * Created by Pablo on 1/6/2017.
 */
public class compratumazdadropdownlinktest {
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


        /* Define URL to test */
        driver.get(propsmmx.getProperty("prod_home_url"));

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        //jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(1000);

        //Compara

        link_test.clicklink(propsmmx.getProperty("compratumazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Compara_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Compara_prod_url"), driver, "Global Header: Compra tu Mazda Dropdown- Compara");


        // Configura

        link_test.clicklink(propsmmx.getProperty("compratumazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Configura_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Configura_prod_url"), driver,"Global Header: Compra tu Mazda Dropdown- Configura");


        // Cotizador

        link_test.clicklink(propsmmx.getProperty("compratumazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Cotizador_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Cotizador_prod_url"), driver,"Global Header: Compra tu Mazda Dropdown- Cotizador");


        // Distribuidores

        link_test.clicklink(propsmmx.getProperty("compratumazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Distribuidores_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Distribuidores_prod_url"), driver,"Global Header: Compra tu Mazda Dropdown- Distribuidores");


        // Configura

        link_test.clicklink(propsmmx.getProperty("compratumazda_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Configura_button_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Configura_button_prod"), driver,"Global Header: Compra tu Mazda Dropdown- Configura Button");


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
