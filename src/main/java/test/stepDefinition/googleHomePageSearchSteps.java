package test.stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.controllers.GoogleHomeController;

public class googleHomePageSearchSteps {

    private GoogleHomeController googleHomeController;


    @Given("^the user is on the google home page$")
    public void theUserIsOnTheGoogleHomePage(){
        googleHomeController =  new GoogleHomeController();
        googleHomeController.goToGoogle();
    }

    @When("^the user searches for (.+) in the Search Bar$")
    public void theUserSearchesForInTheSearchBar(String bookname) {
        googleHomeController.searchInGoogleBar(bookname);

    }

    @When("^the suggestion list shows by the user typing (.+) on the search bar$")
    public void theSuggestionListShowsByTheUserTypingOnTheSearchBar(String searchWord) {
        googleHomeController.typeAndWatchSuggestions(searchWord);

    }

    @Then("^the user is gonna be redirect to the (.+) page$")
    public void theUserIsGonnaBeRedirectToThePage(String expectedPageTitle){
        googleHomeController.verifyCurrentPage(expectedPageTitle);


    }

    @And("^the results page shows$")
    public void theResultsPageShows() {
        googleHomeController.verifyResults();
    }

    @And("^the user clicks the first result being (.+)$")
    public void theUserClicksTheFirstResult(String expectedResult) {
        googleHomeController.goToFirstResult(expectedResult);
    }

    @And("^the user clicks the first suggestion$")
    public void theUserClicksTheFirstSuggestion() {
        googleHomeController.goFirstSuggestion();
    }

}
