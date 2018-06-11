package services.bookflights;


import businessobject.BaseBookFlightObject;
import org.json.simple.JSONObject;
import pageobject.BelaviaHomePage;
import pageobject.SearchedResultPage;
import utils.BookFlightDataParserUtil;
import utils.DateStringParserUtil;
import utils.PassengersStringParserUtil;
import utils.PropsHandlerUtil;

import java.util.HashMap;
import java.util.Map;

public class BookFlightsFillFormService {
    DateStringParserUtil dateParser = new DateStringParserUtil();
    PropsHandlerUtil propsHandlerUtil = new PropsHandlerUtil();
    JSONObject jsonObject = new JSONObject();



    public BaseBookFlightObject buildBookFlightObject(JSONObject jsonObject){
        BookFlightDataParserUtil parserUtil = new BookFlightDataParserUtil();
        BaseBookFlightObject baseBookFlightObject = BaseBookFlightObject.newBuilder()
                   .getFrom(parserUtil.getFrom(jsonObject))
                   .getTo(parserUtil.getTo(jsonObject))
                   .getOneway(parserUtil.getOneway(jsonObject))
                   .getdepartureDate(parserUtil.getDepartureDate(jsonObject))
                   .getPassengers(parserUtil.getPassengers(jsonObject))
                   .getRedeemPoints(parserUtil.getRedeemPoints(jsonObject))
                   .build();
        return baseBookFlightObject;
    }

    public void fillFlightsForm(String jsonFilePath){
        Map<String, Integer> passengers = new HashMap<>();
        BelaviaHomePage belaviaHomePage = new BelaviaHomePage();
        jsonObject = propsHandlerUtil.getProperties(jsonFilePath);
        BaseBookFlightObject baseBookFlightObject = buildBookFlightObject(jsonObject);
        PassengersStringParserUtil passengersParser = new PassengersStringParserUtil();

        passengers = passengersParser.getPassengers(baseBookFlightObject.getPassengers());
        belaviaHomePage.clickOnBookFlightsButton();
        belaviaHomePage.setOriginalLocationInput(baseBookFlightObject.getFrom())
                        .setDestinationLocationInput(baseBookFlightObject.getTo())
                        .clickOnOneWayRadioButton(baseBookFlightObject.getOneway())
                        .setNumPassengers(passengers)
                        .setDepartureDate(jsonObject)
                        .clickOnSearchButton();
    }

    public boolean verifyInListAtLeastOneResult(){
        SearchedResultPage searchedResultPage = new SearchedResultPage();
        return searchedResultPage.getDepartureTime() > 10 && searchedResultPage.getNumOfResult()>0;
    }
}
