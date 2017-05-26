package Testcases.mx.footer;

import Testsuites.ReadProperties;
import Testsuites.LinkVerificationTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by nserralde on 5/19/17.
 */
public class footerTestLinks {

    private LinkVerificationTest link_test;


    private ReadProperties propsmmx;


    WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {

        //Mac path
        //System.setProperty("webdriver.chrome.driver", "chromedriver");
        // PC path
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        //driver = new SafariDriver();

    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {
        link_test = new LinkVerificationTest();

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test*/
        driver.get("https://www.mazda.mx/");

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,3550)");
        Thread.sleep(5000);

        //distribuidores
        link_test.clicklink("distribuidores_footer",3000, driver);
        link_test.linkcompare("https://www.mazda.mx/localizar-distribuidor", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        //facebook
        link_test.clicklink("a[href*='https://www.facebook.com/mazdamexico']",3000, driver);
        link_test.linkcompare("https://www.mazda.mx/contactanos", driver);

        //twitter
        link_test.clicklink("a[href*='https://twitter.com/mazdaoficial']",3000, driver);
        link_test.linkcompare("https://twitter.com/mazdaoficial", driver);

        //instagram
        link_test.clicklink("a[href*='https://www.instagram.com/mazdaoficial/']",3000, driver);
        link_test.linkcompare("https://www.instagram.com/mazdaoficial/", driver);

        //contactanos
        link_test.clicklink("a[href*='/contactanos']",3000, driver);
        link_test.linkcompare("https://www.mazda.mx/contactanos", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        //terms and conditions
        link_test.clicklink("a[href*='/site/terminos-y-condiciones']",3000, driver);
        link_test.linkcompare("https://www.facebook.com/mazdamexico", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        //privacy policies
        link_test.clicklink("a[href*='/site/politica-de-privacidad']",3000, driver);
        link_test.linkcompare("https://www.mazda.mx/site/politica-de-privacidad", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        //site map
        link_test.clicklink("a[href*='/mapa-sitio']",3000, driver);
        link_test.linkcompare("https://www.mazda.mx/mapa-sitio", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
