package Resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.FileReader;

public class JsonUtils {

    public static JsonNode testdata;
  static String JsonReader;
    private static void loadData() {
        if (testdata == null) {
            try {


               ObjectMapper mapper = new ObjectMapper();
              File file = new File(System.getProperty("user.dir") + "/src/test/resources/testData.json");
               testdata = mapper.readTree(file);
            } catch (Exception e) {
                throw new RuntimeException(" error in reading JSON file: " + e.getMessage(), e);
            }
        }

    }
    public  String getValue(String section, int index, String key) {
        loadData();
        return testdata.get(section).get(index).get(key).asText();
    }






}
