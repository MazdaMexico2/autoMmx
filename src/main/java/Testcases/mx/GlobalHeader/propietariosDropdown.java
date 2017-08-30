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
public class propietariosDropdown {

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


        // Define URL to test
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


        // Conoce Tu Mazda

        link_test.clicklink(propsmmx.getProperty("Propietarios_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Conocetumazda_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Conocetumazda_prod_url"), driver,"Global Header: Propetarios Dropdown- Conoce tu Mazda");


        // Mantenimiento

        link_test.clicklink(propsmmx.getProperty("Propietarios_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Mantenimiento_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Mantenimiento_prod_url"), driver,"Global Header: Propetarios Dropdown- Mantenimiento");


        // Programas de Servicio

        link_test.clicklink(propsmmx.getProperty("Propietarios_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Programasdeservicio_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Programasdeservicio_prod_url"), driver,"Global Header: Propetarios Dropdown- Programas de Servicios");


        // Derechos del Cliente

        link_test.clicklink(propsmmx.getProperty("Propietarios_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Derechoscliente_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Derechoscliente_prod_url"), driver,"Global Header: Propetarios Dropdown- Derechos del Cliente");


        // Garantia

        link_test.clicklink(propsmmx.getProperty("Propietarios_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Garantia_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Garantia_prod_url"), driver,"Global Header: Propetarios Dropdown- Garantia");


        // Accesorios

        link_test.clicklink(propsmmx.getProperty("Propietarios_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Accesorios_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Accesorios_prod_url"), driver,"Global Header: Propetarios Dropdown- Accesorios");


        // Conoce tu Mazda Button

        link_test.clicklink(propsmmx.getProperty("Propietarios_dropdown"),2000, driver);
        link_test.clicklink(propsmmx.getProperty("Conocetumazdabutton_click"),2000, driver);
        link_test.linkcompare(propsmmx.getProperty("Conocetumazdabutton_prod_url"), driver,"Global Header: Propetarios Dropdown- Conoce tu Mazda Button");



    }
    @AfterMethod
    public void tearDown() {

        driver.quit();


    }
}