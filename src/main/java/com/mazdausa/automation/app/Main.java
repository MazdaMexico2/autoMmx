package com.mazdausa.automation.app;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by gabriela.rojas on 6/28/16.
 */
public class Main {
    //TESTING
    //TESTING DELLYSGUI
    //TESTING ALI
    //TEST SEBAS


    private static Properties config;

    public static void main(String[] args) {
        System.out.println("Mazdausa.com 2.0 Automation Test!" );
        Utils utils = new Utils();

        //Parse arguments into map
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
