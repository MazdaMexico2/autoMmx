package Testsuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

import java.util.Properties;

/**
 * Created by alina.viquez on 7/2/17.
 */
public class selectBrowser {

    private Properties propsmmx;
    private String type;
    private WebElement element;
    private String link;

    public WebDriver setupBrowser( String browser, String device ) throws Exception {

        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {

            //define path for geckodriver
            if( device.equalsIgnoreCase("pc")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
            } else {
                System.setProperty("webdriver.gecko.driver", "geckodriver");
            }

             return new FirefoxDriver();
        }

        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {

            //set path to chromedriver.exe
            if( device.equalsIgnoreCase("pc")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", "chromedriver");
            }

            //create chrome instance
            return new ChromeDriver();
        }

        //Check if parameter passed as 'IE'
        else if (browser.equalsIgnoreCase("ie")) {

            //set path to IE.exe
            System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");

            //create IE instance
            return new InternetExplorerDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
    }

}