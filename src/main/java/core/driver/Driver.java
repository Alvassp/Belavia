package core.driver;

import constant.jsonfilepath.JsonFilePathConstants;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropsHandlerUtil;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static JSONObject jsonObject;
    private static PropsHandlerUtil propsHandlerUtil = new PropsHandlerUtil();
    private static WebDriver driver;
    private static Driver instance;

    private Driver() {}

    public static synchronized WebDriver getDriver() {
        if(driver == null){
            synchronized (Driver.class){
                if(driver == null){
                    jsonObject = propsHandlerUtil.getProperties(JsonFilePathConstants.CONFIG_FILE_NAME);
                    driver = initDriver(jsonObject);
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                }
            }
        }
        return driver;
    }

    public static WebDriver initDriver(JSONObject jsonObject){
        switch (jsonObject.get("browser").toString()){
            case "Chrome" : return new ChromeDriver();
            case "FireFox": return new FirefoxDriver();
            default:break;
        }
        return null;
    }

    public static void tearDown(){
        getDriver().close();
    }


}
