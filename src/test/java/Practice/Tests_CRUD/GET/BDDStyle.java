package Practice.Tests_CRUD.GET;

import io.restassured.RestAssured;

public class BDDStyle {
    public static void main(String[] args) {


        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/560037")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

}
