package fillformbookflight;


import basetest.BaseBelaviaTest;
import io.qameta.allure.*;
import services.bookflights.BookFlightsFillFormService;
import constant.jsonfilepath.JsonFilePathConstants;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BookFlightsFillFormTest extends BaseBelaviaTest {

    private BookFlightsFillFormService fillFormService = new BookFlightsFillFormService();
    @Feature("Что-то там")
    @Test(description = "verify that there at least 1 result and flight before 10 AM ")
    @Severity(SeverityLevel.BLOCKER)
    public void fillBookingFormCheckResult(){
        fillFormService.fillFlightsForm(JsonFilePathConstants.JSON_PATH);
        Assert.assertTrue(fillFormService.verifyInListAtLeastOneResult(),"Searched list is empty or flight after 10 AM!");
    }
}
