package TestCases.Footer;

import Config.BaseTest;
import Config.json.JsonConfig;
import TestSuites.LinkVerificationTest;
import TestSuites.ReadProperties;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by nserralde on 5/19/17.
 */
public class footerTestLinks extends BaseTest {

    private LinkVerificationTest link_test;
    WebDriver driver;

    @BeforeTest
    public void setup() throws Exception {

        driver = super.getWebDriver();
    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {

        /**
         * In this section we should define the json file that we need to use, also you should define the objects to call
         * the list of element in the same variable. example "footercssselectors" and "footerurls".
         */

        JSONObject footerdata = new JsonConfig().getJsonInfo(System.getProperty("user.dir") +
                "/jsonConfig/footersection.json");
        JSONObject footercssselectors = (JSONObject)footerdata.get("footercssselectors");
        JSONObject footerurls = (JSONObject)footerdata.get("footerurls");

        /**
         * This method is to define the environment path to use in the test cases, this is only for images and src
         * information for the links verification.
         */

        String environment = super.defineEnvironmentPath();
        link_test = new LinkVerificationTest();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        /* Define URL to test*/
        super.getEnvUrl(driver);

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,5550)");

        //distribuidores
        link_test.clicklink((String)footercssselectors.get("distribuidores"),3000, driver);
        link_test.linkcompare(environment + footerurls.get("distribuidores"), driver,"Footer: Distribuidores");
        Thread.sleep(2000);
        Reporter.log(environment + footerurls.get("distribuidores") + "Pass");
        link_test.returnpage(environment, driver);
        jse.executeScript("window.scrollBy(0,5550)");
        Thread.sleep(2000);

        //facebook
        link_test.clicklink((String)footercssselectors.get("facebook"),3000, driver);
        link_test.linkcompare((String)footerurls.get("facebook"), driver,"Footer: Facebook");
        Reporter.log(environment + footerurls.get("facebook") + "Pass");
        link_test.returnpage(environment, driver);
        jse.executeScript("window.scrollBy(0,5550)");

        //twitter
        link_test.clicklink((String)footercssselectors.get("twitter"),3000, driver);
        link_test.linkcompare((String)footerurls.get("twitter"), driver,"Footer: Twitter");
        Reporter.log(environment + footerurls.get("twitter") + "Pass");
        link_test.returnpage(environment, driver);
        jse.executeScript("window.scrollBy(0,5550)");

        //instagram
        link_test.clicklink((String)footercssselectors.get("instagram"),3000, driver);
        link_test.linkcompare((String)footerurls.get("instagram"), driver,"Footer: Instagram");
        Reporter.log(environment + footerurls.get("instagram") + "Pass");
        link_test.returnpage(environment, driver);
        jse.executeScript("window.scrollBy(0,5550)");

        //contactanos
        link_test.clicklink((String)footercssselectors.get("contactanos"),3000, driver);
        link_test.linkcompare(environment + footerurls.get("contactanos"), driver,"Footer: Contactanos");
        Reporter.log(environment + footerurls.get("contactanos") + "Pass");
        Thread.sleep(2000);
        link_test.returnpage(environment, driver);
        jse.executeScript("window.scrollBy(0,5550)");

        //terms and conditions
        link_test.clicklink((String)footercssselectors.get("terms_conditions"),3000, driver);
        link_test.linkcompare(environment + footerurls.get("terms_conditions"), driver,"Footer: Terms and Conditions");
        Reporter.log(environment + footerurls.get("terms_conditions") + "Pass");
        Thread.sleep(2000);
        link_test.returnpage(environment, driver);
        jse.executeScript("window.scrollBy(0,5550)");

        //privacy policies
        link_test.clicklink((String)footercssselectors.get("politicas"),3000, driver);
        link_test.linkcompare(environment + footerurls.get("politicas"), driver,"Footer: Privacy Policies");
        Reporter.log(environment + footerurls.get("politicas") + "Pass");
        Thread.sleep(2000);
        link_test.returnpage(environment, driver);
        jse.executeScript("window.scrollBy(0,5550)");

        //site map
        link_test.clicklink((String)footercssselectors.get("mapa"),3000, driver);
        link_test.linkcompare(environment + footerurls.get("mapa"), driver,"Footer: Site Map");
        Reporter.log(environment + footerurls.get("mapa") + "Pass");
        Thread.sleep(2000);
        link_test.returnpage(environment, driver);
    }

   @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
