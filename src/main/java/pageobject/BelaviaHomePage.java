package pageobject;

import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class BelaviaHomePage extends BasePage{
    @FindBy (xpath = "//a[contains(text(),'Book Flights')]")
    private WebElement bookFlightsButton;

    @FindBy(xpath = "//input[@id = 'OriginLocation_Combobox']")
    private WebElement originalLocationInput;

    @FindBy(xpath = "//input[@id = 'DestinationLocation_Combobox']")
    private WebElement destinationLocationInput;

    @FindBy(xpath = "//label[@for = 'JourneySpan_Ow']")
    private WebElement oneWayRadioButton;

    @FindBy(xpath = "//label[@for = 'JourneySpan_Rt']")
    private WebElement returnRadioButton;

    @FindBy(xpath = "//div[@id = 'Passengers']/a")
    private WebElement passengersComboBox;

    @FindBy(xpath = "//button[@class = 'button btn-large btn btn-b2-green ui-corner-all']")
    private WebElement searchButton;

    @FindBy(xpath = "(//div[@class='wrapper ui-trigger-input ui-date-input']/a)[1]")
    private WebElement departureDateCalendar;

    @FindBy(xpath = "(//div[@class='wrapper ui-trigger-input ui-date-input']/a)[2]")
    private WebElement returnDateCalendar;

    @FindBy(xpath = "//input[@id='Adults']/../a[2]")
    private WebElement adultPlusButton;

    @FindBy(xpath = "//input[@id='Children']/../a[2]")
    private WebElement childrenPlusButton;

    @FindBy(xpath = "//input[@id='Infants']/../a[2]")
    private WebElement infantsPlusButton;

     @FindAll({
             @FindBy(xpath = "//span[@class = 'spin-text']/span[@class = 'value']")
     })
     private List<WebElement> numberOfPassengers;

     public HashMap getCurrentNumSelectedPassengers(){
         HashMap<String, Integer> numOfPassengers = new HashMap<>();
         numOfPassengers.put("Adult",Integer.parseInt(numberOfPassengers.get(0).getText()));
         numOfPassengers.put("Children",Integer.parseInt(numberOfPassengers.get(1).getText()));
         numOfPassengers.put("Infants",Integer.parseInt(numberOfPassengers.get(2).getText()));
         return numOfPassengers;
     }

    public BelaviaHomePage(){
        PageFactory.initElements(driver,this);
    }

    public void clickOnBookFlightsButton(){
        bookFlightsButton.click();
    }

    public BelaviaHomePage setOriginalLocationInput(String originalLocation){
        Actions action = new Actions(driver);
        action.sendKeys(originalLocationInput,originalLocation)
                .sendKeys(Keys.ENTER).build().perform();
        return this;
    }

    public BelaviaHomePage setDestinationLocationInput(String destinationLocation){
        Actions action = new Actions(driver);
        action.sendKeys(destinationLocationInput,destinationLocation)
                .sendKeys(Keys.ENTER).build().perform();
        return this;
    }

    public BelaviaHomePage clickOnOneWayRadioButton(boolean oneWay){
        if(oneWay)
            oneWayRadioButton.click();
        return this;
    }

    public void clickOnPassengersComboBox(){
        passengersComboBox.click();
    }

    public BelaviaHomePage setNumPassengers(Map<String, Integer> passengers){
        clickOnPassengersComboBox();
        HashMap<String,Integer> curretSelectedNumOfPassengers = getCurrentNumSelectedPassengers();
        for(Map.Entry<String,Integer> numPassengers:passengers.entrySet()){
            switch (numPassengers.getKey()){
                case "Adult":while (passengers.get("Adult") != curretSelectedNumOfPassengers.get("Adult")){
                    adultPlusButton.click();
                    curretSelectedNumOfPassengers = getCurrentNumSelectedPassengers();
                };break;
                case "Children":while (passengers.get("Children") != curretSelectedNumOfPassengers.get("Children")){
                    childrenPlusButton.click();
                    curretSelectedNumOfPassengers = getCurrentNumSelectedPassengers();
                };break;
                case "Infants":while (passengers.get("Infants") != curretSelectedNumOfPassengers.get("Infants")){
                    infantsPlusButton.click();
                    curretSelectedNumOfPassengers = getCurrentNumSelectedPassengers();
                };break;
                default:break;
            }
        }
        return this;
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public BelaviaHomePage setDepartureDate(JSONObject jsonObject){
        departureDateCalendar.click();
        new CalendarPage().setMonth(jsonObject);
        return this;
    }



}
