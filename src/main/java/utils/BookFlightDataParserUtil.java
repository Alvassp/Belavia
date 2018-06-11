package utils;

import org.json.simple.JSONObject;

public class BookFlightDataParserUtil {
    public String getFrom(JSONObject jsonObject){
        return jsonObject.get("from").toString();
    }

    public String getTo(JSONObject jsonObject){
        return jsonObject.get("to").toString();
    }

    public boolean getOneway(JSONObject jsonObject){
        return Boolean.parseBoolean(jsonObject.get("oneway").toString());
    }

    public String getDepartureDate(JSONObject jsonObject){
        return jsonObject.get("departureDate").toString();
    }

    public String getPassengers(JSONObject jsonObject){
        return jsonObject.get("passengers").toString();
    }

    public boolean getRedeemPoints(JSONObject jsonObject){
        return Boolean.parseBoolean(jsonObject.get("redeemPoints").toString());
    }
}
