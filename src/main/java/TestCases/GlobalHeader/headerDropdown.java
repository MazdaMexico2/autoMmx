package TestCases.GlobalHeader; /**
 * Created by alina.viquez on 5/1/17.
 */
import TestSuites.ReadProperties;
import TestSuites.selectBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

//pablo
public class headerDropdown {

    private Properties propsmmx;
    private selectBrowser defineBrowser;

    WebDriver driver;
    Properties configFile;

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
        ReadProperties readp = new ReadProperties();
        this.propsmmx = readp.getConfigProperties("properties/Config.properties");

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