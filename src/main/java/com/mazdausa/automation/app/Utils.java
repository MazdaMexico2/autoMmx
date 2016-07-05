package com.mazdausa.automation.app;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by gabriela.rojas on 7/4/16.
 */
public class Utils {

    public Properties getConfigProperties(String configName) {
        Properties configProps = new Properties();

        try{
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("./" + configName);
            configProps.load(in);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return configProps;
    }

}
