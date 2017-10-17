package TestCases.GlobalHeader;

import Config.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import TestSuites.ReadProperties;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by alina.viquez on 10/09/17.
 */
public class HomapageImagePanel1 extends BaseTest {

    private Properties propsmmx;
    WebDriver driver;

    @BeforeTest
    public void setup() throws Exception {

        ReadProperties readprops = new ReadProperties();
        this.propsmmx = readprops.getConfigProperties("properties/GlobalHeader.properties");
        driver = super.getWebDriver();
    }

    @Test
    public void loadImage() throws IOException, InterruptedException {

        super.getEnvUrl(driver);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement imgsrc = driver.findElement(By.className(propsmmx.getProperty("imglocator")));

        if (imgsrc.getAttribute("src").toString().equals(propsmmx.getProperty("panel1"))) {

            System.out.println( "The scr image is correct " + propsmmx.getProperty("panel1"));
            Reporter.log("Pass: scr image is " + propsmmx.getProperty("panel1"));
        } else {

            System.out.println( "The scr image is incorrect " + propsmmx.getProperty("panel1"));
            Reporter.log("Fail: scr is do not match");
        }
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
