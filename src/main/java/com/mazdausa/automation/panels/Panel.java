package com.mazdausa.automation.panels;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Created by gabriela.rojas on 6/29/16.
 */
abstract public class Panel {
    WebDriver prodDriver;
    Properties props;

    public abstract void prepare();

    public String output(){
        return "";
    }

    public void flush(){

    }
}
