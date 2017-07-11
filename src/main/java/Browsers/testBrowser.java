package Browsers; /**
 * Created by alina.viquez on 5/1/17.
 */

import java.io.IOException;
import java.util.Properties;

import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import Testsuites.selectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//pablo
public class testBrowser {
    private LinkVerificationTest link_test;

    WebDriver driver;
    Properties configFile;
    private selectBrowser defineBrowser;
    private Properties propsmmx;


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

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test*/
        driver.get("https://www.mazda.mx/");

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
       // driver.close();
    }
}