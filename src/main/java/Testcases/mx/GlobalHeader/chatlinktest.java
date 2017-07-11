package Testcases.mx.GlobalHeader;

import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import Testsuites.selectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by alina.viquez on 7/6/17.
 */
public class chatlinktest {
        private Properties propsmmx;
        private LinkVerificationTest link_test;
        private selectBrowser defineBrowser;

        WebDriver driver;

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
            Thread.sleep(3000);

            //Chat

            link_test.clicklink(propsmmx.getProperty("Chatnav_click"),1000, driver);
            link_test.linkcompare(propsmmx.getProperty("Chatnav_prod_url"), driver);
            link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);


        }

        @AfterMethod
        public void tearDown() {

            driver.quit();
        }


    }

