package Testcases.mx.GlobalHeader;


        import Testsuites.LinkVerificationTest;
        import Testsuites.ReadProperties;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

        import java.io.IOException;
        import java.util.Properties;
/**
 * Created by Pablo on 1/6/2017.
 */
public class distribuidoreslinktest {
    private Properties propsmmx;
    private LinkVerificationTest link_test;

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
        link_test = new LinkVerificationTest();

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        /* Define URL to test */
        driver.get(propsmmx.getProperty("prod_home_url"));

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        //jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(3000);

       //distribuidores

        link_test.clicklink(propsmmx.getProperty("Distribuidoresnav_click"),1000, driver);
        link_test.linkcompare(propsmmx.getProperty("Distribuidoresnav_prod_url"), driver);
        link_test.returnpage(propsmmx.getProperty("prod_home_url"), driver);


    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }







}