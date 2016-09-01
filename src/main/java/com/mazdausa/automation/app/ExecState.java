package com.mazdausa.automation.app;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Created by gabriela.rojas on 7/19/16.
 */
public final class ExecState {

    private static WebDriver driver;
    private static Properties props;

    private ExecState(){}

    public static void setDriver(WebDriver d){
        driver = d;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setProps(Properties p){
        props = p;
    }

    public static Properties getProps(){
        return props;
    }
}
