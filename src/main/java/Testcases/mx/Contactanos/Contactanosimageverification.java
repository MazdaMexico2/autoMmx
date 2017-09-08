package Testcases.mx.Contactanos;

import Testsuites.ReadProperties;
import Testsuites.selectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Pablo on 19/7/2017.
 */
public class Contactanosimageverification {
    private Properties propsmmx;
    private ImageVerificationTest image_test;
    private selectBrowser defineBrowser;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();
        this.propsmmx = readprops.getConfigProperties("properties/Contactanos.properties");


    }


    @BeforeMethod
    public void setup() throws Exception {

        defineBrowser = new selectBrowser();
        driver = defineBrowser.setupBrowser(propsmmx.getProperty("browser"),propsmmx.getProperty("device"));

    }


    @Test
    public void TestImage() throws IOException, InterruptedException{

        ReadProperties readp = new ReadProperties();
        this.propsmmx = readp.getConfigProperties("properties/Config.properties");

        image_test = new ImageVerificationTest();

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
        image_test.imageTestBkg(propsmmx.getProperty("contactanosimage_src"),propsmmx.getProperty("contactanosimage_url"),driver,"Contactanos Image");
}



}