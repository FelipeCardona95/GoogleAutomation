package test.page;

import felipe.framework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;



public class GoogleHomePage extends BasePage {



    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='tfB0Bf']//input[@name='btnK']")
    private WebElement searchButton;

    @FindBy(name = "q")
    private WebElement searchBar;

    @FindBy(xpath = "//ul[@class='erkvQe']//li")
    private List<WebElement> suggestionsList;

    @FindBy(id = "rso")
    private List<WebElement> resultsList;

    @FindBy(xpath = "//div[contains(@class, 'suggestions')]")
    private WebElement suggestion;

    @FindBy(id = "rso")
    private WebElement result;

    public WebElement getSuggestion() {
        return suggestion;
    }

    public WebElement getResult() {
        return result;
    }

    public void waitForResults(){
        waitFor(result,5);
    }


    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public List<WebElement> getSuggestionsList() {
        return suggestionsList;
    }

    public List<WebElement> getResultsList() {
        return resultsList;
    }

    public void waitForFirstResult() {
        waitFor(getResultsList().get(0).findElement(By.tagName("h3")),5);
    }

    public WebElement getFirstResult() {
        return getResultsList().get(0).findElement(By.tagName("h3"));
    }

    public String getFirstResultText(){
        return getFirstResult().getText();
    }

    public void clickElement(WebElement element){
        click(element,5);
    }

    public void sendSearchBarText(String searchWord){
        sendText(searchBar,searchWord,5);
    }

    public void waitForSuggestions() {
        waitFor(suggestion,5);
    }

    public void clckFirstResult(){
        clickElement(getFirstResult());
    }

    public void goFirstSuggestion(){
        clickElement(getSuggestionsList().get(0));
    }


}
