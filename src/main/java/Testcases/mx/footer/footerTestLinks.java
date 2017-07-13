package Testcases.mx.footer;

import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import Testsuites.selectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by nserralde on 5/19/17.
 */
public class footerTestLinks {
    private Properties propsmmx;
    private LinkVerificationTest link_test;
    private selectBrowser defineBrowser;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();
        this.propsmmx = readprops.getConfigProperties("properties/GlobalFooter.properties");

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


        /* Define URL to test*/
        driver.get(propsmmx.getProperty("prod_home_url"));

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,3550)");
        Thread.sleep(5000);

        //distribuidores
        link_test.clicklink(propsmmx.getProperty("distribuidores_footer"),3000, driver);
        link_test.linkcompare(propsmmx.getProperty("prod_distribuidores_url"), driver,"Footer: Distribuidores");
        Thread.sleep(2000);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        //facebook
        link_test.clicklink(propsmmx.getProperty("facebook_link"),3000, driver);
        link_test.linkcompare(propsmmx.getProperty("facebook_url"), driver,"Footer: Facebook");

        //twitter
        link_test.clicklink(propsmmx.getProperty("twitter_link"),3000, driver);
        link_test.linkcompare(propsmmx.getProperty("twitter_url"), driver,"Footer: Twitter");


        //instagram
        link_test.clicklink(propsmmx.getProperty("instagram_link"),3000, driver);
        link_test.linkcompare(propsmmx.getProperty("instagram_url"), driver,"Footer: Instagram");


        //contactanos
        link_test.clicklink(propsmmx.getProperty("contactanos_link"),3000, driver);
        link_test.linkcompare(propsmmx.getProperty("prod_contactanos_url"), driver,"Footer: Contactanos");
        Thread.sleep(2000);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        //terms and conditions
        link_test.clicklink(propsmmx.getProperty("terms_conditions_link"),3000, driver);
        link_test.linkcompare(propsmmx.getProperty("prod_terms_conditions_url"), driver,"Footer: Terms and Conditions");
        Thread.sleep(2000);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        //privacy policies
        link_test.clicklink(propsmmx.getProperty("privacy_policies_link"),3000, driver);
        link_test.linkcompare(propsmmx.getProperty("prod_privacy_policies_url"), driver,"Footer: Privacy Policies");
        Thread.sleep(2000);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        //site map
        link_test.clicklink(propsmmx.getProperty("site_map_link"),3000, driver);
        link_test.linkcompare(propsmmx.getProperty("prod_site_map_url"), driver,"Footer: Site Map");
        Thread.sleep(2000);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

    }

   @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
