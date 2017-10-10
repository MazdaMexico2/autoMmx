package Config.json;

import org.json.simple.JSONObject;

/**
 * Created by gerardo.soto on 10/10/17.
 */
public interface JsonOperations {
    /**
     * The read method for the IO module, independent of the context.
     * @return Hastable with all the values from the data file.
     */
    public JSONObject getJsonInfo(String filePath);
}
