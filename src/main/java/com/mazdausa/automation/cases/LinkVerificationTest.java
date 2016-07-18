package com.mazdausa.automation.cases;

import com.mazdausa.automation.app.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by gabriela.rojas on 6/29/16.
 */
public class LinkVerificationTest extends TestCase {
    Utils utils = new Utils();
    @Override
    public void prepare() {

    }

    @Override
    public boolean test() {
        return false;
    }

//    public class LinkVerificationTest extends BaseTest {
//
//        private WebElement element = null;
//
//        public LinkVerificationTest(WebDriver webDriver) {
//            this.setDriver(webDriver);
//        }
//        public Boolean test(int searchContext, String contextValue, String targetURL, boolean alertBoolean) {
//
//            try {
//                SearchContext clickLink = new SearchContext(searchContext, contextValue);
//                element = getWebElement(clickLink);
//                element.click();
//                try {
//                    Thread.sleep(2500);
//                    if (alertBoolean) {
//                        Alert alert = driver.switchTo().alert();
//                        alert.accept();
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (targetURL.compareTo(driver.getCurrentUrl()) == 0) {
//                    testResult = true;
//                } else {
//                    testResult = false;
//                    System.out.println("Target URL = " + targetURL);
//                    System.out.println("Current URL = " + driver.getCurrentUrl());
//                }
//            } catch (Exception e) {
//                testResult = false;
//                System.out.println(e);
//                e.printStackTrace();
//            }
//            return testResult;
//        }



    }
