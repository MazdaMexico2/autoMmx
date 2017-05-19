import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class vehiculosdrpodowlinktest {

    private LinkVerificationTest link_test;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void setUp() throws IOException {
        // System.setProperty("webdriver.chrome.driver", "chromedriver");

        // PC path
        // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        //driver = new SafariDriver();
        configFile = new Properties();
    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {
        link_test = new LinkVerificationTest();

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test */
        driver.get("https://www.mazda.mx");

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        //jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(5000);

        //Mazda 2

        link_test.clicklink(".mdp-navigation-global__menu-link-1",2000, driver);
        link_test.clicklink("a[href*='https://www.mazda.mx:443/vehiculos/mazda-2']",2000, driver);
        link_test.linkcompare("https://www.mazda.mx/vehiculos/mazda-2", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        // Mazda 3 sedan

        link_test.clicklink(".mdp-navigation-global__menu-link-1",2000, driver);
        link_test.clicklink("a[href*='https://www.mazda.mx:443/vehiculos/mazda-3-sedan']",2000, driver);
        link_test.linkcompare("https://www.mazda.mx/vehiculos/mazda-3-sedan", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        // Mazda 3 hatchback

        link_test.clicklink(".mdp-navigation-global__menu-link-1",2000, driver);
        link_test.clicklink("a[href*='https://www.mazda.mx:443/vehiculos/mazda-3-hatchback']",2000, driver);
        link_test.linkcompare("https://www.mazda.mx/vehiculos/mazda-3-hatchback", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        // Mazda 6

        link_test.clicklink(".mdp-navigation-global__menu-link-1",2000, driver);
        link_test.clicklink("a[href*='https://www.mazda.mx:443/vehiculos/mazda-6']",2000, driver);
        link_test.linkcompare("https://www.mazda.mx/vehiculos/mazda-6", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        // Mazda CX3

        link_test.clicklink(".mdp-navigation-global__menu-link-1",2000, driver);
        link_test.clicklink("a[href*='https://www.mazda.mx:443/vehiculos/cx-3']",2000, driver);
        link_test.linkcompare("https://www.mazda.mx/vehiculos/cx-3", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        // Mazda CX5

        link_test.clicklink(".mdp-navigation-global__menu-link-1",2000, driver);
        link_test.clicklink("a[href*='https://www.mazda.mx:443/vehiculos/cx-5']",2000, driver);
        link_test.linkcompare("https://www.mazda.mx/vehiculos/cx-5", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        // Mazda CX9

        link_test.clicklink(".mdp-navigation-global__menu-link-1",2000, driver);
        link_test.clicklink("a[href*='https://www.mazda.mx:443/vehiculos/cx-9']",2000, driver);
        link_test.linkcompare("https://www.mazda.mx/vehiculos/cx-9", driver);
        link_test.returnpage("https://www.mazda.mx/", driver);

        // Mazda MX5



        // Mazda MX5 RF


    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }







}
