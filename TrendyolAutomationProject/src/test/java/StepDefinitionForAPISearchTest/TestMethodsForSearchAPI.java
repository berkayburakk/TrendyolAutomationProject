package StepDefinitionForAPISearchTest;

import apiRequests.SearchAPIRequests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TestMethodsForSearchAPI {


    public static Response response;

    @When("^Perform get operation for SEARCH with \"([^\"]*)\" keyword$")
    public void performSearchOperationWithKeyword(String keyword) {
        response = SearchAPIRequests.getSearchAPIWithKeyword(keyword);
    }
    @When("^Perform get operation for SEARCH with empty parameter$")
    public void performSearchOperationWithoutParameter() {
        response = SearchAPIRequests.getSearchAPIWithEmptyParameters();
    }
    @And("^Checking response title is match with \"([^\"]*)\" keyword$")
    public void checkTitleIsMatchWithKeyword(String keyword) {
        SearchAPIRequests.checkTitleWithKeyword(response,keyword+" Modelleri, Fiyatları - Trendyol");
    }

    @And("^Checking response time is lower than with keyword and \"(.*)\" milisecond$")
    public void checkTitleIsMatchWithKeyword(long time) {
        SearchAPIRequests.checkIsResponseTimeNotExceedMilisecond(response,time);
    }
    @Then("^Checking response status code is successfull$")
    public void checkResponseCodeStatusIsSuccessfull() {
        SearchAPIRequests.checkIsSearchRequestStatusCodeSuccessfull(response);
    }

    @And("^Checking response cookie is not empty")
    public void checkTitleIsMatchWithKeyword() {
        SearchAPIRequests.checkIsCookieNotEmpty(response);
    }

    @And("^Checking api server running with \"([^\"]*)\"$")
    public void checkIsServerTrue(String serverName) {
        SearchAPIRequests.checkIsServerCorrect(response,serverName);
    }

    @And("^Checking response language matches with \"([^\"]*)\" countrycode$")
    public void checkResponseLanguageMatchesWithOurKeyword(String languageName) {
        SearchAPIRequests.checkIsResponseTrueLanguage(response,languageName);
    }

}
