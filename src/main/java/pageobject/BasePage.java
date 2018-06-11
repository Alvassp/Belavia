package pageobject;

import core.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage{

    protected static WebDriver driver;

    @FindBy(xpath = "//img[@alt='BELAVIA - Belarusian Airlines']")
    private WebElement belaviaTitleLabel;

    @FindBy(xpath = "//a[@id='select-lang']")
    private WebElement languageDropDownList;

    @FindBy(xpath = "//a[@id='select-member']")
    WebElement signInDropDownList;

    @FindBy(xpath = "//a[@id='select-main-menu']")
    WebElement menuDropDownList;

    public BasePage(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

}
