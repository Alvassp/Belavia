package core.webelementwrapper;

import org.openqa.selenium.WebElement;

public class Element {
    protected WebElement webElement;

    public Element(WebElement webElement){
        this.webElement = webElement;
    }

    public void click(){
        webElement.click();
    }

    public void clear(){
        webElement.clear();
    }

    public void setText(String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

}
