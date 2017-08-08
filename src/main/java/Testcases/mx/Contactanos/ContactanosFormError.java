        package Testcases.mx.Contactanos;

        import Testsuites.ImageVerificationTest;
        import Testsuites.LinkVerificationTest;
        import Testsuites.ReadProperties;
        import Testsuites.selectBrowser;
        import org.openqa.selenium.*;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Keyboard;
        import org.openqa.selenium.security.UserAndPassword;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Reporter;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;
        import org.openqa.selenium.Alert;

        import java.io.IOException;
        import java.util.Properties;



        import static org.openqa.selenium.Keys.*;
/**
 * Created by alina.viquez on 7/18/17.
 */
public class ContactanosFormError {

    private Properties propsmmx;
    private LinkVerificationTest link_test;
    private selectBrowser defineBrowser;
    private ImageVerificationTest image_test;

    WebDriver driver;
    Properties configFile;

    @BeforeMethod
    public void readprops() throws IOException {

        ReadProperties readprops = new ReadProperties();
        this.propsmmx = readprops.getConfigProperties("properties/GlobalFooter.properties");

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


        /* Define URL to test in STG environment, we need to call the path twice because first time you send the
        parameter and the second time the page load the style Note: The url with parameter should not be call form
        properties file*/
        driver.get("https://mazdamx:mazda217@stage.mazda.mx/");
        Thread.sleep(3000);
        driver.get("https://stage.mazda.mx/");
        Thread.sleep(3000);

        /*Maximize Window and load*/
        driver.manage().window().maximize();
        jse.executeScript("window.scrollBy(0,3500)");
        Thread.sleep(3000);

        driver.findElement(By.className(propsmmx.getProperty("contactanosLink"))).click();
        Thread.sleep(2000);
        driver.findElement(By.id("nombre")).sendKeys("Automated");
        Thread.sleep(2000);
        driver.findElement(By.id("apellido")).sendKeys("Test");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.id("email")).sendKeys("testqammx001@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("subject")).sendKeys("Test Subject");
        Thread.sleep(2000);
        driver.findElement(By.id("user-help-message")).sendKeys("This is a test message");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.className("checkbox")).click();
        Thread.sleep(3000);
        driver.findElement(By.className(propsmmx.getProperty("submitContactanosForm"))).click();
        Reporter.log("Pass: Submit Error Page Form "+ "<br>");
        Thread.sleep(5000);

        //Background image Test error page
        WebElement BkImgTest = driver.findElement(By.className(propsmmx.getProperty("error_page_img")));
        Reporter.log("Pass: Error page image verification. "+ "<br>");
        Thread.sleep(3000);

        //Error Page CTAs Test

        driver.findElement(By.cssSelector(propsmmx.getProperty("regresar_form_cta"))).click();
        Reporter.log("Pass: Regresar CTA "+ "<br>");
        Thread.sleep(3000);
        driver.findElement(By.className(propsmmx.getProperty("submitContactanosForm"))).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("CHAT")).click();
        Reporter.log("Pass: CHAT Cta. "+ "<br>");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}