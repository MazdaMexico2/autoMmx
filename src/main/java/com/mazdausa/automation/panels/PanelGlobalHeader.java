package com.mazdausa.automation.panels;

import com.mazdausa.automation.cases.HoverVerificationTest;
import com.mazdausa.automation.panels.PanelGlobalHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

/**
 * Created by gabriela.rojas on 6/29/16.
 */
public class PanelGlobalHeader extends Panel {

    public PanelGlobalHeader(){}


    public boolean Execute( WebDriver prodDriver, Properties props)  {

        System.out.println("Starting Suite1");

        //hover verification globalHeader parent
        WebElement globalHeaderlink = prodDriver.findElement(By.xpath(props.getProperty("globalheader_parent")));
        HoverVerificationTest globalHoverParent = new HoverVerificationTest(prodDriver);
        Boolean globaHoverResult = globalHoverParent.testCollection(globalHeaderlink, "tag", "a", "color");
        //System.out.println("GlobalVehiclelink: " + ((globaHoverResult) ? "PASS" : "FAIL"));

        return globaHoverResult;

    }

    @Override
    public void prepare() {

    }
}