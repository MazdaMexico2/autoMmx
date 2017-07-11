package Testcases.mx.Homepage;

import Testsuites.selectBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Testsuites.LinkVerificationTest;
import Testsuites.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by alina.viquez on 6/7/17.
 */
public class LinkVerificationHP {

    private Properties propsmmx;
    private LinkVerificationTest link_test;
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
    public void OpenBrowser() throws IOException, InterruptedException {
        link_test = new LinkVerificationTest();

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test */
        driver.get(propsmmx.getProperty("prod_home_url"));

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        //jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(1000);


        //Module #1: Mazda CX5 CTA

        WebElement heroCTA = driver.findElement(By.className(propsmmx.getProperty("heroCTA")));
        heroCTA.click();
        Thread.sleep(2000);
        link_test.linkcompare(propsmmx.getProperty("Hero_cta_url_prod"), driver,"Home Page: Module #1 Mazda CX5 CTA");


        //Modulo #3: Touts links (Mazda6, MazdaCX9, Mazda MX5-RF)

        //We use List web element because we are using the same class for the three vehicles (touts)
        List<WebElement> touts = driver.findElements(By.className(propsmmx.getProperty("Touts_links")));
        touts.get(0).click();
        link_test.linkcompare(propsmmx.getProperty("Tout_mazda6_prod"),driver,"Home Page:Modulo #3 Touts links- Mazda6");
        Thread.sleep(4000);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);
        Thread.sleep(5000);

        //We use List web element because we are using the same class for the three vehicles (touts)
        List<WebElement> touts1 = driver.findElements(By.className(propsmmx.getProperty("Touts_links")));
        touts1.get(1).click();
        link_test.linkcompare(propsmmx.getProperty("Tout_mazdaCX9_prod"),driver,"Home Page:Modulo #3 Touts links- Mazda CX9");
        Thread.sleep(4000);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);
        Thread.sleep(5000);

        //We use List web element because we are using the same class for the three vehicles (touts)
        List<WebElement> touts2 = driver.findElements(By.className(propsmmx.getProperty("Touts_links")));
        touts2.get(2).click();
        link_test.linkcompare(propsmmx.getProperty("Tout_mazdaMX5_prod"),driver,"Home Page:Modulo #3- Touts links- Mazda MX5");
        Thread.sleep(4000);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);
        Thread.sleep(5000);


        //Module #4: CONOCELO button

        jse.executeScript("window.scrollBy(0,1950)");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(propsmmx.getProperty("Conocelo_cta"))).click();
        Thread.sleep(2000);
        link_test.linkcompare(propsmmx.getProperty("Conocelo_url_prod"), driver,"Home Page:Module #4 CONOCELO button");
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        //Module #5: Shopping Tools links (Configura, Cotiza, Compara)

        List<WebElement> ShoppingLinks = driver.findElements(By.className(propsmmx.getProperty("Shopping_tools_links")));

        ShoppingLinks.get(0).click();
        Thread.sleep(2000);
        link_test.linkcompare(propsmmx.getProperty("Configura_link_prod"), driver,"Home Page: Module #5 Shopping Tools Configura");
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        List<WebElement> ShoppingLinks1 = driver.findElements(By.className(propsmmx.getProperty("Shopping_tools_links")));
        ShoppingLinks1.get(1).click();
        Thread.sleep(2000);
        link_test.linkcompare(propsmmx.getProperty("Cotizar_link_prod"), driver,"Home Page: Module #5 Shopping Tools Cotiza");
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);

        List<WebElement> ShoppingLinks2 = driver.findElements(By.className(propsmmx.getProperty("Shopping_tools_links")));
        ShoppingLinks2.get(2).click();
        Thread.sleep(2000);
        link_test.linkcompare(propsmmx.getProperty("Compara_Link_prod"), driver,"Home Page: Module #5 Shopping Tools Compara");
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);


        //Module #6: Skyactive
        jse.executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(propsmmx.getProperty("Skyactive_cta"))).click();
        Thread.sleep(2000);
        link_test.linkcompare(propsmmx.getProperty("Skyactive_url_prod"), driver,"Home Page: Module #6 Skyactive");
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }


}

