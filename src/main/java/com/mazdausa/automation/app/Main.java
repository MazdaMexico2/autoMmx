package com.mazdausa.automation.app;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import com.mazdausa.automation.*;
import com.mazdausa.automation.cases.HoverVerificationTest;
import com.mazdausa.automation.cases.LinkVerificationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by gabriela.rojas on 6/28/16.
 */
public class Main {
    /* TESTING
    TESTING DELLYSGUI
    TESTING ALI
    TEST SEBAS
    TEST PABLO
    TEST VINCE4
     */

    private static Properties config;

    public static void main(String[] args) {
        //Logger log = new Looger();

        System.out.println("Mazdausa.com 2.0 Automation Test!" );

        //Utils Class we are uploading the properties file with the project variables
        Utils utils = new Utils();
        Properties props=utils.getConfigProperties("data.properties"); // archivo de propiedades
        ExecState.setProps(props);

        //Webdriver declaration, page assignment
        String ProdPageUrl; //declare the string
        WebDriver driver = new FirefoxDriver(); // webdriver creation
        ExecState.setDriver(driver);
        ProdPageUrl = props.getProperty("musa_homepage_url_prod"); // site load
        driver.get(ProdPageUrl); //site load


        /* Parse arguments into map */
        HashMap<String, String> arguments = parseArgs(args);

        //Configure execution
        //Set config file
        if(arguments.get("--config") == null){
            System.out.println("Config file not specified");
            return;
        } else{
            config = utils.getConfigProperties(arguments.get("--config"));
            if(config == null){
                System.out.println("Config file not found");
                return;
            }
        }
        //Set output type
        //Set console_output method

        ArrayList<String> sections = utils.getStringList(config.getProperty("sections"));
        try {
            Class current_section = Class.forName("com.mazdausa.automation.panels." + sections.get(0));
            Object section = current_section.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(arguments.get("--config"));
     //   System.out.println(arguments.get("--output"));

        //WebDriver appDriver = new FirefoxDriver();
    }



    private static HashMap<String, String> parseArgs(String[] args){
        HashMap<String, String> map = new HashMap<String, String>();
        int equal;
        String flag;
        String value;

        for(int i = 0; i < args.length; i++){
            equal = args[i].indexOf('=');
            if(equal >= 0){ //argument with value
                flag = args[i].substring(0, equal);
                value = args[i].substring(equal + 1, args[i].length());
                map.put(flag, value);
            }else{ //argument without value
                map.put(args[i], "");
            }
        }

        return map;
    }
}
