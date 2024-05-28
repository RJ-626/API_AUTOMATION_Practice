package Practice.Tests_CRUD.GET;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyleTestNG {

    @Test
    public void GetAllBookingspositive(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/2543");
        r.log().all().get();
        r.then().log().all().statusCode(200);

    }

    @Test
    public void GetAllBookingsnegative(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/-1");
        r.log().all().get();
        r.then().log().all().statusCode(404);

    }

    @Test
    public void GetAllBookingsnegative2(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/ABG56");
        r.log().all().get();
        r.then().log().all().statusCode(404);

    }
}
