package utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class PropsHandlerUtil {
    JSONParser parser;

    public JSONObject getProperties(String config_file_name) {
        parser = new JSONParser();
        JSONObject jsonObject = null;

        try {
            jsonObject = (JSONObject)parser.parse(new FileReader(config_file_name));
        }catch (FileNotFoundException|ParseException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}
