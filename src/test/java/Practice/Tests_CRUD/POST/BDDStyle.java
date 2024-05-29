package Practice.Tests_CRUD.POST;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDStyle {

    @Test
    public void BDDStylepositive(){

        String payload="\n" +
                "  {\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"}";


        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/auth")
                .contentType(ContentType.JSON).log().all().body(payload)
                .when().post()
                .then().log().all().statusCode(200);
    }
}
