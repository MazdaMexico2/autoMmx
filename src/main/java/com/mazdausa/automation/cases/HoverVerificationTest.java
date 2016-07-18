package com.mazdausa.automation.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import com.mazdausa.automation.app.Utils;


/**
 * Created by gabriela.rojas on 7/8/16.
 */
public class HoverVerificationTest extends TestCase {

    private WebElement element;

    Utils utils = new Utils();

   public HoverVerificationTest(WebDriver webDriver) {
        utils.setDriver(webDriver);
    }


    @Override
    public void prepare() {



    }

    @Override
    public boolean test() {

        return false;
    }

    public Boolean testCollection (WebElement parent, String search_type, String search_value, String search_property){
        Boolean test_result = true;
        ArrayList<WebElement> elements;
        switch (search_type){
            case "tag":
                elements = (ArrayList<WebElement>) parent.findElements(By.tagName(search_value));
                break;
            case "class":
                elements = (ArrayList<WebElement>) parent.findElements(By.className(search_value));
                break;
            default:
                elements = new ArrayList<WebElement>();
                break;
        }
        for(WebElement element: elements){
            try {
                String initialPropertyValue = element.getCssValue(search_property);
                Actions action = new Actions(utils.driver);
                action.moveToElement(element).build().perform();
                Thread.sleep(1000);
                String hoveredPropertyValue = element.getCssValue(search_property);
                if(initialPropertyValue.equals(hoveredPropertyValue)){
                    test_result = false;
                }
            } catch(Exception ex) {
                System.out.println(ex.getMessage());

            }
        }
        return test_result;
    }

}
