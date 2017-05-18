
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by Pablo on 17/5/2017.
 */

public class LinkVerificationTest {

    private WebDriver driver;
    private String type;
    private WebElement element;
    private String link;



    public void clicklink (String id, int wait){
        WebElement element = driver.findElement(By.cssSelector(id));
        element.click();
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public boolean linkcompare (String reference) {
        Boolean test_result = false;
        if(driver.getCurrentUrl().equals(reference)){
            test_result = true;
        }else{
            test_result = false;

    }

        return test_result;
}
    public void returnpage (String linkreturn){

        driver.get(linkreturn);


    }



}

