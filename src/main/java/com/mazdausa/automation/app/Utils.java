package com.mazdausa.automation.app;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by gabriela.rojas on 7/4/16.
 */
public class Utils {

    public WebDriver driver;

    public Properties getConfigProperties(String configName) {
        Properties configProps = new Properties();
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("./" + configName);
            configProps.load(in);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return configProps;
    }

    public ArrayList<String> getStringList(String data) {
        return new  ArrayList<String>(Arrays.asList(data.split(",")));
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {this.url = url;
//    }

}
