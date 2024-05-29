package Practice.Tests_CRUD.PATCH;

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
            String token="8718bdc587f180a";

            String payload="{\n" +
                    "    \"firstname\" : \"James\",\n" +
                    "    \"lastname\" : \"Brown\"\n" +
                    "}";
            requestSpecification= RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com");
            requestSpecification.basePath("booking/422");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.cookie("token",token);
            requestSpecification.body(payload).log().all();

            response=requestSpecification.when().patch();
            validatableResponse=response.then().log().all().statusCode(200);
            validatableResponse.body("firstname", Matchers.equalTo("James"));








        }
    }

