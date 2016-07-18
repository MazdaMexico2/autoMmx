package com.mazdausa.automation.app;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import com.mazdausa.automation.*;
import com.mazdausa.automation.cases.HoverVerificationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by gabriela.rojas on 6/28/16.
 */
public class Main {
    //TESTING
    //TESTING DELLYSGUI
    //TESTING ALI
    //TEST SEBAS
// TEST PABLO
    // TEST VINCE

    private static Properties config;

    public static void main(String[] args) {
        //Logger log = new Looger();

        System.out.println("Mazdausa.com 2.0 Automation Test!" );

        //Utils Class we are uploading the properties file with the project variables
        Utils utils = new Utils();
        Properties props=utils.getConfigProperties("data.properties"); // archivo de propiedades

        //Webdriver declaration, page assignment
        String ProdPageUrl; //declare the string
        WebDriver prodDriver = new FirefoxDriver(); // webdriver creation
        ProdPageUrl = props.getProperty("musa_homepage_url_prod"); // site load
        prodDriver.get(ProdPageUrl); //site load

        //hover verification globalHeader parent
        WebElement globalHeaderlink = prodDriver.findElement(By.xpath(props.getProperty("globalheader_parent")));
        HoverVerificationTest globalHoverParent = new HoverVerificationTest(prodDriver);
        Boolean globaHoverResult = globalHoverParent.testCollection(globalHeaderlink, "tag", "a", "color");
        System.out.println("GlobalVehiclelink: " + ((globaHoverResult) ? "PASS" : "FAIL"));




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

        ArrayList<String> suites = utils.getStringList(config.getProperty("suites"));
        try {
            Class current_suite = Class.forName("com.mazdausa.automation.testables." + suites.get(0));
           Object suite = current_suite.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(arguments.get("--config"));
        System.out.println(arguments.get("--output"));

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
