package com.mazdausa.automation.cases;

import com.mazdausa.automation.app.ExecState;
import com.mazdausa.automation.app.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

/**
 * Created by gabriela.rojas on 6/29/16.
 */
public class LinkVerificationTest extends TestCase {

    private WebDriver driver;

    public LinkVerificationTest(){
        driver = ExecState.getDriver();
    }
    @Override
    public void prepare() {

    }

    @Override
    public boolean test() {
        return false;
    }

    public boolean testLink(WebElement element, String search_type, String search_value, String targetURL, boolean alertBoolean) {
        Boolean test_result = false;
        switch (search_type){
            case "tag":
                element = driver.findElement(By.tagName(search_value));
                break;
            case "class":
                element = driver.findElement(By.className(search_value));
                break;
            default:
              //  elements = new ArrayList<WebElement>();
                break;
        }

            try {
                element.click();
                if (targetURL.compareTo(driver.getCurrentUrl()) == 0) {
                    test_result = true;
            } else {
                    test_result = false;
                System.out.println("Target URL = " + targetURL);
                System.out.println("Current URL = " + driver.getCurrentUrl());
            }

            } catch(Exception ex) {
                System.out.println(ex.getMessage());

            }
        return test_result;
    }
}
