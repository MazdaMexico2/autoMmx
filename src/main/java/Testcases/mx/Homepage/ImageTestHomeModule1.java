package Testcases.mx.Homepage;

import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by nserralde on 6/14/17.
 */
public class ImageTestHomeModule1 {
    private Properties propsmmx;
    private LinkVerificationTest link_test;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();

        this.propsmmx = readprops.getConfigProperties("properties/Homepage.properties");

    }

    @BeforeMethod
    public void setUp() throws IOException {

        if( propsmmx.getProperty("device").equalsIgnoreCase("PC")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }

        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        //driver = new SafariDriver();

    }

    @Test
    public void TestImage() throws IOException, InterruptedException{

        link_test = new LinkVerificationTest();

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        /* Define URL to test */
        driver.get(propsmmx.getProperty("prod_home_url"));

        /*Maximize Window and load*/
        driver.manage().window().maximize();

        /*Compare image from path, over module 1 the image display only for mobile version in this moment by default display a video*/
        link_test.imageTest(propsmmx.getProperty("homeModule1testImgPth_prod"),propsmmx.getProperty("homeModule1testImgSrc_prod"), 2000, driver);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
