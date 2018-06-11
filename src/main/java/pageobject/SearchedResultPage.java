package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchedResultPage extends BasePage {
    @FindBys({
            @FindBy(xpath = "//div[@id='outbound']/div[2]/following-sibling::div")
    })
    private List<WebElement> resultList;

    @FindBy(xpath = "//div[@class='departure']//strong")
    private WebElement departureLabel;

    public int getNumOfResult(){
        return resultList.size();
    }
    public SearchedResultPage(){
        PageFactory.initElements(BasePage.driver,this);

    }

    public int getDepartureTime(){
        String[] hours = departureLabel.getText().split("\\:");
        return Integer.parseInt(hours[0]);
    }
}
