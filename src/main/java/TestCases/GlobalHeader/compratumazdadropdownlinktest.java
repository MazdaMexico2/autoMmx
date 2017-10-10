package TestCases.GlobalHeader;

import TestSuites.LinkVerificationTest;
import TestSuites.ReadProperties;
import TestSuites.selectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
        ReadProperties readp = new ReadProperties();
        this.propsmmx = readp.getConfigProperties("properties/Config.properties");
        link_test = new LinkVerificationTest();

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test */
        if (propsmmx.getProperty("url").contains("https://www.mazda.mx")){
            driver.get("https://www.mazda.mx");
        }if (propsmmx.getProperty("url").contains("https://mazdamx:mazda217@stage.mazda.mx/")){
            driver.get("https://mazdamx:mazda217@stage.mazda.mx/");
            Thread.sleep(3000);
            driver.get("https://stage.mazda.mx/");
            Thread.sleep(3000);
        }else {
            System.out.print("Please define the URL");
        }

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
