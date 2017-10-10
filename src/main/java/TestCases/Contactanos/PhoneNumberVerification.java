package TestCases.Contactanos;

import TestSuites.PhoneLinkVerification;
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
 * Created by Pablo on 13/7/2017.
 */
public class PhoneNumberVerification {

    private Properties propsmmx;
    private PhoneLinkVerification phonelink_test;
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
    public void OpenBrowser() throws IOException, InterruptedException {

        ReadProperties readp = new ReadProperties();
        this.propsmmx = readp.getConfigProperties("properties/Config.properties");
        phonelink_test = new PhoneLinkVerification();
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

        phonelink_test.phonesrccompare(propsmmx.getProperty("phonenumber"),driver);


}


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }





}