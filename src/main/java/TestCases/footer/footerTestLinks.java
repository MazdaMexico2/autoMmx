package TestCases.footer;

import Config.BaseTest;
import TestSuites.LinkVerificationTest;
import TestSuites.ReadProperties;
import TestSuites.selectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by nserralde on 5/19/17.
 */
public class footerTestLinks extends BaseTest {

    private Properties propsmmx;
    private LinkVerificationTest link_test;
    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();
        this.propsmmx = readprops.getConfigProperties("properties/GlobalFooter.properties");
    }

    @BeforeTest
    public void setup() throws Exception {

        driver = super.getWebDriver();
    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {

        ReadProperties readp = new ReadProperties();
        this.propsmmx = readp.getConfigProperties("properties/Config.properties");
        link_test = new LinkVerificationTest();
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test*/
        super.getEnvUrl(driver);

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

   @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
