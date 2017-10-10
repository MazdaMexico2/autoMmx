package Config.json;

import org.json.simple.JSONObject;

/**
 * Created by gerardo.soto on 10/10/17.
 */
public class JsonContext {
    private JsonOperations jsonOperations;

    /**
     * The class constructor.
     * @param jsonOperations The object that implements the JsonOperations interface that will perform a specific
     *                      action.
     */
    public JsonContext(JsonOperations jsonOperations) {
        this.jsonOperations = jsonOperations;
    }

    /**
     * The read strategy that will be used for the ConfigurationFile object.
     * @return The Hashtable containing all the data retrieved from the file.
     */
    public JSONObject retrieveClassNames(String filePath) {
        return this.jsonOperations.getJsonInfo(filePath);
    }
}
