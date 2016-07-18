package com.mazdausa.automation.testables;

import com.mazdausa.automation.panels.PanelGlobalHeader;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Created by gabriela.rojas on 7/11/16.
 */
public class Homepage extends TestableSection {

    public Homepage() {
        System.out.println("Starting Suite1");

    }

    public void execute(WebDriver prodDriver, Properties props){

        PanelGlobalHeader panel1 = new PanelGlobalHeader();
        Boolean panelGlobalHeader = panel1.Execute(prodDriver,props);
        System.out.println("GlobalVehiclelink: " + ((panelGlobalHeader) ? "PASS" : "FAIL"));
    }

}