package Practice.Tests_CRUD.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStyle {

        @Test
        public void NonBDDStyle(){

            RequestSpecification requestSpecification;
            Response response;
            ValidatableResponse validatableResponse;
            String token="3b581630d6ae984";

            requestSpecification= RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com");
            requestSpecification.basePath("booking/5063");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.cookie("token",token);


            response=requestSpecification.when().delete();
            validatableResponse=response.then().log().all().statusCode(201);
            //validatableResponse.body("firstname", Matchers.equalTo("Rahul"));








        }
    }

