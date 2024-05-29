package Practice.Tests_CRUD.PUT;

import groovyjarjarantlr4.runtime.Token;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class NonBddStyle {
@Test
    public void NonBDDStyle(){

        RequestSpecification requestSpecification;
        Response response;
        ValidatableResponse validatableResponse;
        String token="3c2b10b11edc64b";

        String payload="{\n" +
                "    \"firstname\" : \"Rahul\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking/694");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload).log().all();

        response=requestSpecification.when().put();
        validatableResponse=response.then().log().all().statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Rahul"));








    }
}
