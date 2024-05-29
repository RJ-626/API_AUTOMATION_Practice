package Practice.Tests_CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyle {
@Test
    public void NonBDDStylepositive(){

        RequestSpecification r= RestAssured.given();

        String payload="\n" +
                "  {\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"}";
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        Response response=r.when().post();

        ValidatableResponse validatableresponce= response.then();
        String responseString= response.asString();
        System.out.println(responseString);
        validatableresponce.statusCode(200);


    }
}
