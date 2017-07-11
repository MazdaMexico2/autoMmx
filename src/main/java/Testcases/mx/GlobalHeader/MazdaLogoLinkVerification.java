package Testcases.mx.GlobalHeader; /**
 * Created by Pablo on 18/5/2017.
 */
import Testsuites.LinkVerificationTest;
import Testsuites.selectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Testsuites.ReadProperties;

import java.io.IOException;
import java.util.Properties;



public class MazdaLogoLinkVerification {

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
        Thread.sleep(5000);

        //link1
     link_test.clicklink(".mazda-logo",2000, driver);
     link_test.linkcompare("https://www.mazda.mx/", driver);
     link_test.returnpage("https://www.mazda.mx/", driver);
    // link 2

    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    }
