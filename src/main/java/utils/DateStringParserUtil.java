package utils;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DateStringParserUtil {
    public Map getParsedDate(JSONObject jsonObject){
        String date = jsonObject.get("departureDate").toString();
        String[] splitDate = date.split("\\.");
        Map<String,Integer> parsedDate = new HashMap<>();
        parsedDate.put("month",Integer.parseInt(splitDate[0]));
        parsedDate.put("day",Integer.parseInt(splitDate[1]));
        parsedDate.put("year",Integer.parseInt(splitDate[2]));
        return parsedDate;
    }

    public Integer getMonth(JSONObject jsonObject){
        Map<String,Integer> month = getParsedDate(jsonObject);
        return month.get("month")-1;
    }

    public Integer getDay(JSONObject jsonObject){
        Map<String,Integer> month = getParsedDate(jsonObject);
        return month.get("day");
    }

    public Integer getYear(JSONObject jsonObject){
        Map<String,Integer> month = getParsedDate(jsonObject);
        return month.get("year");
    }
}
