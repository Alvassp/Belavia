package pageobject;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DateStringParserUtil;

import java.util.Calendar;
import java.util.Locale;

import static core.driver.Driver.getDriver;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "(//span[@class = 'ui-datepicker-month'])[1]")
    private WebElement monthCurrentLabel;

    @FindBy(xpath = "(//span[@class = 'ui-datepicker-month'])[2]")
    private WebElement monthNextLabel;

    @FindBy(xpath = ".//div[@id='calendar']/div/div[1]//span[@class = 'ui-datepicker-year']")
    private WebElement yearFirstLabel;

    @FindBy(xpath = ".//div[@id='calendar']/div/div[2]//span[@class = 'ui-datepicker-year']")
    private WebElement yearSecondLabel;

    @FindBy(xpath = "//div[@id='calendar']//i[@class = 'icon-right-open']")
    private WebElement nextMonthButton;

    String dayFromFirstTable = "//div[@id='calendar']/div/div[1]//tr[%1d]/td[%1d]/a";
    String dayFromSecondTable = "//div[@id='calendar']/div/div[2]//tr[%1d]/td[%1d]/a";

    static Calendar calendar;
    CalendarPage(){
        PageFactory.initElements(BasePage.driver,this);
    }

    public void setDay(Calendar calendar){
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String dayXpath = String.format(dayFromFirstTable,weekOfMonth,dayOfWeek);
        int searchResult = Integer.parseInt(getDriver().findElement(By.xpath(dayXpath)).getText());
        if(dayOfMonth == searchResult){
            getDriver().findElement(By.xpath(dayXpath)).click();
        }
    }

    public void setMonth(JSONObject jsonObject){
        calendar = Calendar.getInstance();
        DateStringParserUtil dateParser = new DateStringParserUtil();
        String currentMonth = monthCurrentLabel.getText();
        String nextMonth = monthNextLabel.getText();

        calendar.set(dateParser.getYear(jsonObject),dateParser.getMonth(jsonObject),dateParser.getDay(jsonObject));
        String searchedMonth = calendar.getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.getDefault());

        if(searchedMonth.equalsIgnoreCase(currentMonth)){
            setDay(calendar);
            return;
        }if(searchedMonth.equalsIgnoreCase(nextMonth)){
            setDay(calendar);
            return;
        }else {
            nextMonthButton.click();
            setMonth(jsonObject);
        }
    }
}
