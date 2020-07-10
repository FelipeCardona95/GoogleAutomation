package test.controllers;


import felipe.framework.core.BaseTest;
import org.junit.Assert;
import test.page.GoogleHomePage;

public class GoogleHomeController extends BaseTest {

    private static final String URL = "http://www.google.com/";

    private static GoogleHomePage googleHomePage;

    public GoogleHomeController(){
        super();
    }

    public void goToGoogle() {
        googleHomePage = new GoogleHomePage(getDriver());
        startWebApp(URL);
    }

    public void searchInGoogleBar(String bookName) {
        googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.sendSearchBarText(bookName);
        googleHomePage.clickElement(googleHomePage.getSearchButton());
    }

    public void verifyResults() {
        try {
            googleHomePage.waitForResults();
        }catch (Exception e){
            Assert.fail("Error found getting results");

        }
    }


    public void goToFirstResult(String expectedResult) {
        try {
            googleHomePage.waitForFirstResult();
            String firstResultText = googleHomePage.getFirstResultText();
            Assert.assertTrue("The first result its not the expected \n Expected: "+expectedResult +"\n"+"Found: "+firstResultText,firstResultText.contains(expectedResult));
            googleHomePage.clckFirstResult();
        }catch (AssertionError e){
            getDriver().close();
            throw new AssertionError(e);
        }

    }

    public void verifyCurrentPage(String expectedPageTitle) {
        try {
            String title = getDriver().getTitle();
            Assert.assertTrue(title.contains(expectedPageTitle));
        }catch (AssertionError e){
            getDriver().close();
            throw new AssertionError("The title page is not the expected one");
        }
        getDriver().close();
    }

    public void typeAndWatchSuggestions(String searchWord) {
        googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.sendSearchBarText(searchWord);
        googleHomePage.waitForSuggestions();
    }

    public void goFirstSuggestion() {
        googleHomePage.goFirstSuggestion();
    }
}
