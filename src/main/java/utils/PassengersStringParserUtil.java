package utils;

import businessobject.BaseBookFlightObject;
import org.json.simple.JSONObject;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class PassengersStringParserUtil {
    public Map<String, Integer> getPassengers(String unparsedData){
        String[] unseporatedArray = unparsedData.split("[{}\\[\\],:\"]");
        ArrayList<String> seporatedDataList = splitString(unseporatedArray);
        Map<String,Integer> seporatedData = fillMap(seporatedDataList);
        return seporatedData;
    }

    public ArrayList<String> splitString(String[] unseporatedArray){
        ArrayList<String> seporatedStringAray = new ArrayList<>();
        for(String s:unseporatedArray){
            if(s.isEmpty()){
                continue;
            }if(s.length() > 0){
                seporatedStringAray.add(s);
            }
        }
        return seporatedStringAray;
    }

    public Map<String,Integer>fillMap(ArrayList<String> seporatedDataList){
        Map<String,Integer> seporatedData = new HashMap<>();
        for(int i = 0; i < seporatedDataList.size(); i++)
            if(seporatedDataList.get(i).length() > 1){
                seporatedData.put(seporatedDataList.get(i),Integer.parseInt(seporatedDataList.get(i+1)));
            }
            return seporatedData;
    }
}
