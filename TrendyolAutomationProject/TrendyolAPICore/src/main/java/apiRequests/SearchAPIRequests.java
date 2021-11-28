package apiRequests;

import apiBuilder.ApiRequest;
import apiBuilder.GetAPIBuilder;
import apiConfig.APIPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.junit.Assert;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SearchAPIRequests {


    public static Response getSearchAPIWithKeyword(String keyword) {
        String requestUrl = new ApiRequest
                .ApiRequestBuilder()
                .baseUrl(APIPath.apiPath.BaseURL)
                .serviceEndpoint(APIPath.apiPath.serviceEndpoint)
                .build()
                .generateRequestString();

        GetAPIBuilder getAPIBuilder = new GetAPIBuilder();
        Response response = RestAssured
                .given()
                .queryParams(getAPIBuilder.getSampleSearchRequest(keyword))
                .when()
                .get(requestUrl)
                .then()
                .contentType(ContentType.HTML)
                .extract()
                .response();

        return response;
    }
    public static Response getSearchAPIWithEmptyParameters() {
        String requestUrl = new ApiRequest
                .ApiRequestBuilder()
                .baseUrl(APIPath.apiPath.BaseURL)
                .serviceEndpoint(APIPath.apiPath.serviceEndpoint)
                .build()
                .generateRequestString();

        GetAPIBuilder getAPIBuilder = new GetAPIBuilder();
        Response response = RestAssured
                .given()
                .queryParams(getAPIBuilder.getEmptyRequest())
                .when()
                .get(requestUrl)
                .then()
                .contentType(ContentType.HTML)
                .extract()
                .response();

        return response;
    }
    public static ValidatableResponse convertToValidatableResponse(Response response){
        return response.then().log().all();
    }
    public static void checkTitleWithKeyword(Response response,String title){
          XmlPath htmlPath = new XmlPath(HTML, response.getBody().asString());
          String responseTitle = htmlPath.getString("html.head.title");
          Assert.assertThat(responseTitle, StringContains.containsString(title));
    }
    public static void checkIsResponseTrueLanguage(Response response,String language){
        XmlPath htmlPath = new XmlPath(HTML, response.getBody().asString());
        String responseLanguage = htmlPath.getString("html.@lang");
        Assert.assertEquals(responseLanguage,language);
    }
    public static void checkIsSearchRequestStatusCodeSuccessfull(Response response){
        Assert.assertEquals(response.getStatusCode(),200);
    }
    public static void checkIsResponseTimeNotExceedMilisecond(Response response,long time){
        ValidatableResponse valRes = convertToValidatableResponse(response);
        valRes.time(Matchers.lessThan(time));
    }
    public static void checkIsCookieNotEmpty(Response response){
        Map<String, String> cookieValue = response.getCookies();
        Assert.assertTrue(cookieValue.size()>0);
    }
    public static void checkIsServerCorrect(Response response,String serverName){
        String server  = response.getHeader("Server");
        Assert.assertEquals(server,serverName);
    }

}
