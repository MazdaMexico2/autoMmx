package SauceLabsTest;

import Config.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.io.IOException;

/**
 * Created by gerardo.soto on 9/29/17.
 */
public class GerarTest extends BaseTest {

    WebDriver driver;

    @BeforeTest
    public void setup() throws Exception {

        driver = super.getWebDriver();
    }

    @Test
    public void OpenBrowser() throws IOException, InterruptedException {

        super.getEnvUrl(driver);
    }

    @AfterTest
    public void tearDown() throws Exception {

        driver.quit();
    }
}
