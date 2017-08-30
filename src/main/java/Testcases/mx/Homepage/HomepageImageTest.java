package Testcases.mx.Homepage;

import Testsuites.ImageVerificationTest;
import Testsuites.ReadProperties;
import Testsuites.selectBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by alina.viquez on 6/8/17.
 */
public class HomepageImageTest {

    private Properties propsmmx;
    private ImageVerificationTest image_test;
    private selectBrowser defineBrowser;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();
        this.propsmmx = readprops.getConfigProperties("properties/Homepage.properties");

    }


    @BeforeMethod
    public void setup() throws Exception {

        defineBrowser = new selectBrowser();
        driver = defineBrowser.setupBrowser(propsmmx.getProperty("browser"),propsmmx.getProperty("device"));

    }


    @Test
    public void TestImage() throws IOException, InterruptedException{

        ReadProperties readp = new ReadProperties();
        this.propsmmx = readp.getConfigProperties("properties/Config.properties");
        image_test = new ImageVerificationTest();

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        /* Define URL to test */
        if (propsmmx.getProperty("url").contains("https://www.mazda.mx")){
            driver.get("https://www.mazda.mx");
        }if (propsmmx.getProperty("url").contains("https://mazdamx:mazda217@stage.mazda.mx/")){
            driver.get("https://mazdamx:mazda217@stage.mazda.mx/");
            Thread.sleep(3000);
            driver.get("https://stage.mazda.mx/");
            Thread.sleep(3000);
        }else {
            System.out.print("Please define the URL");
        }

        /*Maximize Window and load*/
        driver.manage().window().maximize();

        //MODULE #1
        /*Compare image from path, over module 1 the image display only for mobile version in this moment by default display a video*/
        image_test.imageTest(propsmmx.getProperty("homeModule1testImgPth_prod"),propsmmx.getProperty("homeModule1testImgSrc_prod"), driver, "Module #1");


        //MODULE #3

        //TOUT Mazda 6
        jse.executeScript("window.scrollBy(0,1300)");
        Thread.sleep(0);
        image_test.imageTest(propsmmx.getProperty("toutMazda6"),propsmmx.getProperty("toutMazda6Url"), driver,"MODULE #3:TOUT Mazda 6");

        //TOUT Mazda CX9
        image_test.imagebyposition(propsmmx.getProperty("toutMazdaCx9"),propsmmx.getProperty("toutMazdaCx9Url"),driver,"MODULE #3:TOUT Mazda CX9");
     // List<WebElement> toutList = driver.findElements(By.cssSelector(propsmmx.getProperty("toutMazdaCx9")));
        //toutList.get(1).getAttribute("src").equals(propsmmx.getProperty("toutMazdaCx9Url"));

        //TOUT Mazda MX5
        image_test.imageTest(propsmmx.getProperty("toutMazdaMx5"),propsmmx.getProperty("toutMazdaMx5Url"),driver,"MODULE #3:TOUT MX5");

        //MODULE #4

        //Background Image Jinba Ittai
        image_test.imageTestBkg(propsmmx.getProperty("JINBAITTAISrc"),propsmmx.getProperty("JINBAITTAIUrl"),driver,"MODULE #4");

        //MODULE #5
        // Configura

        image_test.imageTest(propsmmx.getProperty("configurasrc"),propsmmx.getProperty("configuraurl"), driver,"MODULE #5: Configura");

       //Cotiza
       image_test.imagebytagname(propsmmx.getProperty("cotizasrc"),propsmmx.getProperty("cotizaurl"), driver,"MODULE #5: Cotiza");


   //Compara
        image_test.imageTest(propsmmx.getProperty("comparasrc"),propsmmx.getProperty("comparaurl"),driver,"MODULE #5:Compara");

        //MODULE #6
        image_test.imageTestBkg(propsmmx.getProperty("skyactivimgsrc"),propsmmx.getProperty("skyactivimgurl"),driver,"MODULE #6");


    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }


}
