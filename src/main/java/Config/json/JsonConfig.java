package Config.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Reporter;
import java.io.FileReader;

/**
 * Created by gerardo.soto on 10/10/17.
 */
public class JsonConfig implements JsonOperations {
    private JSONParser jsonParser = new JSONParser();

    public JSONObject getJsonInfo(String filePath) {
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(new FileReader(filePath));
        } catch (Exception exception) {
            System.out.println("There is an error with the file located on: '" + filePath + "' - " +
                    "a null object is returned. The error is: \n" + exception.getMessage());
            return jsonObject;
        }
        return jsonObject;
    }
}
