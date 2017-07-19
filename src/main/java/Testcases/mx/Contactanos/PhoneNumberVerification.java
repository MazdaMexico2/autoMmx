package Testcases.mx.Contactanos;

import Testsuites.LinkVerificationTest;
import Testsuites.PhoneLinkVerification;
import Testsuites.ReadProperties;
import Testsuites.selectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
        phonelink_test = new PhoneLinkVerification();

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test */
        driver.get(propsmmx.getProperty("prod_contactanos_url"));

        phonelink_test.phoneclicklink(propsmmx.getProperty("phonelink_classname"),100,driver);

   phonelink_test.phonealert(driver);
}



















}