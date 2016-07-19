package com.mazdausa.automation.panels;

import com.mazdausa.automation.app.ExecState;
import com.mazdausa.automation.cases.HoverVerificationTest;
import com.mazdausa.automation.cases.LinkVerificationTest;
import com.mazdausa.automation.panels.PanelGlobalHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

/**
 * Created by gabriela.rojas on 6/29/16.
 */
public class PanelGlobalHeader extends Panel {

    private WebDriver driver;

    public PanelGlobalHeader(){

        driver = ExecState.getDriver();
        props = ExecState.getProps();
        this.execute();
    }


    public void execute()  {

        System.out.println("Starting PanelGlobalHeader");

        //hover verification globalHeader parent
        WebElement globalHeaderlink = driver.findElement(By.xpath(props.getProperty("globalheader_parent")));
        HoverVerificationTest globalHoverParent = new HoverVerificationTest();
        Boolean globaHoverResult = globalHoverParent.testCollection(globalHeaderlink, "tag", "a", "color");
        System.out.println("Global Navigation Hover: " + ((globaHoverResult) ? "PASS" : "FAIL"));

        //Mazda_Logo Link verification
        WebElement globalHeaderlogo = driver.findElement(By.xpath(props.getProperty("mazda_logo")));
        LinkVerificationTest globalLogoLink = new LinkVerificationTest();
        Boolean globalLogoResult = globalLogoLink.testLink(globalHeaderlogo, "class", "mazda-logo__desktop",props.getProperty("musa_homepage_url_prod"),false);
        System.out.println("GlobalLogolink: " + ((globalLogoResult) ? "PASS" : "FAIL"));

    }

    @Override
    public void prepare() {

    }
}