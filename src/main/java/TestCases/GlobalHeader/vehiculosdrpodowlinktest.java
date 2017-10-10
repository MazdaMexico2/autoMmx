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

public class vehiculosdrpodowlinktest {

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
        Thread.sleep(5000);

        //Mazda 2

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mazda2_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mazda2_prod_url"), driver,"Global Header: Vehiculos Dropdown- Mazda2");


        // Mazda 3 sedan

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mazda3S_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mazda3S_prod_url"), driver,"Global Header: Vehiculos Dropdown- Mazda3 Sedan");


        // Mazda 3 hatchback

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mazda3H_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mazda3H_prod_url"), driver,"Global Header: Vehiculos Dropdown- Mazda3 Hatchback");


        // Mazda 6

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mazda6_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mazda6_prod_url"), driver,"Global Header: Vehiculos Dropdown- Mazda6");


        // Mazda CX3

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("MazdaCX3_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("MazdaCX3_prod_url"), driver,"Global Header: Vehiculos Dropdown- Mazda CX3");


        // Mazda CX5

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("MazdaCX5_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("MazdaCX5_prod_url"), driver,"Global Header: Vehiculos Dropdown- Mazda CX5");


        // Mazda CX9

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("MazdaCX9_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("MazdaCX9_prod_url"), driver,"Global Header: Vehiculos Dropdown- Mazda CX9");


        // Mazda MX5

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),1000, driver);
        link_test.clicklink(propsmmx.getProperty("MazdaMX5_click"),1000, driver);
        link_test.linkcompare(propsmmx.getProperty("MazdaMX5_prod_url"), driver,"Global Header: Vehiculos Dropdown- Mazda MX5");


        // Mazda MX5 RF

        link_test.clicklink(propsmmx.getProperty("vehiculos_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("MazdaMX5RF_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("MazdaMX5RF_prod_url"), driver,"Global Header: Vehiculos Dropdown- Mazda MX5 RF");


    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }


}
