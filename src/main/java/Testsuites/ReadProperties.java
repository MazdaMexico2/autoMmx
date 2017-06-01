package Testsuites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Pablo on 25/5/2017.
 */
public class ReadProperties {


    public Properties getConfigProperties(String configName) {
        Properties configProps = new Properties();
        try {

            File file = new File(configName);
            FileInputStream fileInput = new FileInputStream(file);
            configProps.load(fileInput);
            fileInput.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return configProps;
    }
}
