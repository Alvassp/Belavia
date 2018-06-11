package basetest;

import constant.jsonfilepath.JsonFilePathConstants;
import core.driver.Driver;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.PropsHandlerUtil;
import utils.UserBaseDBUtil;

public class BaseBelaviaTest{
    private JSONObject jsonObject;
    private PropsHandlerUtil propsHandlerUtil = new PropsHandlerUtil();

    @BeforeTest
    public void init() throws ClassNotFoundException {
        jsonObject = propsHandlerUtil.getProperties(JsonFilePathConstants.CONFIG_FILE_NAME);
        Driver.getDriver().get(jsonObject.get("URL").toString());
        UserBaseDBUtil.connectToMySQLDB();
    }

    @AfterTest
    public void closeBrowser(){
        Driver.tearDown();
    }
}
