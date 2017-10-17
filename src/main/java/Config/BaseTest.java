package Config;

import Config.json.JsonConfig;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


/**
 * Created by gerardo.soto on 10/4/17.
 */
public class BaseTest {

    /**
    * This code is to load the json file, make sure that you are adding the correct path. If you need to add more than
     * one file you should duplicate the JSONObject with new name and path.
    */

    static JSONObject data = new JsonConfig().getJsonInfo(System.getProperty("user.dir") +
            "/jsonConfig/config.json");

    /**
     * In this section We define the key access to run the test in sauceLabs.
     */

    public static final String USERNAME = (String) data.get("saucelabsuser");
    public static final String ACCESS_KEY = (String) data.get("saucelabsaccesskey");
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    /**
     * This method is the base to define the browser and which driver we want use. getWebDriver() is the only method
     * that you need put into @BeforeTest
     */

    public WebDriver getWebDriver() throws Exception {

        WebDriver driver;
        JSONObject sauceLabsInfo = (JSONObject)data.get("saucelabs");

        if ((boolean)data.get("remote")) {

            DesiredCapabilities caps = getDesiredCapabilities(data);
            caps.setCapability("platform", sauceLabsInfo.get("platform"));
            caps.setCapability("version", sauceLabsInfo.get("version"));
            caps.setCapability("screenResolution", sauceLabsInfo.get("screenResolution"));
            caps.setCapability("name", sauceLabsInfo.get("name"));
            driver = new RemoteWebDriver(new URL(URL), caps);

            return driver;

        } else {

            if (data.get("browser").equals("firefox")) {

                if( data.get("device").equals("pc")) {

                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
                } else {

                    System.setProperty("webdriver.gecko.driver", "geckodriver");
                }

                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "false");
                return new FirefoxDriver();
            }

            else if (data.get("browser").equals("chrome")) {

                if( data.get("device").equals("pc")) {

                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
                } else {

                    System.setProperty("webdriver.chrome.driver", "chromedriver");
                }

                return new ChromeDriver();
            }

            else if (data.get("browser").equals("ie")) {

                System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
                return new InternetExplorerDriver();

            } else {

                throw new Exception("Browser is not correct");
            }
        }
    }

    /**
     * This section define the browser to use in sauceLabs, please notice that the browser should be relative to
     * platform and version defined in the json file.
     */

    private DesiredCapabilities getDesiredCapabilities(JSONObject data){

        String browser = (String) data.get("browser");

        switch (browser.toLowerCase()){
            case "firefox":
                return DesiredCapabilities.firefox();
            case "chrome":
                return DesiredCapabilities.chrome();
            case "safari":
                return DesiredCapabilities.safari();
            case "ie":
                return DesiredCapabilities.internetExplorer();
            case "edge":
                return DesiredCapabilities.edge();
            default:
                return DesiredCapabilities.firefox();
        }
    }

    /**
     * This section define the URL to use, please notice that the driver is receiving from the testcase class.
     */

    public void getEnvUrl(WebDriver driver) throws InterruptedException {

        JSONObject urls = (JSONObject)data.get("urls");

        if (((String)data.get("environment")).toLowerCase().equals("stage")){

            driver.get((String) urls.get("stage"));
        } else {

            driver.get((String) urls.get("prod"));
        }
    }

    public String defineEnvironmentPath(){

        JSONObject urls = (JSONObject)data.get("urls");

        if (((String)data.get("environment")).toLowerCase().equals("stage")){

           return urls.get("stagePath").toString();
        } else {

            return urls.get("prod").toString();
        }
    }
}