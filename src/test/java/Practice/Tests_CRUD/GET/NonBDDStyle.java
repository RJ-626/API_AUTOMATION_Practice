package Practice.Tests_CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {

    public static void main(String[] args) {


        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/2543");
        r.log().all().get();
        r.then().log().all().statusCode(200);

    }
}
