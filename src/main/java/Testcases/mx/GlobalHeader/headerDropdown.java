package Testcases.mx.GlobalHeader; /**
 * Created by alina.viquez on 5/1/17.
 */
import Testsuites.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

//pablo
public class headerDropdown {

    private Properties propsmmx;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();

        this.propsmmx = readprops.getConfigProperties("properties/GlobalHeader.properties");

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
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();

        //Test Alina #2

    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test */
        driver.get("https://www.mazda.mx");

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        //jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(2000);

        List<WebElement> menu = driver.findElements(By.cssSelector(".mdp-navigation-global__menu ul li"));
        for(int i =0;i<menu.size();i++) {
            menu.get(i).click();

            //String elementClass= menu.get(i).getAttribute("class");

            //if (elementClass != null && elementClass.contains("active")){
            //   menu.get(i).click();
            //   System.out.print(" Dropdown of position"  + i + " displays ok ->");
            //}else{
            // System.out.print(" Drop down is not displaying or this position does not have dropdown");
            }
        }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }


}